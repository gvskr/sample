package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
	return String.format("Hello %s!", name);
	}
	
	@GetMapping("/ktoc")
	public String ktoc(@RequestParam(value = "temp") double temp) {
		double name=temp+273.15;
		return String.format("Celsius %s!", name);
		}
	
	@GetMapping("/ctok")
	public String ctok(@RequestParam(value = "temp") double temp) {
		double name=temp-273.15;
		return String.format("Kelvin %s!", name);
		}
	
	@GetMapping("/mtok")
	public String mtok(@RequestParam(value = "miles") double miles) {
		double name=miles*1.6;
		return String.format("Kilometers %s!", name);
		}
	
	@GetMapping("/ktom")
	public String ktom(@RequestParam(value = "kilos") double kilos) {
		double name=kilos/1.6;
		return String.format("Miles %s!", name);
		}
	
}
