package tn.com.smarteck.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.AllArgsConstructor;
import tn.com.smarteck.project.dto.ClientDTOReq;
import tn.com.smarteck.project.services.ClientService;

@Controller
@AllArgsConstructor
public class ClientCtrl {
	private ClientService clientService;
	@GetMapping("/show/clients")
	public String getShowClients(Model model) {
		model.addAttribute("clients", clientService.getAllClients());
		return "clients/show-clients";
	}
	
	@GetMapping("/client/delete/{id}")
	public String deleteClient(@PathVariable int id) {
		clientService.deleteClient(id);
		return "redirect:/show/clients";
	}
	
	@GetMapping("/add/client")
	public String addClient(Model model) {
		model.addAttribute("updateble", "false");
		model.addAttribute("client", new ClientDTOReq());
		return "clients/add-client";
	}
	
	@PostMapping("/add/client")
	public String postAddClient(@ModelAttribute("client") ClientDTOReq req,
			@ModelAttribute("updateble") String updateble) {
		System.out.println(updateble);
		if(Boolean.valueOf(updateble))
			clientService.updateClient(req.getId(), req);
		else
			clientService.addClient(req);
		return "redirect:/show/clients";
	}
	
	@GetMapping("/client/update/{id}")
	public String updateClient(@PathVariable int id,Model model) {
		model.addAttribute("updateble", "true");
		model.addAttribute("client", clientService.getClientById(id));
		return "clients/add-client";
	}
}
