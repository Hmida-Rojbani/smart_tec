package tn.com.smarteck.project.services;


import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tn.com.smarteck.project.dto.ClientDTOReq;
import tn.com.smarteck.project.dto.ClientDTORes;
import tn.com.smarteck.project.entities.ClientEntity;
import tn.com.smarteck.project.repositories.ClientRepository;
import static tn.com.smarteck.project.utils.Util.getNullFields;

@Service
@AllArgsConstructor
@Slf4j
public class ClientService {
	
	private ClientRepository clientRepository;
	private ModelMapper mapper;
	
	public ClientEntity getById(int id) {
		return clientRepository.findById(id)
		.orElseThrow(()->new NoSuchElementException("Client Id not found"));
	}
	
	public List<ClientEntity> getByDOB(LocalDate date){
		return clientRepository.findAll()
				.stream()
				.filter(client->client.getDateOfBirth().isEqual(date))
				.collect(Collectors.toList());
	}
	
	public List<ClientEntity> getByDOBSQL(LocalDate date){
		return clientRepository.findAllByDateOfBirth(date);
	}
	
	public ClientDTORes addClient(ClientDTOReq client) {
//		ClientEntity clientEntity = new ClientEntity();
//		clientEntity.setName(client.getName());
//		clientEntity.setEmail(client.getEmail());
//		clientEntity.setDateOfBirth(client.getDateOfBirth());
		ClientEntity clientEntity = mapper.map(client, ClientEntity.class);
		try {
			clientEntity = clientRepository.save(clientEntity);
			return mapper.map(clientEntity, ClientDTORes.class);
		}catch (Exception e) {
			log.error("Error saving client :"+ e.getMessage());
			throw new IllegalArgumentException("Cannot save Client :"+ e.getMessage());
		}
		
	}
	
	public ClientDTORes deleteClient(int id) {
		ClientEntity clientEntity = getById(id);
		clientRepository.deleteById(id);
		return mapper.map(clientEntity, ClientDTORes.class);
	}
	
	public ClientDTORes updateClient(int id, ClientDTOReq req) {
		ClientEntity oldClient = getById(id);
		ClientEntity newClient = mapper.map(req, ClientEntity.class);
//		if(newClient.getName()!=null)
//			oldClient.setName(newClient.getName());
//		if(newClient.getDateOfBirth()!=null)
//			oldClient.setDateOfBirth(newClient.getDateOfBirth());
//		if(newClient.getEmail()!=null)
//			oldClient.setEmail(newClient.getEmail());
		newClient.setId(id);
		BeanUtils.copyProperties(newClient, oldClient, getNullFields(newClient));
		
		return mapper.map(clientRepository.save(oldClient),ClientDTORes.class);
	
	}
	
	

}
