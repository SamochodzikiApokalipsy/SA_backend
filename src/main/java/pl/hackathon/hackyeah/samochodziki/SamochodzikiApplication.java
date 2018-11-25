package pl.hackathon.hackyeah.samochodziki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SamochodzikiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamochodzikiApplication.class, args);
	}
}
