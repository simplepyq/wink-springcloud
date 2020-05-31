package cn.niko.wink.springcloud.controller;

import cn.niko.wink.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author niko.pan
 * @version 1.0.0
 * @since 2020/5/31 22:31
 */
@RestController
@Log4j2
@DefaultProperties(defaultFallback = "globalHystrixHandler")
public class ConsumerController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer")
    public String get() {
        return paymentService.get();
    }

    @PostMapping("/consumer")
    @HystrixCommand
    public String post() {
        return paymentService.post();
    }

    private String globalHystrixHandler(){
        return "Global Hystrix Handler: 服务异常或超时";
    }
}
