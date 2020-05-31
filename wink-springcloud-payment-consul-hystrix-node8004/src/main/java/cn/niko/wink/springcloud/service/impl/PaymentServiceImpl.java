package cn.niko.wink.springcloud.service.impl;

import cn.niko.wink.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author niko.pan
 * @version 1.0.0
 * @since 2020/5/31 22:03
 */
@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String get() {
        return Thread.currentThread().getName() + " get payment success, time is " + LocalDateTime.now();
    }

    @Override
    @HystrixCommand(fallbackMethod = "hystrixHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String post() {
//        int age = 10 / 0;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.error("timeout, e -> {}", e.getMessage());
        }
        return Thread.currentThread().getName() + " create payment success, uuid is " + UUID.randomUUID();
    }

    private String hystrixHandler() {
        return Thread.currentThread().getName() + " 服务异常或访问超时，请稍后再试！";
    }
}
