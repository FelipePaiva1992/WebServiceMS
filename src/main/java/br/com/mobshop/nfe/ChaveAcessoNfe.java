package br.com.mobshop.nfe;

import java.text.SimpleDateFormat;

import br.com.javac.v200.envinfe.TNFe.InfNFe.Emit;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Ide;

public class ChaveAcessoNfe {  
	  
	private SimpleDateFormat sdfOrigem = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdfSaida = new SimpleDateFormat("yyMM");
	
	/**
	 * 
	 * Gera chave de acesso a NFe.
	 * Recebe como parametro a Identificacao da Nfe e o Emissor da Nfe.
	 * 
	 * @param ide
	 * @param emissor
	 * @return
	 */
    public String gerarChaveAcessoNfe(Ide ide, Emit emissor)  throws Exception{  
    	
    	String chaveAcesso = null;
    
            
            StringBuilder chave = new StringBuilder();  
            chave.append(lpadTo(ide.getCUF(), 2, '0'));  									// Código da UF do emitente do Documento Fiscal (35 - Sao Paulo).   
            chave.append(lpadTo(sdfSaida.format(sdfOrigem.parse(ide.getDEmi())), 4, '0'));  // Ano e Mês de emissão da NF-e.  
            chave.append(lpadTo(emissor.getCNPJ().replaceAll("\\D",""), 14, '0'));  		// CNPJ do emitente. 
            chave.append(lpadTo(ide.getMod(), 2, '0'));  									// Modelo do Documento Fiscal. 
            chave.append(lpadTo(ide.getSerie(), 3, '0'));  									// Série do Documento Fiscal. 
            chave.append(lpadTo(String.valueOf(ide.getNNF()), 9, '0'));  					// Número do Documento Fiscal.					
            chave.append(lpadTo(ide.getTpEmis(), 1, '0'));  								// Tipo Emissao do Documento Fiscal.  
            chave.append(lpadTo(ide.getCNF(), 8, '0'));  									// Código Numérico que compõe a Chave de Acesso.   
            
            ide.setCDV(String.valueOf(NfeUtil.modulo11(chave.toString())));
            
            chave.append(ide.getCDV());  
  
            chave.insert(0, "NFe");  
  
            chaveAcesso = chave.toString();
            
 
        return chaveAcesso;
        
    }  
      
    public static int modulo11(String chave) {  
        int total = 0;  
        int peso = 2;  
              
        for (int i = 0; i < chave.length(); i++) {  
            total += (chave.charAt((chave.length()-1) - i) - '0') * peso;  
            peso ++;  
            if (peso == 10)  
                peso = 2;  
        }  
        int resto = total % 11;  
        return (resto == 0 || resto == 1) ? 0 : (11 - resto);  
    }  
  
    public static String lpadTo(String input, int width, char ch) {  
        String strPad = "";  
  
        StringBuffer sb = new StringBuffer(input.trim());  
        while (sb.length() < width)  
            sb.insert(0,ch);  
        strPad = sb.toString();  
          
        if (strPad.length() > width) {  
            strPad = strPad.substring(0,width);  
        }  
        return strPad;  
    }  

  
}  