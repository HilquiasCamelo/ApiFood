package com.hilquiascamelo.config;

import com.hilquiascamelo.services.BancoSeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;


@Configuration
public class DeveloperConfig {
  
	@Autowired
	private BancoSeedService bancoSeedService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		if (!"create".equals(strategy)) {
			return false;
		}
		
		bancoSeedService.instantiateTestDatabase();
		return true;
	}
	

}

