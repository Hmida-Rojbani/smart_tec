package tn.com.smarteck.project.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
@DiscriminatorValue("plat")
public class PlatEntity extends MetEntity{

	private int prix;
}
