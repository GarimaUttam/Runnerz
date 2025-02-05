package com.garima.runnerz;

import com.garima.runnerz.run.Location;
import com.garima.runnerz.run.Run;
import com.garima.runnerz.run.RunRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}
//	Record - it is immutable we cnt change it later no neeed to putt getters and setters, contructures here
//  MVC = model view Controller
//	model(thing or type that we are going to work with) = Run , Location
// view(Represent) - Json
//	Controller -> dont do anything give tasks to some other classes take a response return back the response

	@Bean
	CommandLineRunner runner(RunRepository runRepository) {
		return args -> {
			Run run = new Run(1, "first run", LocalDateTime.now(),LocalDateTime.now().plus(1, ChronoUnit.HOURS), 3, Location.OUTDOOR);
			runRepository.create(run);
		};
	}

}
