package baat.ws.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("baat")
public class WSApplication {
	public static void main(String[] args) {
		SpringApplication.run(WSApplication.class, args);
	}
}
