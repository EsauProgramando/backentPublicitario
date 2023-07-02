package Trabajo.Grupal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GrupalApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrupalApplication.class, args);
	}
	@Bean
	 public static  BCryptPasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	 }

}
