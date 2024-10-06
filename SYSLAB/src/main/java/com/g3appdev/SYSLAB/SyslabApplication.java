package com.g3appdev.SYSLAB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SyslabApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyslabApplication.class, args);
	}
	
	public String print(){
		return("FirstName, LastName");
	}
}
