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

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MysqlConfigServerApplication.class})
@WebAppConfiguration
@ActiveProfiles("mysql")
public class MysqlEnvTest {

    String appName = "test-app";
    String profile = "dev";
	@Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ConfigInfoRepository configInfoRepository;

    @Before
    public void ini(){
        ConfigInfo configInfo = new ConfigInfo();
        configInfo.setApplication(appName);
        configInfo.setProfile(profile);
        configInfo.setKey("demo-key");
        configInfo.setValue("ssdd");
        configInfo.setLable("lable");
//        configInfo.setDelStatus(1);
//        configInfo.setDescription("desc");
        configInfoRepository.save(configInfo);
    }

    @Test
    public void repositoryTest(){
        Iterable<ConfigInfo> all = configInfoRepository.findAll();

        log.info("repositoryTest" + all.toString());

        log.info("repositoryTest" + configInfoRepository.findByApplicationAndProfile(appName,profile));
    }

//    @Test
//    public void selTest(){
//        String sql = "select * from config_info where application='test-app' and profile='dev'";
//        List<ConfigInfo> sel = jdbcTemplate.queryForList(sql, ConfigInfo.class);
//        System.out.println("SqlResult"+JSON.toJSONString(sel));
//    }

}

// Don't use @SpringBootApplication because we don't want to component scan
@Configuration
@EnableAutoConfiguration
@EnableMysqlConfigServer
@RestController
class MysqlConfigServerApplication {

    @RequestMapping("/local")
    public String local() {
        return "Hello local";
    }

    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }

}