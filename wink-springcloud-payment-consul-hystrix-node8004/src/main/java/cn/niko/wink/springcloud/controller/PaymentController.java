package cn.niko.wink.springcloud.controller;

import cn.niko.wink.springcloud.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author niko.pan
 * @version 1.0.0
 * @since 2020/5/31 21:56
 */
@RestController
@Log4j2
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment")
    public String get() {
        return paymentService.get();
    }

    @PostMapping("/payment")
    public String post() {
        return paymentService.post();
    }
}
