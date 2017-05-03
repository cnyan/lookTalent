package com.yan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class LookTalentApplication {

	public static void main(String[] args) {
		SpringApplication.run(LookTalentApplication.class, args);
	}
}
