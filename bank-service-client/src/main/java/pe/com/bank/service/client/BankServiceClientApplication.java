package pe.com.bank.service.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BankServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServiceClientApplication.class, args);
	}

}
