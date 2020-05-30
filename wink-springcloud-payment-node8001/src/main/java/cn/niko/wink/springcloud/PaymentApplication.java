package cn.niko.wink.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author niko.pan
 * @version 1.0.0
 * @since 2020/5/29 23:36
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class);
    }
}
