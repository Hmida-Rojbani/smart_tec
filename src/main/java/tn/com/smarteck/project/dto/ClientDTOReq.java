package tn.com.smarteck.project.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ClientDTOReq {
	
	private int id;

	@NotBlank(message = "must be filled with chars")
	@Size(min = 3)
	private String name;
	@Past
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
