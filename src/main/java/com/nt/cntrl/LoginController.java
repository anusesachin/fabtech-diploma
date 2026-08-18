package com.nt.cntrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	
	@GetMapping("/login")
	public String login() {
		System.out.println("Hello");
		return "success";
	}
}
