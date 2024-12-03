package org.josefalt.order_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * 
 */
@Configuration
public class WebClientConfig {

	/**
	 * Creates a bean named webClient
	 * 
	 * @return WebClient instance for interacting with our inventory service.
	 */
	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}
}
