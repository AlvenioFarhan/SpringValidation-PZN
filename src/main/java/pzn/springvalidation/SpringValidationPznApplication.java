package pzn.springvalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pzn.springvalidation.properties.DatabaseProperties;

@EnableConfigurationProperties({
		DatabaseProperties.class
})
@SpringBootApplication
public class SpringValidationPznApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringValidationPznApplication.class, args);
	}

}
