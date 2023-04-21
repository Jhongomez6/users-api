package com.example.eafit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.eafit"})
public class RegistroUsuariosApplication {
	public static void main(String[] args) {
		SpringApplication.run(RegistroUsuariosApplication.class, args);
	}
}
