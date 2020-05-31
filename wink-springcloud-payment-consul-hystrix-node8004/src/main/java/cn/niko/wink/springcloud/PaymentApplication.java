package cn.niko.wink.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author niko.pan
 * @version 1.0.0
 * @since 2020/5/31 21:51
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class PaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }
}
