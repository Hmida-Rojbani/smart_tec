package tn.com.smarteck.project.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class MetEntity {
	@Id
	
	private int numero;
	
	private String name;
	@ManyToMany
	@JoinTable(name="contains",
			joinColumns = @JoinColumn(name="met"),
			inverseJoinColumns = @JoinColumn(name="ticket"))
	private List<TicketEntity> tickets;
	
	private LocalDateTime creationDate= LocalDateTime.now();
	
	private LocalDateTime updateDate;
	
	public void setName(String name) {
		this.name=name;
		update();
	}
	
	private void update() {
		updateDate=LocalDateTime.now();
	}
}
