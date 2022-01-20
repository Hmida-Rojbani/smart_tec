package tn.com.smarteck.project.services;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class IntroServiceImp implements IntroService {
	int count;
	public String getHello() {
		return "Hello World!"+ count++;
	}

}
