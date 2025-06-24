package br.com.motocampos.system;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.motocampos.system.model.Cliente;
import br.com.motocampos.system.repository.ClienteRepository;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class MotoCamposSystemApplication {

	@Autowired
   
    public static void main(String[] args) {
        SpringApplication.run(MotoCamposSystemApplication.class, args);
    }

  
    }

	

