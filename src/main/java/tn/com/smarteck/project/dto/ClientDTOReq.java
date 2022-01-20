package tn.com.smarteck.project.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ClientDTOReq {
	
	private int id;

	private String name;
	 
	private LocalDate dateOfBirth; 
	
	private String email;
	
	public void setDateHtml(String date) {
		if(date!=null||date.equals(""))
			dateOfBirth = LocalDate.parse(date);
	}
	
	public String getDateHtml() {
		return dateOfBirth!=null?dateOfBirth.toString():null;
	}
	
	public void setName(String name) {
		this.name=name.equals("")?null:name;
	}
}
