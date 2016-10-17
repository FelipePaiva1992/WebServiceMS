package br.com.mobshop.email;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EnviarEmail {


	public void enviar(String venda, String to) {

		Properties props = new Properties();
		props.put("mail.smtp.host","localhost");
		props.put("mail.smtp.port","25");
		props.put("mail.smtp.auth","true");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"mobshop@thesource.com.br", "13051992");
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("mobshop@thesource.com.br"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Nota Fiscal referente a venda " + venda);
			
			// Monta a mensagem SMTP inserindo o conteudo, texto e anexos
			Multipart mps = new MimeMultipart();

			// Cria um novo objeto para cada arquivo, e anexa o arquivo
			MimeBodyPart attachFilePart = new MimeBodyPart();
			FileDataSource fds = new FileDataSource(EnviarEmail.class.getResource("/notafiscal.pdf").getPath());
			attachFilePart.setDataHandler(new DataHandler(fds));
			attachFilePart.setFileName(fds.getName());

			// adiciona os anexos da mensagem
			mps.addBodyPart(attachFilePart, 0);
			
			// Cria o objeto que recebe o texto do corpo do email
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setContent(htmlMessage(venda), MailJava.TYPE_TEXT_HTML);
			
			// adiciona o corpo texto da mensagem			
			mps.addBodyPart(textPart);

			// adiciona a mensagem o conteúdo texto e anexo
			message.setContent(mps);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
	
	private static String textMessage() {
        return  "Nota Fiscal.";
    }
 
    private static String htmlMessage(String venda) {
    	return "<html><body style='margin: 0;mso-line-height-rule: exactly;padding: 0;min-width: 100%;background-color: #fbfbfb'><style type='text/css'>body,.wrapper,.emb-editor-canvas{background-color:#fbfbfb}.border{background-color:#e9e9e9}h1{color:#565656}.wrapper h1{}.wrapper h1{font-family:sans-serif}@media only screen and (min-width: 0){.wrapper h1{font-family:Avenir,sans-serif !important}}h1{}.one-col h1{line-height:42px}.two-col h1{line-height:32px}.three-col h1{line-height:26px}.wrapper .one-col-feature h1{line-height:58px}@media only screen and (max-width: 620px){h1{line-height:42px !important}}h2{color:#555}.wrapper h2{}.wrapper h2{font-family:Georgia,serif}h2{}.one-col h2{line-height:32px}.two-col h2{line-height:26px}.three-col h2{line-height:22px}.wrapper .one-col-feature h2{line-height:52px}@media only screen and (max-width: 620px){h2{line-height:32px !important}}h3{color:#555}.wrapper h3{}.wrapper h3{font-family:Georgia,serif}h3{}.one-col h3{line-height:26px}.two-col h3{line-height:22px}.three-col h3{line-height:20px}.wrapper .one-col-feature h3{line-height:42px}@media only screen and (max-width: 620px){h3{line-height:26px !important}}p,ol,ul{color:#565656}.wrapper p,.wrapper ol,.wrapper ul{}.wrapper p,.wrapper ol,.wrapper ul{font-family:Georgia,serif}p,ol,ul{}.one-col p,.one-col ol,.one-col ul{line-height:25px;Margin-bottom:25px}.two-col p,.two-col ol,.two-col ul{line-height:23px;Margin-bottom:23px}.three-col p,.three-col ol,.three-col ul{line-height:21px;Margin-bottom:21px}.wrapper .one-col-feature p,.wrapper .one-col-feature ol,.wrapper .one-col-feature ul{line-height:32px}.one-col-feature blockquote p,.one-col-feature blockquote ol,.one-col-feature blockquote ul{line-height:50px}@media only screen and (max-width: 620px){p,ol,ul{line-height:25px !important;Margin-bottom:25px !important}}.image{color:#565656}.image{font-family:Georgia,serif}.wrapper a{color:#41637e}.wrapper a:hover{color:#30495c !important}.wrapper .logo div{color:#41637e}.wrapper .logo div{font-family:sans-serif}@media only screen and (min-width: 0){.wrapper .logo div{font-family:Avenir,sans-serif !important}}.wrapper .logo div a{color:#41637e}.wrapper .logo div a:hover{color:#41637e !important}.wrapper .one-col-feature p a,.wrapper .one-col-feature ol a,.wrapper .one-col-feature ul a{border-bottom:1px solid #41637e}.wrapper .one-col-feature p a:hover,.wrapper .one-col-feature ol a:hover,.wrapper .one-col-feature ul a:hover{color:#30495c !important;border-bottom:1px solid #30495c !important}.btn a{}.wrapper .btn a{}.wrapper .btn a{font-family:Georgia,serif}.wrapper .btn a{background-color:#41637e;color:#fff !important;outline-color:#41637e;text-shadow:0 1px 0 #3b5971}.wrapper .btn a:hover{background-color:#3b5971 !important;color:#fff !important;outline-color:#3b5971 !important}.preheader .title,.preheader .webversion,.footer .padded{color:#999}.preheader .title,.preheader .webversion,.footer .padded{font-family:Georgia,serif}.preheader .title a,.preheader .webversion a,.footer .padded a{color:#999}.preheader .title a:hover,.preheader .webversion a:hover,.footer .padded a:hover{color:#737373 !important}.footer .social .divider{color:#e9e9e9}.footer .social .social-text,.footer .social a{color:#999}.wrapper .footer .social .social-text,.wrapper .footer .social a{}.wrapper .footer .social .social-text,.wrapper .footer .social a{font-family:Georgia,serif}.footer .social .social-text,.footer .social a{}.footer .social .social-text,.footer .social a{letter-spacing:0.05em}.footer .social .social-text:hover,.footer .social a:hover{color:#737373 !important}.image .border{background-color:#c8c8c8}.image-frame{background-color:#dadada}.image-background{background-color:#f7f7f7}</style><center class='wrapper' style='display: table;table-layout: fixed;width: 100%;min-width: 620px;-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;background-color: #fbfbfb'><table class='gmail' style='border-collapse: collapse;border-spacing: 0;width: 650px;min-width: 650px'><tbody><tr><td style='padding: 0;vertical-align: top;font-size: 1px;line-height: 1px'>&nbsp;</td></tr></tbody></table><table class='preheader centered' style='border-collapse: collapse;border-spacing: 0;Margin-left: auto;Margin-right: auto'><tbody><tr><td style='padding: 0;vertical-align: top'><table style='border-collapse: collapse;border-spacing: 0;width: 602px'><tbody><tr><td class='title' style='padding: 0;vertical-align: top;padding-top: 10px;padding-bottom: 12px;font-size: 12px;line-height: 21px;text-align: left;color: #999;font-family: Georgia,serif'>&nbsp; &nbsp;</td><td class='webversion' style='padding: 0;vertical-align: top;padding-top: 10px;padding-bottom: 12px;font-size: 12px;line-height: 21px;text-align: right;width: 300px;color: #999;font-family: Georgia,serif'></td></tr></tbody></table></td></tr></tbody></table><table class='header centered' style='border-collapse: collapse;border-spacing: 0;Margin-left: auto;Margin-right: auto;width: 602px'><tbody><tr><td class='border' style='padding: 0;vertical-align: top;font-size: 1px;line-height: 1px;background-color: #e9e9e9;width: 1px'>&nbsp;</td></tr><tr><td class='logo' style='padding: 32px 0;vertical-align: top;mso-line-height-rule: at-least'></td></tr></tbody></table><table class='border' style='border-collapse: collapse;border-spacing: 0;font-size: 1px;line-height: 1px;background-color: #e9e9e9;Margin-left: auto;Margin-right: auto' width='602'><tbody><tr><td style='padding: 0;vertical-align: top'>&#8203;</td></tr></tbody></table><table class='centered' style='border-collapse: collapse;border-spacing: 0;Margin-left: auto;Margin-right: auto'><tbody><tr><td class='border' style='padding: 0;vertical-align: top;font-size: 1px;line-height: 1px;background-color: #e9e9e9;width: 1px'>&#8203;</td><td style='padding: 0;vertical-align: top'><table class='one-col' style='border-collapse: collapse;border-spacing: 0;Margin-left: auto;Margin-right: auto;width: 600px;background-color: #ffffff;font-size: 14px'><tbody><tr><td class='column' style='padding: 0;vertical-align: top;text-align: left'><div><div class='column-top' style='font-size: 32px;line-height: 32px'>&nbsp;</div></div><table class='contents' style='border-collapse: collapse;border-spacing: 0;width: 100%'><tbody><tr><td class='padded' style='padding: 0;vertical-align: top;padding-left: 32px;padding-right: 32px'><h1 style='Margin-top: 0;color: #565656;font-weight: 700;font-size: 36px;Margin-bottom: 18px;font-family: sans-serif;line-height: 42px'>Obrigado pela compra!</h1><p style='Margin-top: 0;color: #565656;font-family: Georgia,serif;font-size: 16px;line-height: 25px;Margin-bottom: 24px'>Em anexo, segue a nota fiscal referente a sua compra " + venda  + ".<br />Agrade&#231;emos a preferencia.</p></td></tr></tbody></table><div class='column-bottom' style='font-size: 8px;line-height: 8px'>&nbsp;</div></td></tr></tbody></table></td><td class='border' style='padding: 0;vertical-align: top;font-size: 1px;line-height: 1px;background-color: #e9e9e9;width: 1px'>&#8203;</td></tr></tbody></table><table class='border' style='border-collapse: collapse;border-spacing: 0;font-size: 1px;line-height: 1px;background-color: #e9e9e9;Margin-left: auto;Margin-right: auto' width='602'><tbody><tr><td style='padding: 0;vertical-align: top'>&#8203;</td></tr></tbody></table><div class='spacer' style='font-size: 1px;line-height: 32px;width: 100%'>&nbsp;</div><table class='footer centered' style='border-collapse: collapse;border-spacing: 0;Margin-left: auto;Margin-right: auto;width: 602px'><tbody><tr><td class='social' style='padding: 0;vertical-align: top;padding-top: 32px;padding-bottom: 22px' align='center'></td></tr><tr><td class='border' style='padding: 0;vertical-align: top;font-size: 1px;line-height: 1px;background-color: #e9e9e9;width: 1px'>&nbsp;</td></tr><tr><td style='padding: 0;vertical-align: top'><table style='border-collapse: collapse;border-spacing: 0'><tbody><tr><td class='address' style='padding: 0;vertical-align: top;width: 250px;padding-top: 32px;padding-bottom: 64px'><table class='contents' style='border-collapse: collapse;border-spacing: 0;width: 100%'><tbody><tr><td class='padded' style='padding: 0;vertical-align: top;padding-left: 0;padding-right: 10px;text-align: left;font-size: 12px;line-height: 20px;color: #999;font-family: Georgia,serif'><div>&nbsp; &nbsp;</div></td></tr></tbody></table></td><td class='subscription' style='padding: 0;vertical-align: top;width: 350px;padding-top: 32px;padding-bottom: 64px'><table class='contents' style='border-collapse: collapse;border-spacing: 0;width: 100%'><tbody><tr><td class='padded' style='padding: 0;vertical-align: top;padding-left: 10px;padding-right: 0;font-size: 12px;line-height: 20px;color: #999;font-family: Georgia,serif;text-align: right'></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></center></body></html>";
    }
}
