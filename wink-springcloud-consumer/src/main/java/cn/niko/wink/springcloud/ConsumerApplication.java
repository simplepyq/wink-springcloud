package cn.niko.wink.springcloud;

import cn.niko.wink.rule.BalancerRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author niko.pan
 * @version 1.0.0
 * @since 2020/5/30 11:21
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "wink-springcloud-payment", configuration = BalancerRuleConfig.class)
@Configuration
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
