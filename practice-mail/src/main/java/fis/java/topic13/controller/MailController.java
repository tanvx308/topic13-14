package fis.java.topic13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fis.java.topic13.common.MyConstants;

@Controller
public class MailController {
	@Autowired
	JavaMailSender mailSender;
	
	@ResponseBody
	@GetMapping("/send")
	public String sendEmail() {
		  // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();
        
        message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("Send by Java");
        message.setText("Hello, Im testing Java Email");

        // Send Message!
        this.mailSender.send(message);
		return "Email was sent to " + MyConstants.FRIEND_EMAIL;
	}
}
