package br.com.mobshop.nfe;

import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.com.javac.v200.envinfe.ObjectFactory;
import br.com.javac.v200.envinfe.TEnviNFe;
import br.com.javac.v200.envinfe.TNFe;
import br.com.javac.v200.envinfe.TNFe.InfNFe;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Dest;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Det;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Emit;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Ide;
import br.com.javac.v200.envinfe.TNFe.InfNFe.InfAdic;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Total;
import br.com.javac.v200.envinfe.TNFe.InfNFe.Transp;
  
/**  
* Geração do XML da NF-e (Versão 2.00).  
*   
*/  
public class GerarNfeXML {  
  
    public String gerarNfe(String chaveAcesso,
    						String idLote,
    						Ide ide,
    						Emit emit,
    						Dest dest,
    						List<Det> dets,
    						Total total,
    						Transp transp,
    						InfAdic infAdic
    						)  throws Exception{  
    	
    	String retonoXML = null;
    	
            TNFe nFe = new TNFe();  
            InfNFe infNFe = new InfNFe();  
      
            infNFe.setId(chaveAcesso);  
            infNFe.setVersao("2.00");  
      
            if(ide != null){
            	infNFe.setIde(ide);              	
            }
            
            if(emit != null){
            	infNFe.setEmit(emit);              	
            }
            
            if(dest != null){
            	infNFe.setDest(dest);              	
            }
              
            if(!dets.isEmpty()){
            	for(Det d: dets)
            		infNFe.getDet().add(d);              	
            }
              
            if(total != null){
            	infNFe.setTotal(total);              	
            }
            
            if(transp != null){
            	infNFe.setTransp(transp);              	
            }
            
            if(infAdic != null){
            	infNFe.setInfAdic(infAdic);              	
            }
              
            nFe.setInfNFe(infNFe);  
  
            TEnviNFe enviNFe = new TEnviNFe();  
            enviNFe.setVersao("2.00");  
            enviNFe.setIdLote(idLote);  
            enviNFe.getNFe().add(nFe);  
              
            retonoXML = strValueOf(enviNFe);  
            

        
        return retonoXML;
    }  

  
    /** 
     * Método que Converte o Objeto em String. 
     * @param consStatServ 
     * @return 
     * @throws JAXBException 
     */  
    private String strValueOf(TEnviNFe enviNFe) throws JAXBException {  
        JAXBContext context = JAXBContext.newInstance(TEnviNFe.class);  
        Marshaller marshaller = context.createMarshaller();  
        JAXBElement<TEnviNFe> element = new ObjectFactory().createEnviNFe((enviNFe));  
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);  
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);  
  
        StringWriter sw = new StringWriter();  
        marshaller.marshal(element, sw);  
  
        String xml = sw.toString();  
        xml = xml.replaceAll("xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\" ", "");  
        xml = xml.replaceAll("<NFe>", "<NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\">");  
          
        return xml;  
    }  
      
}  