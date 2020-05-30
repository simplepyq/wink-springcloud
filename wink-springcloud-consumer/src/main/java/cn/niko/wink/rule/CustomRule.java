package cn.niko.wink.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author niko.pan
 * @version 1.0.0
 * @since 2020/5/31 0:02
 */
@Log4j2
public class CustomRule extends AbstractLoadBalancerRule {

    private AtomicInteger nextServerCyclicCounter;

    @Override
    public Server choose(Object key) {
        ILoadBalancer iLoadBalancer = getLoadBalancer();
        List<Server> servers = iLoadBalancer.getAllServers();
        if (servers == null || servers.isEmpty()) {
            log.warn("no available server");
            return null;
        }
        return servers.get(0);
    }

    private int incrementAndGetModulo(int modulo) {
        for (;;) {
            int current = nextServerCyclicCounter.get();
            int next = (current + 1) % modulo;
            if (nextServerCyclicCounter.compareAndSet(current, next)) {
                return next;
            }
        }
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
