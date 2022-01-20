package tn.com.smarteck.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexCtrl {
	
	@GetMapping("/")
	public String getIndex(Model model) {
		String msg = "Hello In our Site"; 
		model.addAttribute("msg",msg);
		return "index";
	}

}
