package cn.niko.wink.springcloud.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author niko.pan
 * @version 1.0.0
 * @since 2020/5/30 23:45
 */
@RestController
@Log4j2
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment")
    public String payment() {
        return "get payment result success, port is " + port;
    }

    @PostMapping("/payment")
    public String post() {
        return "create payment success, order id is " + UUID.randomUUID() + ", port is " + port;
    }
}
