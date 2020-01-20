package com.onlinetutorilspoint;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleMailController {
	@Autowired
	private JavaMailSender sender;

	private Logger logger = LoggerFactory.getLogger(SimpleMailController.class);
	
	@RequestMapping("/sendMail")
	public String sendMail() {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		try {
			helper.setTo("lokin4ya@gmail.com");
			helper.setText("Greetings :)");
			helper.setSubject("Mail From Spring Boot");
			logger.info("Ready to send mail ..");
			sender.send(message);
		} catch (MessagingException e1) {
			e1.printStackTrace();
			logger.info("Exception Error 1 while initializing mail ..");
			return "Error 1";
		}
		catch (Exception e2) {
			e2.printStackTrace();
			logger.info("Exception Error 2 while sending mail ..");
			return "Error 2";
		}
		logger.info("Sent mail ..");
		return "Mail Sent Success!";
	}

	@RequestMapping("/sendMailAtt")
	public String sendMailAttachment() throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		try {
			helper.setTo("lokin4ya@gmail.com");
			helper.setText("Greetings :)\n Please find the attached docuemnt for your reference.");
			helper.setSubject("Mail From Spring Boot");
			ClassPathResource file = new ClassPathResource("document.PNG");
			helper.addAttachment("document.PNG", file);
		} catch (MessagingException e1) {
			e1.printStackTrace();
			logger.info("Exception Error 11 while sending mail ..");
			return "Error while sending mail ..";
		}
		catch (Exception e2) {
			e2.printStackTrace();
			logger.info("Exception Error 22 while sending mail ..");
			return "Error 2";
		}
		logger.info("Sent mail att ..");
		sender.send(message);
		return "Mail Sent Success!";
	}

}
