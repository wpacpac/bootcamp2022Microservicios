package pe.com.bank.service.debit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BankServiceDebitApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServiceDebitApplication.class, args);
	}

}
