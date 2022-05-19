package com.kcbgroup.testapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greetings {
	@GetMapping("/")
	public String hello() {
		return "hello guys";
	}
	
	@GetMapping("/ytyy")
	public String helluiyo() {
		return "hello guys";
	}

}
