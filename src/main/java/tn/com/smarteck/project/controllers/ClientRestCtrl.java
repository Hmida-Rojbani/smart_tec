package tn.com.smarteck.project.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tn.com.smarteck.project.dto.ClientDTOReq;
import tn.com.smarteck.project.dto.ClientDTORes;
import tn.com.smarteck.project.entities.ClientEntity;
import tn.com.smarteck.project.services.ClientService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/clients")
public class ClientRestCtrl {

	private ClientService clientService;
	
	//@RequestMapping(path="/save",method = RequestMethod.POST)
	@PostMapping("/save")
	public ClientDTORes save(@RequestBody ClientDTOReq client) {
		return clientService.addClient(client);
	}
	
	@GetMapping("/{num}")
	public ClientEntity getAll(@PathVariable("num") int id) {
		return clientService.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public ClientDTORes deleteId(@PathVariable int id) {
		return clientService.deleteClient(id);
	}
	
	@PutMapping("/{id}")
	public ClientDTORes updateId(@PathVariable int id,@RequestBody ClientDTOReq client) {
		return clientService.updateClient(id, client);
	}
}

