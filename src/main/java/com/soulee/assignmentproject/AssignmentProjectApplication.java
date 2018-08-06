package com.soulee.assignmentproject;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.google.common.collect.ImmutableMap;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com")
@EnableJpaRepositories("com")
public class AssignmentProjectApplication {
	
	private static final String CONFIG_NAME = "application";

	public static void main(String[] args) {
//		SpringApplication.run(AssignmentProjectApplication.class, args);
		new SpringApplicationBuilder(AssignmentProjectApplication.class)
		.properties(ImmutableMap.of("spring.config.name", CONFIG_NAME)).build().run(args);
	}
}
