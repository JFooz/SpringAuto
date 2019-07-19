package com.foozcorp.SpringAuto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringautoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringautoApplication.class, args);
	}

}
