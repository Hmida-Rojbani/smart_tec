package tn.com.smarteck.project.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ClientDTOReq {

	private String name;
	 
	private LocalDate dateOfBirth; 
	
	private String email;
}
