package com.salecampaign.salecampaign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

public class AsyncConfig {
    @Bean("campaignExecutor")
    public Executor campaignExecutor(){
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(10);     // Can expand to 10
        executor.setQueueCapacity(50);   // Waiting queue
        executor.setThreadNamePrefix("Campaign-Thread-");
        executor.initialize();
        return executor;
    }
}
