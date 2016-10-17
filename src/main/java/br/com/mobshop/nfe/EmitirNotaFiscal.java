package br.com.mobshop.nfe;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.jdom2.JDOMException;

import br.com.javac.v200.envinfe.TEnderEmi;
import br.com.javac.v200.envinfe.TEndereco;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Dest;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Det;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Det.Imposto;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Det.Imposto.COFINS;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Det.Imposto.COFINS.COFINSNT;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Det.Imposto.ICMS;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN500;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Det.Imposto.PIS;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Det.Imposto.PIS.PISNT;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Det.Prod;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Emit;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Ide;
import br.com.javac.v200.envinfe.TNFe.InfNFe.InfAdic;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Total;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Total.ICMSTot;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Transp;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Transp.Transporta;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Transp.Vol;
import br.com.javac.v200.envinfe.TUf;
import br.com.javac.v200.envinfe.TUfEmi;
import br.com.mobshop.ws.model.VendaAux;
import br.com.mobshop.ws.model.VendaItem;

public class EmitirNotaFiscal extends TimerTask{

	ChaveAcessoNfe acessoNfe;

	GerarNfeXML gerarNfeXML;

	AssinarNfeXML assinarNfeXML;

	EnviarNfe enviarNfe;
	
	ConsultaRetornoNfe consultaRetornoNfe;
	
	GerandoNfeProc gerandoNfeProc;
	
	private StringBuilder chaveAcesso = new StringBuilder();
	private StringBuilder nfeXML = new StringBuilder();
	private StringBuilder nfeXMLAssinado = new StringBuilder();
	private StringBuilder reciboNFe = new StringBuilder();
	private StringBuilder reciboRecepcao = new StringBuilder();	
	
	SimpleDateFormat formatDia = new SimpleDateFormat("yyyy-MM-dd");
	String hoje = formatDia.format(new Date());
	
	SimpleDateFormat formatHora = new SimpleDateFormat("hh:mm:ss");
	String hora = formatHora.format(new Date());
	
	static VendaAux vendaAux;
	static TimerTask task;
	
	public void schedullarEmissaoNota(VendaAux venda) {
			vendaAux = venda;
			task = new EmitirNotaFiscal();
			Timer timer = new Timer();
			Calendar executar = Calendar.getInstance();
			//executar.setHours(23);
			executar.set(Calendar.SECOND, executar.get(Calendar.SECOND)+10);
			//executar.setSeconds(00);
	    	timer.schedule(task, executar.getTime());
	}
	
		public void emitirNotaFiscal(VendaAux venda) throws JDOMException, IOException, InterruptedException , Exception{
			//System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");  
			Ide ide = this.dadosDeIdentificacao(venda);
			Dest dest =  this.dadosDoDestinatario(venda);
			Emit emit = this.dadosDoEmitente(venda);
			List<Det> dets = this.dadosDoProduto(venda);
			Total totaisNFe = this.totaisDaNFe(venda);
			Transp transp = this.dadosDoTransporte();
			InfAdic infAdic = this.informacoesAdicionais();
			
			acessoNfe = new ChaveAcessoNfe();

			gerarNfeXML = new GerarNfeXML();

			assinarNfeXML = new AssinarNfeXML();

			enviarNfe = new EnviarNfe();

			consultaRetornoNfe = new ConsultaRetornoNfe();

			gerandoNfeProc = new GerandoNfeProc();
			
			// 1 - Gerar chave de acesso
			chaveAcesso.append(acessoNfe.gerarChaveAcessoNfe(ide, emit));
			
			
			// 2 - Gerar Nfe
			nfeXML.append(gerarNfeXML.gerarNfe(chaveAcesso.toString(), "000005", ide, emit, dest, dets, totaisNFe, transp, infAdic));
			
			// 3- Assinar Nfe
			nfeXMLAssinado.append(assinarNfeXML.assinaEnviNFe(nfeXML.toString()));
			
			// 4 - Enviar NFe ao SEFAZ
			reciboNFe.append(enviarNfe.enviarNFE(NfeUtil.getCertificadoCliente(), 
								NfeUtil.SENHA_CERTIFICADO,
								nfeXMLAssinado.toString()));

			Thread.sleep(20000);
			
			reciboRecepcao = new StringBuilder();
			reciboRecepcao.append(consultaRetornoNfe.consultaNFE(chaveAcesso.toString().substring(3, chaveAcesso.toString().length())));
			
			String email = venda.getCliente().getEmail();
			NfeUtil.getDanfe(gerandoNfeProc.gerar(nfeXMLAssinado.toString(), reciboRecepcao.toString()), EmitirNotaFiscal.class.getResource("/mobshop.png").toString(), venda.getIdVenda().toString(), email);
			System.out.println("Nota e email enviados");
			task.cancel();
		}
		
		/** 
	     * B - Identificação da Nota Fiscal eletrônica 
	     * @return 
	     */  
	    public Ide dadosDeIdentificacao(VendaAux venda) {  
	        Ide ide = new Ide();  
	        ide.setCUF("35");  							// Código da UF do emitente do Documento Fiscal (35 - Sao Paulo).
	        ide.setCNF(NfeUtil.retornaNumeroCNF());  	// Código Numérico que compõe a Chave de Acesso. 
	        ide.setNatOp("5102");  						// Natureza da Operacao
	        ide.setIndPag("0");  						// Ind Pag
	        ide.setMod("55");  							// Modelo do Documento Fiscal.  
	        ide.setSerie("1");  						// Série do Documento Fiscal.  
	        ide.setNNF(String.valueOf(new Random().nextInt(999) + 100000)); // Número do Documento Fiscal. 
	        ide.setDEmi(hoje);  				// Data de Emissao
	        ide.setDSaiEnt(hoje);  				// Data de Saida
	        ide.setHSaiEnt(hora);  				// Hora de Saida
	        ide.setTpNF("1");  							// Tipo Nota fiscal
	        ide.setCMunFG("3550308");  					// Codigo Municipio
	        ide.setTpImp("2");  						// Tipo Imp
	        ide.setTpEmis("1");  						// Forma de emissão da Nfe  
	        ide.setCDV("4");  							   // Codigo DV
	        ide.setTpAmb("2");  						// Tipo Amb
	        ide.setFinNFe("1");  						// fin nfe
	        ide.setProcEmi("0");  						// Proc Emi
	        ide.setVerProc("3.0");  					// Versao Proc 
	        
	        return ide;  
	    }  
	    
	    
	    /** 
	     * C - Identificação do Emitente da Nota Fiscal eletrônica 
	     * @return 
	     */  
	    public Emit dadosDoEmitente(VendaAux venda) {  
	    	 Emit emit = new Emit();  
	         emit.setCNPJ("46624391000116");  
	         emit.setXNome("MOBSHOP Soluções LTDA");  
	         emit.setXFant("JavaC");  
	   
	         TEnderEmi enderEmit = new TEnderEmi();   
	         enderEmit.setXLgr("Rua Mauricio Jacquey");  
	         enderEmit.setNro("268");  
	         enderEmit.setXBairro("Rudge Ramos");  
	         enderEmit.setCMun("3550308");  
	         enderEmit.setXMun("SBC");  
	         enderEmit.setUF(TUfEmi.valueOf("SP"));  
	         enderEmit.setCEP("04207000");  
	         enderEmit.setCPais("1058");  
	         enderEmit.setXPais("Brasil");  
	         enderEmit.setFone("4812121212");  
	         emit.setEnderEmit(enderEmit);  
	   
	         emit.setIE("392020006114");  
	         emit.setCRT("1");         
	         return emit;  
	    }  
	  
	    /** 
	     * E - Identificação do Destinatário da Nota Fiscal eletrônica 
	     * @return 
	     */  
	    public Dest dadosDoDestinatario(VendaAux venda) {  
	        Dest dest = new Dest();  
	        dest.setCNPJ("46624391000116");  
	        dest.setXNome(venda.getCliente().getNmCliente().toUpperCase());  
	          
	        TEndereco enderDest = new TEndereco();   
	        enderDest.setXLgr(venda.getCliente().getEnderecoCompleto().toUpperCase());  
	        enderDest.setNro(venda.getCliente().getNumero().toUpperCase());  
	        enderDest.setXBairro(venda.getCliente().getBairro().toUpperCase());  
	        enderDest.setCMun("3550308");  
	        enderDest.setXMun(venda.getCliente().getCidade().toUpperCase());  
	        enderDest.setUF(TUf.valueOf("SP"));  
	        enderDest.setCEP("04207000");  
	        enderDest.setCPais("1058");  
	        enderDest.setXPais("Brasil");  
	        enderDest.setFone("4845454545");  
	        dest.setEnderDest(enderDest);  
	  
	        dest.setIE("392020006114");  
	        dest.setEmail(venda.getCliente().getEmail());  
	        return dest;  
	    }  
	  
	    /** 
	     * H - Detalhamento de Produtos e Serviços da NF-e 
	     * I - Produtos e Serviços da NF-e 
	     * M - Tributos incidentes no Produto ou Serviço 
	     * V - Informações adicionais 
	     * @return 
	     */  
	    public List<Det> dadosDoProduto(VendaAux venda) {  
	    	
	    	List<Det> dets = new ArrayList<Det>();
	    	int index = 1;
	    	for(VendaItem vi: venda.getVendaItems()){
	    		Det det = new Det();  
		        det.setNItem(String.valueOf(index));  
		        int qtd = vi.getVlQuantidade();
		        Double valor = vi.getProduto().getPrProduto().doubleValue();
		        DecimalFormat df = new DecimalFormat("#.00");
		        String total = df.format(qtd * valor);
		        /** 
		         * Dados do Produto 
		         */  
		        Prod prod = new Prod();  
		        prod.setCProd(String.valueOf(vi.getProduto().getIdRefProduto()));  
		        prod.setCEAN("");  
		        prod.setXProd(String.valueOf(vi.getProduto().getNmProduto()));  
		        prod.setNCM("00000099");  
		        prod.setCFOP("5102");  
		        prod.setUCom("UND");  
		        prod.setQCom(String.valueOf(vi.getVlQuantidade()));  
		        prod.setVUnCom(virgulaPorPonto(String.valueOf(vi.getProduto().getPrProduto())));  
		        prod.setVProd(virgulaPorPonto(total));  
		        prod.setUTrib("UND");  
		        prod.setQTrib(String.valueOf(vi.getVlQuantidade()));  
		        prod.setCEANTrib("");  
		        prod.setVUnTrib(virgulaPorPonto(String.valueOf(vi.getProduto().getPrProduto())));  
		        prod.setIndTot("1");  
		        det.setProd(prod);  
		          
		        /** 
		         * Impostos da NF-e 
		         */  
		        Imposto imposto = new Imposto();  
		          
		        ICMS icms = new ICMS();  
		        ICMSSN500 icmssn500 = new ICMSSN500();  
		        icmssn500.setOrig("0");  
		        icmssn500.setCSOSN("500");  
		        icmssn500.setVBCSTRet("0.00");  
		        icmssn500.setVICMSSTRet("0.00");  
		        icms.setICMSSN500(icmssn500);  
		          
		        PIS pis = new PIS();  
		        PISNT pisnt = new PISNT();  
		        pisnt.setCST("07");  
		        pis.setPISNT(pisnt);  
		  
		        COFINS cofins = new COFINS();  
		        COFINSNT cofinsnt = new COFINSNT();  
		        cofinsnt.setCST("07");  
		        cofins.setCOFINSNT(cofinsnt);  
		          
		        imposto.setICMS(icms);  
		        imposto.setPIS(pis);  
		        imposto.setCOFINS(cofins);  
		          
		        det.setImposto(imposto);  
		          
		        /** 
		         * Informações adicionais do Produto. 
		         */  
		        det.setInfAdProd(String.valueOf(vi.getProduto().getNmProduto())); 
		        dets.add(det);
		        index ++;
	    	}	        
	  
	        return dets;  
	    }  
	  
	    /** 
	     * W - Valores Totais da NF-e 
	     * @return 
	     */  
	    public Total totaisDaNFe(VendaAux venda) { 
	    	
	    	Double vlTotal = 0.0;
	    	DecimalFormat df = new DecimalFormat("#.00");
	    	for(VendaItem vi: venda.getVendaItems()){ 
		        int qtd = vi.getVlQuantidade();
		        Double valor = vi.getProduto().getPrProduto().doubleValue();
		        vlTotal = vlTotal + (qtd * valor);
	    	}
		        
	        Total total = new Total();  
	        
	        ICMSTot icmstot = new ICMSTot();  
	        icmstot.setVBC("0.00");  
	        icmstot.setVICMS("0.00");  
	        icmstot.setVBCST("0.00");  
	        icmstot.setVST("0.00");  
	        icmstot.setVProd(virgulaPorPonto(String.valueOf(df.format(vlTotal))));  
	        icmstot.setVFrete("0.00");  
	        icmstot.setVSeg("0.00");  
	        icmstot.setVDesc("0.00");  
	        icmstot.setVII("0.00");  
	        icmstot.setVIPI("0.00");  
	        icmstot.setVPIS("0.00");  
	        icmstot.setVCOFINS("0.00");  
	        icmstot.setVOutro("0.00");  
	        icmstot.setVNF(virgulaPorPonto(String.valueOf(df.format(vlTotal))));  
	        total.setICMSTot(icmstot);  
	  
	        return total;  
	    }  
	  
	    /** 
	     * X - Informações do Transporte da NF-e 
	     * @return 
	     */  
	    public Transp dadosDoTransporte() {  
	        Transp transp = new Transp();  
	        transp.setModFrete("0");  
	          
	        /** 
	         * Dados da Transportadora. 
	         */  
	        Transporta transporta = new Transporta();  
//	        transporta.setCNPJ("34523233000123");  
//	        transporta.setXNome("JavaC - Java Communuty");  
//	        transporta.setIE("408168400848");  
//	        transporta.setXEnder("AV. www.javac.com.br");  
//	        transporta.setXMun("Java");  
//	        transporta.setUF(TUf.valueOf("SC"));          
	        transp.setTransporta(transporta);  
	          
	        /** 
	         * Dados de Volumes. 
	         */  
	        Vol vol = new Vol();  
	        vol.setQVol("0");  
	        vol.setNVol("0");  
	        vol.setPesoL("0.000");  
	        vol.setPesoB("0.000");  
	        transp.getVol().add(vol);  
	  
	        return transp;  
	    }  
	  
	    /** 
	     * Z - Informações Adicionais da NF-e 
	     * @return 
	     */  
	    public InfAdic informacoesAdicionais() {  
	        InfAdic infAdic = new InfAdic();  
	        infAdic.setInfCpl("Informacoes Adicionais da NF-e.");  
	        return infAdic;  
	    }
	    
	    private String virgulaPorPonto(String valor){
	    	return valor.replace(",", ".");
	    }

		@Override
		public void run() {
			System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");   
			acessoNfe = new ChaveAcessoNfe();

			gerarNfeXML = new GerarNfeXML();

			assinarNfeXML = new AssinarNfeXML();

			enviarNfe = new EnviarNfe();

			consultaRetornoNfe = new ConsultaRetornoNfe();

			gerandoNfeProc = new GerandoNfeProc();
			try {
				emitirNotaFiscal(vendaAux);
			} catch (JDOMException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}

}
