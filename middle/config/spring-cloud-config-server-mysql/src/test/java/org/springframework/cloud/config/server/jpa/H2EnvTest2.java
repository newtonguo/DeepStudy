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

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.Assert.assertEquals;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DemoConfigServerApplication.class})
@WebAppConfiguration
public class H2EnvTest2 {

    String appName = "config-server";
    String profile = "dev";


	@Autowired
    private JdbcTemplate jdbcTemplate;


    @Autowired
    EnvironmentRepository repository ;

    @Autowired
    org.springframework.core.env.Environment env;;
    @Autowired
    private ConfigInfoRepository configInfoRepository;

    @Before
    public void ini(){
        ConfigInfo configInfo = new ConfigInfo();
        configInfo.setApplication(appName);
        configInfo.setProfile(profile);
        configInfo.setKey("ss");
        configInfo.setValue("ssdd");
        configInfoRepository.save(configInfo);
    }

    @Test
    public void repositoryTest(){

        //		// Test

		Environment environment = repository.findOne(appName,profile, null);
        log.info(JSON.toJSONString(environment));
        log.info(env.getProperty("ss"));
//		assertEquals("testapp-default", environment.getPropertySources().get(0).getName());
//		assertEquals(1, environment.getPropertySources().size());
//		assertEquals(true, environment.getPropertySources().get(0).getSource().containsKey("testkey"));
//		assertEquals("testval", environment.getPropertySources().get(0).getSource().get("testkey"));

    }



}


// Don't use @SpringBootApplication because we don't want to component scan
@Configuration
@EnableAutoConfiguration
@EnableMysqlConfigServer
@RestController
class DemoConfigServerApplication {
//    @Value("${ss}")
//    String port;
    @RequestMapping("/local")
    public String local() {
        return "Hello local";
    }

    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }

}