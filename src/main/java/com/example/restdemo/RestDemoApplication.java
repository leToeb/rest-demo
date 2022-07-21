package com.example.restdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

import com.example.restdemo.entity.DrittanbieterMock;

@SpringBootApplication
//Hinzufügen von @ConfigurationProperties Klassen zum Applikationsenvironment. Z.B: die Klasse Greeting
@ConfigurationPropertiesScan
public class RestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
	}

	//Erzeugung von Beans für die Environment Eigenschaften
	@Bean
	@ConfigurationProperties(prefix = "drittanbieter")
	DrittanbieterMock createDrittanbieterMock()
	{
		return new DrittanbieterMock();
	}

}
