package cn.niko.wink.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author niko.pan
 * @version 1.0.0
 * @since 2020/5/31 22:29
 */

@FeignClient(value = "wink-springcloud-payment", fallback = PaymentHystrixService.class)
public interface PaymentService {

    @GetMapping("/payment")
    public String get();

    @PostMapping("/payment")
    public String post();
}
