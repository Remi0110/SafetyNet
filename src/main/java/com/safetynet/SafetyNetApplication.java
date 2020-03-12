package com.safetynet;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.model.Model;

@SpringBootApplication
public class SafetyNetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafetyNetApplication.class, args);
	}
	private static String file = "src/main/resources/data.json";

	@Bean
	public Model loadModel() throws IOException {
		return this.readJsonFile(file);
	}

	@Bean
	public HttpTraceRepository httpTraceRepository() {
		return new InMemoryHttpTraceRepository();
	}

	public Model readJsonFile(String file) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(new File(file), Model.class);
	}
}
