package pe.com.bank.service.credit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BankServiceCreditApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServiceCreditApplication.class, args);
	}

}
