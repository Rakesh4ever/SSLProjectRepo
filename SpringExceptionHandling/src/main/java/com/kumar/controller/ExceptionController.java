package com.kumar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Service("/v1")
public class ExceptionController {
	
	
	@GetMapping(value = "/hi")
	public String greet(){
		System.out.println("hello");
		return "Hello..";
	}

}
