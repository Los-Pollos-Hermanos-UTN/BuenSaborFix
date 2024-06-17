package com.example.buensaboruno;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BuensaborunoApplication {
	private static final Logger logger = LoggerFactory.getLogger(BuensaborunoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BuensaborunoApplication.class, args);
		logger.info("Estoy activo en el main");
	}


}



