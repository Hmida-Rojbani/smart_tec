package tn.com.smarteck.project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tn.com.smarteck.project.services.IntroService;

@RestController
@AllArgsConstructor
public class IntroRestCtrl {
	
	
	private IntroService introServiceImp;
	private String hi;
	

	@RequestMapping(path = "/hello")
	public String hello() {
		return hi;
	}


	
}
