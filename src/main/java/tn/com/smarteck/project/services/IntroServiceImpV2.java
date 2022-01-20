package tn.com.smarteck.project.services;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service

public class IntroServiceImpV2 implements IntroService{
	
	public String getHello() {
		return "Hello World!!!";
	}

}
