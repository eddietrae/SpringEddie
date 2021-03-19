package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Dog;

@Configuration
public class BeanConfig {
	@Bean
	public Dog dog() {
		Dog bean = new Dog("bo");
		return bean;
	}
}
