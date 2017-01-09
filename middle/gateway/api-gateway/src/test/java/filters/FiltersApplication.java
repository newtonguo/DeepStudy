package filters;

import com.netflix.zuul.ZuulFilter;
import config.GlobalConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringCloudApplication
@EnableAutoConfiguration
@RestController
@EnableZuulServer
public class FiltersApplication {

//		@RequestMapping("/local")
//		public String local() {
//			return "Hello local";
//		}

    @RequestMapping("/hello")
    public String home() {
        return GlobalConfig.HelloStr;
    }

//    @Bean
//    public ZuulFilter sampleFilter() {
//        return new AccessLogFilter();
//    }

    public static void main(String[] args) {
        SpringApplication.run(FiltersApplication.class, args);

    }
}

