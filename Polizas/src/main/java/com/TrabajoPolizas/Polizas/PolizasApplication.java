package com.TrabajoPolizas.Polizas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PolizasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolizasApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return  args -> {
			System.out.println( "inicio la aplicación");
		};
	}
}
