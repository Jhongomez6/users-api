package com.example.eafit;

import com.example.eafit.filters.JwtFilter;
import com.example.eafit.utils.JwtUtil;
import jakarta.servlet.DispatcherType;
import java.util.Base64;
import java.util.EnumSet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

@SpringBootApplication(scanBasePackages = {"com.example.eafit"})
public class RegistroUsuariosApplication {
	public static void main(String[] args) {
		SpringApplication.run(RegistroUsuariosApplication.class, args);
	}
}
