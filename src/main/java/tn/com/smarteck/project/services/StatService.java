package tn.com.smarteck.project.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.com.smarteck.project.entities.MetEntity;
import tn.com.smarteck.project.entities.PlatEntity;
import tn.com.smarteck.project.entities.TicketEntity;
import tn.com.smarteck.project.repositories.TicketRepository;

@Service
@AllArgsConstructor
public class StatService {
	
	private TicketRepository ticketRepository;
	
	public String platPlusAchtee(LocalDate begin, LocalDate end) {
		MetEntity metRes = ticketRepository.findAll()
		.stream()
		.filter(t-> t.getDateTime().toLocalDate().isAfter(begin.minusDays(1)) &&
				t.getDateTime().toLocalDate().isBefore(end.plusDays(1)))
		.flatMap(t->t.getMets().stream())
		.filter(m->m instanceof PlatEntity)
		.max(Comparator.comparing(m->m.getName()))
		.orElseThrow(()-> new NoSuchElementException("No plat found in this period"));
		return metRes.getName();
		/* old way
		 * List<MetEntity> mets = new ArrayList<>();
		 * 
		 * for (TicketEntity t : ticketRepository.findAll()) {
		 * if(t.getDateTime().toLocalDate().isAfter(begin.minusDays(1)) &&
		 * t.getDateTime().toLocalDate().isBefore(end.plusDays(1)))
		 * mets.addAll(t.getMets()); } Map<String, Integer> counter = new HashMap<>();
		 * for (MetEntity met : mets) { if(met instanceof PlatEntity) {
		 * if(counter.containsKey(met.getName())) counter.put(met.getName(),
		 * counter.get(met.getName())+1); else counter.put(met.getName(), 1); } }
		 * 
		 * int max = -1; String name="No plat found in this period";
		 * 
		 * for (String n : counter.keySet()) { if(counter.get(n) > max) { max=
		 * counter.get(n); name=n; } }
		 * 
		 * return name;
		 */
		
	}

}
