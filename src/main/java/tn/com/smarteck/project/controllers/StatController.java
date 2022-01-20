package tn.com.smarteck.project.controllers;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tn.com.smarteck.project.services.StatService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/stats")
public class StatController {
	private StatService statService;
	
	@GetMapping("/plat/{dBegin}/{dEnd}")
	public String maxPlat(@PathVariable String dBegin, @PathVariable String dEnd) {
		LocalDate begin = LocalDate.parse(dBegin);
		LocalDate end = LocalDate.parse(dEnd);
		return statService.platPlusAchtee(begin, end);
	}

}
