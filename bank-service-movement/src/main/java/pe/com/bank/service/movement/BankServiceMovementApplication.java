package pe.com.bank.service.movement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BankServiceMovementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServiceMovementApplication.class, args);
	}

}
