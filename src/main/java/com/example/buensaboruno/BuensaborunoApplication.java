package com.example.buensaboruno;

import com.example.buensaboruno.config.DataLoader;
import com.example.buensaboruno.domain.entities.*;
import com.example.buensaboruno.domain.enums.*;
import com.example.buensaboruno.domain.enums.*;
import com.example.buensaboruno.repositories.*;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.Random;


@SpringBootApplication
public class BuensaborunoApplication {
	private static final Logger logger = LoggerFactory.getLogger(BuensaborunoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BuensaborunoApplication.class, args);
		logger.info("Estoy activo en el main");
	}

	@Bean
	public CommandLineRunner init(DataLoader dataLoader) {
		return args -> dataLoader.loadData().run(args);
	}
}



