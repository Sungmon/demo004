package com.example.demo004;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class RefreshBeanEventListener implements ApplicationListener<EnvironmentChangeEvent> {

    @Autowired
    private ZAutoConfiguration configuration;

    @Override
    public void onApplicationEvent(EnvironmentChangeEvent event) {
        System.out.println("=====================1212");
        System.out.println(event);
        System.out.println(configuration.getTest().toString());
        // throw new UnsupportedOperationException("Unimplemented method 'onApplicationEvent'");
    }
}
