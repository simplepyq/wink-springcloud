package cn.niko.wink.springcloud;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author niko.pan
 * @version 1.0.0
 * @since 2020/5/31 17:30
 */
@SpringBootApplication
@EnableFeignClients
@Configuration
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    Logger.Level openfeignLog() {
        return Logger.Level.FULL;
    }
}
