/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.cloud.config.server.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.cloud.config.server.environment.NativeEnvironmentRepository;
import org.springframework.cloud.config.server.environment.SearchPathLocator;
import org.springframework.cloud.config.server.jpa.ConfigInfoRepository;
import org.springframework.cloud.config.server.jpa.JdbcEnvironmentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Venil Noronha
 */
@Configuration
@EnableJpaRepositories("org.springframework.cloud.config.server.jpa")
@EntityScan(basePackages = {"org.springframework.cloud.config.server.jpa"})
@ComponentScan(basePackages = {"org.springframework.cloud.config.server.jpa"})
public class JdbcEnvironmentRepositoryConfiguration {

	@Autowired
	private ConfigurableEnvironment environment;

	@Autowired
	private ConfigInfoRepository configInfoRepository;

	@Bean
	public SearchPathLocator searchPathLocator() {
		return new NativeEnvironmentRepository(environment);
	}

	@Bean
	@Primary
	public EnvironmentRepository environmentRepository() {
		return new JdbcEnvironmentRepository(configInfoRepository);
	}

}
