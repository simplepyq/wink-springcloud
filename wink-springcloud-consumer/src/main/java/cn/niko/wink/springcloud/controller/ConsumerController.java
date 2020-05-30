package cn.niko.wink.springcloud.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author niko.pan
 * @version 1.0.0
 * @since 2020/5/30 11:22
 */
@RestController
@Log4j2
public class ConsumerController {

    private static final String URI = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String consumer() {
        return restTemplate.getForEntity(URI + "/payment", String.class).getBody();
    }

    @PostMapping("/consumer")
    public String post() {
        return restTemplate.postForEntity(URI+"/payment", null, String.class).getBody();
    }
}
