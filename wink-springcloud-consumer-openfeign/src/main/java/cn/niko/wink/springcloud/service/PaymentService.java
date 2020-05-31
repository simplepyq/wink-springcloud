package cn.niko.wink.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author niko.pan
 * @version 1.0.0
 * @since 2020/5/31 17:31
 */
@FeignClient(value = "wink-springcloud-payment")
public interface PaymentService {

    @GetMapping("/payment")
    public String payment();

    @PostMapping("/payment")
    public String post();
}
