package ru.vladigeras.springneo4j.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * @author vladi_geras on 09.01.2020
 */
@EnableNeo4jRepositories("ru.vladigeras.springneo4j.repository")
@EntityScan(basePackages = "ru.vladigeras.springneo4j.model")
@Configuration
public class Neo4jConfiguration {
	@Value("${datasource.host}")
	private String host;

	@Value("${datasource.port}")
	private String port;

	@Value("${datasource.username}")
	private String username;

	@Value("${datasource.password}")
	private String password;

	@Bean
	public org.neo4j.ogm.config.Configuration configuration() {
		return new org.neo4j.ogm.config.Configuration.Builder()
				.uri("bolt://" + host + ":" + port)
				.credentials(username, password)
				.build();
	}
}
