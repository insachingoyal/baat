package baat.conf.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("baat")
public class ConfApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConfApplication.class, args);
	}
}
