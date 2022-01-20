package tn.com.smarteck.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.com.smarteck.project.entities.TicketEntity;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer>{

}
