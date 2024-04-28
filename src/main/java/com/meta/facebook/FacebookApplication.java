package com.meta.facebook;

import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.meta.facebook.Run.*;

@SpringBootApplication
public class FacebookApplication {
	
	//	use to log out on console
	private static final Logger log = LoggerFactory.getLogger(FacebookApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(FacebookApplication.class, args);
		// log.info('Hello deez nuts!!')
	}
	
	
	@Bean
//	CommandLineRunner runner(RunRepository runRepository) {
	CommandLineRunner runner(RunRepository runRepository) {
		// a command line runner is something that runs after the entire app context or containers of the beans has been created
		return args -> {
			Run run = new Run(2,"First run",LocalDateTime.now(),LocalDateTime.now().plus(1,ChronoUnit.HOURS),5,Location.OUTDOOR);
//			log.info("Run: "+run);
//			runRepository.create(run);
		};
	}

}
