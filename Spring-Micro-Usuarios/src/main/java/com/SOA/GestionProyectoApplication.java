package com.SOA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//habilitar tipo de proyecto eureka client
@EnableDiscoveryClient
public class GestionProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionProyectoApplication.class, args);
	}

}
