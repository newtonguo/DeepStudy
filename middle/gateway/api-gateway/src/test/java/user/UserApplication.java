package user;

import com.netflix.zuul.ZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringCloudApplication
@EnableAutoConfiguration
@EnableCircuitBreaker
@RestController
@EnableZuulServer
public class UserApplication {

//		@RequestMapping("/local")
//		public String local() {
//			return "Hello local";
//		}

    @RequestMapping("/hello")
    public String home() {
        return "sssss";
    }

//    @Bean
//    public ZuulFilter sampleFilter() {
//        return new AccessLogFilter();
//    }




    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);

    }
}

