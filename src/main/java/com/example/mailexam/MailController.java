package com.example.mailexam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {
	
	@Autowired
	private MailService mailService;
	
	@GetMapping("/")
	public String index() {
		return "composemail";
	}
	
	@PostMapping("/mailSender")
	public String mailSender(
					@RequestParam("email") String email,
					@RequestParam("title") String title,
					@RequestParam("content") String content
			) {
		
		mailService.sendmail(email, title, content);
		
		return"composemail";
	}
	
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	
	@PostMapping("/join")
	public String join(@RequestParam("id") String id,
					   @RequestParam("password") String password,
					   @RequestParam("email") String email,
					   @RequestParam("username") String username) {
		
		System.out.println(id);
		System.out.println(password);
		System.out.println(email);
		System.out.println(username);
		
		
		mailService.sendmail(email, id + "님 회원가입을 환영합니다.", username +"님 가입을 진심으로 축하합니다.");
		
		return "join";
	}
}
