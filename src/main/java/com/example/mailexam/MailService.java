package com.example.mailexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendmail(String email, String title, String content) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("austiny@naver.com");//설정한 네이버 주소, 변조 불가
		message.setTo(email);
		message.setSubject(title);
		message.setText(content);
		
		javaMailSender.send(message);
		
		
	}
	
}
