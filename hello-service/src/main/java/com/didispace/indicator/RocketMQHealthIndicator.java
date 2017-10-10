package com.didispace.indicator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * 健康指示器  indicator“指示器，仪表盘”
 */
@Component
public class RocketMQHealthIndicator implements HealthIndicator{

    @Override
    public Health health() {
        int errorCode = check();
        if (errorCode != 0){
            return Health.down().withDetail("Error Code",errorCode).build();
        }
        return Health.up().build();
    }

    private int check(){
        return 0;
    }

}
