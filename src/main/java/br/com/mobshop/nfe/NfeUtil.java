package br.com.mobshop.nfe;

import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRXmlDataSource;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import br.com.mobshop.email.EnviarEmail;
import br.com.mobshop.nfe.exception.NfeException;

public class NfeUtil {

	private static final String URLRETRECEPCAOHOMOLOGACAO = "https://homologacao.nfe.fazenda.sp.gov.br/nfeweb/services/NfeRetRecepcao2.asmx";
	private static final String URLRETRECEPCAOPRODUCAO = "https://nfe.fazenda.sp.gov.br/nfeweb/services/NfeRetRecepcao2.asmx";
	private static final String URLENVIOHOMOLOGACAO = "https://homologacao.nfe.fazenda.sp.gov.br/nfeweb/services/NfeRecepcao2.asmx";
	private static final String URLENVIOPRODUCAO = "https://nfe.fazenda.sp.gov.br/nfeweb/services/NfeRecepcao2.asmx";
	private static final String URLCANCELAMENTOHOMOLOGACAO = "https://homologacao.nfe.fazenda.sp.gov.br/nfeweb/services/NfeCancelamento2.asmx";
	private static final String URLCANCELAMENTOPRODUCAO = "https://nfe.fazenda.sp.gov.br/nfeweb/services/NfeCancelamento2.asmx";
	private static final String URLINUTILIZACAOHOMOLOGACAO = "https://homologacao.nfe.fazenda.sp.gov.br/nfeweb/services/NfeInutilizacao2.asmx";
	private static final String URLINUTILIZACAOPRODUCAO = "https://homologacao.nfe.fazenda.sp.gov.br/nfeweb/services/NfeInutilizacao2.asmx";
	private static final String URLCONSULTAHOMOLOGACAO = "https://homologacao.nfe.fazenda.sp.gov.br/nfeweb/services/NfeConsulta2.asmx";
	private static final String URLCONSULTAPRODUCAO = "https://nfe.fazenda.sp.gov.br/nfeweb/services/NfeConsulta2.asmx";

	public static final String SENHA_CERTIFICADO = "TESTE";

	/**
	 * Obtem o cacert do cliente.
	 * 
	 * @param ambiente
	 * @return
	 * @throws NfeException
	 */
	public static String getCertificadoCliente() {

		return NfeUtil.class.getResource("/CERTIFICADO.pfx").getPath();

	}

	/**
	 * Obtem o certificado do SEFAZ.
	 * 
	 * @param ambiente
	 * @return
	 * @throws NfeException
	 */
	public static String getCertificadoCacert(String ambiente)
			throws NfeException {

		if (ambiente.equals("DES")) {
			return NfeUtil.class.getResource("/ARQUIVO_JKS.jks").getPath();
		} else if (ambiente.equals("PROD")) {
			return NfeUtil.class.getResource("/ARQUIVO_JKS.jks").getPath();
		} else {
			throw new NfeException("Selecione o ambiente PROD/DES");

		}
	}

	/**
	 * Retorno a URL do Webservice para RETORNO da RECEPCAO da NFE, Passando o
	 * ambiente (DES ou PROD) como parametro
	 * 
	 * @param ambiente
	 * @throws NfeException
	 */
	public static String getWebserviceRetRecepcaoUrl(String ambiente)
			throws NfeException {

		if (ambiente.equals("DES")) {
			return URLRETRECEPCAOHOMOLOGACAO;
		} else if (ambiente.equals("PROD")) {
			return URLRETRECEPCAOPRODUCAO;
		} else {
			throw new NfeException("Selecione o ambiente PROD/DES");
		}
	}

	/**
	 * Retorno a URL do Webservice para ENVIO da NFE, Passando o ambiente (DES
	 * ou PROD) como parametro
	 * 
	 * @param ambiente
	 * @throws NfeException
	 */
	public static String getWebserviceEnvioUrl(String ambiente)
			throws NfeException {

		if (ambiente.equals("DES")) {
			return URLENVIOHOMOLOGACAO;
		} else if (ambiente.equals("PROD")) {
			return URLENVIOPRODUCAO;
		} else {
			throw new NfeException("Selecione o ambiente PROD/DES");
		}
	}

	/**
	 * Retorno a URL do Webservice para CANCELAMENTO da NFE, Passando o ambiente
	 * (DES ou PROD) como parametro
	 * 
	 * @param ambiente
	 * @throws NfeException
	 */
	public static String getWebserviceCancelamentoUrl(String ambiente)
			throws NfeException {

		if (ambiente.equals("DES")) {
			return URLCANCELAMENTOHOMOLOGACAO;
		} else if (ambiente.equals("PROD")) {
			return URLCANCELAMENTOPRODUCAO;
		} else {
			throw new NfeException("Selecione o ambiente PROD/DES");
		}
	}

	/**
	 * Retorno a URL do Webservice para INUTILIZACAO da NFE, Passando o ambiente
	 * (DES ou PROD) como parametro
	 * 
	 * @param ambiente
	 * @throws NfeException
	 */
	public static String getWebserviceInutilizacaoUrl(String ambiente)
			throws NfeException {

		if (ambiente.equals("DES")) {
			return URLINUTILIZACAOHOMOLOGACAO;
		} else if (ambiente.equals("PROD")) {
			return URLINUTILIZACAOPRODUCAO;
		} else {
			throw new NfeException("Selecione o ambiente PROD/DES");
		}
	}

	/**
	 * Retorno a URL do Webservice para CONSULTA da NFE, Passando o ambiente
	 * (DES ou PROD) como parametro
	 * 
	 * @param ambiente
	 * @throws NfeException
	 */
	public static String getWebserviceConsultaUrl(String ambiente)
			throws NfeException {

		if (ambiente.equals("DES")) {
			return URLCONSULTAHOMOLOGACAO;
		} else if (ambiente.equals("PROD")) {
			return URLCONSULTAPRODUCAO;
		} else {
			throw new NfeException("Selecione o ambiente PROD/DES");
		}
	}

	public static String getNumeroRecibo(String reciboXML)
			throws JDOMException, IOException {

		SAXBuilder builder = new SAXBuilder();
		Document document = builder.build(new InputSource(
				new java.io.StringReader(reciboXML)));
		Element rootNode = document.getRootElement();
		Element e = rootNode.getChild("infRec", rootNode.getNamespace());

		return e.getChildText("nRec", rootNode.getNamespace());
	}

	/**
	 * Retorna o numero Codigo da NFE
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	public static String retornaNumeroCNF() {

		Integer cnf = (int) (Math.random() * 99999999);

		return /*cnf.toString();*/ "18005129";
	}

	// digito verificador
	public static int modulo11(String chave) {
		int total = 0;
		int peso = 2;

		for (int i = 0; i < chave.length(); i++) {
			total += (chave.charAt((chave.length() - 1) - i) - '0') * peso;
			peso++;
			if (peso == 10)
				peso = 2;
		}
		int resto = total % 11;
		return (resto == 0 || resto == 1) ? 0 : (11 - resto);
	}

	public static void getDanfe(String xml, String logo, String venda, String to) throws Exception {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
	        DocumentBuilder builder;  
	   
            builder = factory.newDocumentBuilder();  
            org.w3c.dom.Document doc = builder.parse(new InputSource(new StringReader(xml))); 

            JRXmlDataSource ds = new JRXmlDataSource(doc, "/nfeProc/NFe/infNFe/det");

			Map<String, Object> param = new HashMap<String, Object>();
			param.put("Logo", logo);

			URL url = NfeUtil.class.getResource("/danfeR.jasper");	
			JasperPrint print = JasperFillManager.fillReport(url.getPath(), param, ds);
			
			JasperExportManager.exportReportToPdfFile(print, EnviarEmail.class.getResource("/notafiscal.pdf").getPath());
			
			EnviarEmail email = new EnviarEmail();
			System.out.println("Gerou Danfe!");
			email.enviar(venda, to);

		
		
	}

}
