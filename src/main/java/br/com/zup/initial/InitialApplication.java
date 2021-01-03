package br.com.zup.initial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
@SpringBootApplication
public class InitialApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitialApplication.class, args);
	}

}
