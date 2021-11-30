package mendes.vinny.Clinica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.PropertyConfigurator;

@SpringBootApplication
public class ClinicaApplication {

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		SpringApplication.run(ClinicaApplication.class, args);
	}

}
