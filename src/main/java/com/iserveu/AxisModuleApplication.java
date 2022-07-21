package com.iserveu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.JAXBException;

@SpringBootApplication
public class AxisModuleApplication {


	public static void main(String[] args) throws JAXBException {

		SpringApplication.run(AxisModuleApplication.class, args);

	}

}
