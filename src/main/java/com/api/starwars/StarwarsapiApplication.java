package com.api.starwars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //si no queremos usarla la metemos dentro de una clase que se llama configuracion
public class StarwarsapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarwarsapiApplication.class, args);
	}
}
