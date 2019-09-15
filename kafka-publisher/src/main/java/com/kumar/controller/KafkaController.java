package com.kumar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan("com.kumar.*;")
@RestController
@RequestMapping("/check")
public class KafkaController {
	
	@Autowired
	private KafkaTemplate<String,Object> templte;
	private String topic= "kafkaTopic";
	
	@GetMapping("/publish/{name}")
	public String publishMessage(@PathVariable String name){
		templte.send(topic,"Hi "+name +" learn kafka");
		return "Data Published";
	}
	
	@GetMapping("/do")
	public static void findMe(){
		System.out.print("hello..");
	}

}
