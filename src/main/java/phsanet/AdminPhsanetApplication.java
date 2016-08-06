package phsanet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("phsanet")
public class AdminPhsanetApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminPhsanetApplication.class, args);
	}
}
