package cn.niko.wink.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author niko.pan
 * @version 1.0.0
 * @since 2020/5/31 0:12
 */
@Configuration
public class BalancerRuleConfig {

    @Bean
    public IRule customRule(){
        return new CustomRule();
    }
}
