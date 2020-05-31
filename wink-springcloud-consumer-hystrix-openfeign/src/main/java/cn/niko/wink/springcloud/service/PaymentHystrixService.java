package cn.niko.wink.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @author niko.pan
 * @version 1.0.0
 * @since 2020/5/31 22:54
 */
@Service
public class PaymentHystrixService implements PaymentService {

    @Override
    public String get() {
        return "get method exception";
    }

    @Override
    public String post() {
        return "post method exception";
    }
}
