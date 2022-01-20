package tn.com.smarteck.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.AllArgsConstructor;
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
}
