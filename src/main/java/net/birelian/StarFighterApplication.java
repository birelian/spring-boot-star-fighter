package net.birelian;

import org.springframework.aop.aspectj.annotation.AbstractAspectJAdvisorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarFighterApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(StarFighterApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StarFighterApplication.class, args);
		LOGGER.info("Han Solo!");
	}
}
