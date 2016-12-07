package br.com.mobshop.nfe;

import java.net.URL;
import java.security.Security;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.log4j.Logger;

import br.inf.portalfiscal.www.nfe.wsdl.nfeconsulta2.NfeConsulta2Stub;
import br.inf.portalfiscal.www.nfe.wsdl.nferetrecepcao2.NfeRetRecepcao2Stub;

/**
 * 
 * @author JavaC - Java Community
 */
public class ConsultaRetornoNfe {

	private Logger logger = Logger.getLogger(ConsultaRetornoNfe.class);

	/**
	 * Consulta a NFE atraves do numero do recibo
	 * 
	 * @param numeroRecibo
	 */
	@SuppressWarnings("restriction")
	public String consultaRetRecepcao(String numeroRecibo) {

		String retornoXML = null;

//		try {
//
//			String codigoDoEstado = "35"; // 35 Sao Paulo
//
//			/**
//			 * Enderecos de Homoloção do Sefaz Virtual SP para cada WebService
//			 * existe um endereco diferente.
//			 */
//			URL url = new URL(NfeUtil.getWebserviceRetRecepcaoUrl("DES"));
//
//			/**
//			 * Informações do Certificado Digital.
//			 */
//			System.setProperty("java.protocol.handler.pkgs",
//					"com.sun.net.ssl.internal.www.protocol");
//			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//
//			System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
//
//			System.clearProperty("javax.net.ssl.keyStore");
//			System.clearProperty("javax.net.ssl.keyStorePassword");
//			System.clearProperty("javax.net.ssl.trustStore");
//
//			System.setProperty("javax.net.ssl.keyStore",
//					NfeUtil.getCertificadoCliente());
//			System.setProperty("javax.net.ssl.keyStorePassword",
//					NfeUtil.SENHA_CERTIFICADO);
//
//			System.setProperty("javax.net.ssl.trustStoreType", "JKS");
//			System.setProperty("javax.net.ssl.trustStore",
//					NfeUtil.getCertificadoCacert("DES"));
//
//			/**
//			 * Xml de Consulta.
//			 */
//			StringBuilder xml = new StringBuilder();
//			xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
//					.append("<consReciNFe versao=\"3.10\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">")
//					.append("<tpAmb>2</tpAmb>").append("<nRec>")
//					.append(numeroRecibo).append("</nRec>")
//					.append("</consReciNFe>");
//
//			OMElement ome = AXIOMUtil.stringToOM(xml.toString());
//			NfeRetRecepcao2Stub.NfeDadosMsg dadosMsg = new NfeRetRecepcao2Stub.NfeDadosMsg();
//			dadosMsg.setExtraElement(ome);
//
//			NfeRetRecepcao2Stub.NfeCabecMsg nfeCabecMsg = new NfeRetRecepcao2Stub.NfeCabecMsg();
//			/**
//			 * Código do Estado.
//			 */
//			nfeCabecMsg.setCUF(codigoDoEstado);
//
//			/**
//			 * Versão do XML
//			 */
//			nfeCabecMsg.setVersaoDados("2.00");
//
//			NfeRetRecepcao2Stub.NfeCabecMsgE nfeCabecMsgE = new NfeRetRecepcao2Stub.NfeCabecMsgE();
//			nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);
//
//			NfeRetRecepcao2Stub stub = new NfeRetRecepcao2Stub(url.toString());
//			NfeRetRecepcao2Stub.NfeRetRecepcao2Result result = stub
//					.nfeRetRecepcao2(dadosMsg, nfeCabecMsgE);
//
//			retornoXML = result.getExtraElement().toString();
//
//		} catch (Exception e) {
//			logger.error(e.toString());
//		}

		return retornoXML;
	}

	/**
	 * Consulta a NFE atraves do numero do recibo
	 * 
	 * @param numeroRecibo
	 */
	@SuppressWarnings("restriction")
	public String consultaNFE(String numeroChave)  throws Exception{  

		String retornoXML = null;

//			String codigoDoEstado = "35"; // 35 Sao Paulo
//
//			/**
//			 * Enderecos de Homoloção do Sefaz Virtual SP para cada WebService
//			 * existe um endereco diferente.
//			 */
//			URL url = new URL(NfeUtil.getWebserviceConsultaUrl("DES"));
//
//			/**
//			 * Informações do Certificado Digital.
//			 */
//			System.setProperty("java.protocol.handler.pkgs",
//					"com.sun.net.ssl.internal.www.protocol");
//			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//
//			System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
//
//			System.clearProperty("javax.net.ssl.keyStore");
//			System.clearProperty("javax.net.ssl.keyStorePassword");
//			System.clearProperty("javax.net.ssl.trustStore");
//
//			System.setProperty("javax.net.ssl.keyStore",
//					NfeUtil.getCertificadoCliente());
//			System.setProperty("javax.net.ssl.keyStorePassword",
//					NfeUtil.SENHA_CERTIFICADO);
//
//			System.setProperty("javax.net.ssl.trustStoreType", "JKS");
//			System.setProperty("javax.net.ssl.trustStore",
//					NfeUtil.getCertificadoCacert("DES"));
//
//			/** 
//             * Xml de Consulta. 
//             */  
//			StringBuilder xml = new StringBuilder(); 
//			xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>") 
//			.append("<consSitNFe versao=\"2.01\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">") 
//			.append("<tpAmb>2</tpAmb>") 
//			.append("<xServ>CONSULTAR</xServ>") 
//			.append("<chNFe>") 
//			.append(numeroChave) 
//			.append("</chNFe>") 
//			.append("</consSitNFe>"); 
//  
//            OMElement ome = AXIOMUtil.stringToOM(xml.toString());  
//  
//            NfeConsulta2Stub.NfeDadosMsg dadosMsg = new NfeConsulta2Stub.NfeDadosMsg();  
//            dadosMsg.setExtraElement(ome);  
//  
//            NfeConsulta2Stub.NfeCabecMsg nfeCabecMsg = new NfeConsulta2Stub.NfeCabecMsg();  
//            /** 
//             * Código do Estado. 
//             */  
//            nfeCabecMsg.setCUF(codigoDoEstado);  
//  
//            /** 
//             * Versao do XML 
//             */  
//            nfeCabecMsg.setVersaoDados("2.01");  
//            NfeConsulta2Stub.NfeCabecMsgE nfeCabecMsgE = new NfeConsulta2Stub.NfeCabecMsgE();  
//            nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);  
//  
//            NfeConsulta2Stub stub = new NfeConsulta2Stub(url.toString());  
//            NfeConsulta2Stub.NfeConsultaNF2Result result = stub.nfeConsultaNF2(dadosMsg, nfeCabecMsgE);  
//  
//            retornoXML = result.getExtraElement().toString();  


		return retornoXML;
	}

	public static void main(String args[]) {
		ConsultaRetornoNfe c = new ConsultaRetornoNfe();
		c.consultaRetRecepcao("232323121");
	}

}