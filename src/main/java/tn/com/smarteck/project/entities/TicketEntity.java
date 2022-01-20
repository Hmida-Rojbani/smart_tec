package tn.com.smarteck.project.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class TicketEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	
	private LocalDateTime dateTime;
	
	private double addition;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "client")
	private ClientEntity client;
	
	@ManyToMany(mappedBy = "tickets")
	private List<MetEntity> mets;
	
}
