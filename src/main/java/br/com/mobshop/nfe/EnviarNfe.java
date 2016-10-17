package br.com.mobshop.nfe;

import java.net.URL;
import java.security.Security;
import java.util.Iterator;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import br.inf.portalfiscal.www.nfe.wsdl.nferecepcao2.NfeRecepcao2Stub;
  
/** 
* 
* @author JavaC - Java Community 
*/  
public class EnviarNfe {  
	
	@SuppressWarnings("restriction")
	public String enviarNFE(String pathCertificado,
    						String senhaCertificado,
    						String nfeAssinada) throws Exception{  
    	
    	String reciboNfe = null;

            String codigoDoEstado = "35"; //Sao Paulo 
  
            /** 
             * Enderecos de Homoloção do Sefaz Virtual RS 
             * para cada WebService existe um endereco Diferente. 
             */  
            URL url = new URL(NfeUtil.getWebserviceEnvioUrl("DES"));  

            /** 
             * Informações do Certificado Digital. 
             */  
            System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");  
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());  
  
            System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");  
  
            System.clearProperty("javax.net.ssl.keyStore");  
            System.clearProperty("javax.net.ssl.keyStorePassword");  
            System.clearProperty("javax.net.ssl.trustStore");  
  
            System.setProperty("javax.net.ssl.keyStore", NfeUtil.getCertificadoCliente());  
            System.setProperty("javax.net.ssl.keyStorePassword", NfeUtil.SENHA_CERTIFICADO);  
  
            System.setProperty("javax.net.ssl.trustStoreType", "JKS");  
            System.setProperty("javax.net.ssl.trustStore", NfeUtil.getCertificadoCacert("DES"));  
  
            /** 
             * IMPORTANTE: O XML já deve ser assinado antes do envio. 
             * Lendo o Xml de um arquivo Gerado. 
             */
            String xmlEnvNFe = nfeAssinada;  
            OMElement ome = AXIOMUtil.stringToOM(xmlEnvNFe);  
  
            Iterator<?> children = ome.getChildrenWithLocalName("NFe");    
            while (children.hasNext()) {  
                OMElement omElement = (OMElement) children.next();    
                if ((omElement != null) && ("NFe".equals(omElement.getLocalName()))) {    
                    omElement.addAttribute("xmlns", "http://www.portalfiscal.inf.br/nfe", null);    
                }  
            }  
  
            NfeRecepcao2Stub.NfeDadosMsg dadosMsg = new NfeRecepcao2Stub.NfeDadosMsg();  
            dadosMsg.setExtraElement(ome);  
            NfeRecepcao2Stub.NfeCabecMsg nfeCabecMsg = new NfeRecepcao2Stub.NfeCabecMsg();  
            /** 
             * Código do Estado. 
             */  
            nfeCabecMsg.setCUF(codigoDoEstado);  
  
            /** 
             * Versao do XML 
             */  
            nfeCabecMsg.setVersaoDados("2.00");  
  
            NfeRecepcao2Stub.NfeCabecMsgE nfeCabecMsgE = new NfeRecepcao2Stub.NfeCabecMsgE();  
            nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);  
  
            NfeRecepcao2Stub stub = new NfeRecepcao2Stub(url.toString());  
            NfeRecepcao2Stub.NfeRecepcaoLote2Result result = stub.nfeRecepcaoLote2(dadosMsg, nfeCabecMsgE);  
  
            reciboNfe = result.getExtraElement().toString(); 
        
        return reciboNfe;
        
    }  

  
}  