package tn.com.smarteck.project.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import tn.com.smarteck.project.entities.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {

	List<ClientEntity> findAllByDateOfBirth(LocalDate date);
	
	@Query("Select c from ClientEntity c where c.dateOfBirth = :date")
	List<ClientEntity> getByDate(@Param("date") LocalDate date);

	@Query(nativeQuery = true,
	value = "Select * from ClientEntity where dateOfBirth = :date")
	List<ClientEntity> getByDateSQL(@Param("date") LocalDate date);
}
