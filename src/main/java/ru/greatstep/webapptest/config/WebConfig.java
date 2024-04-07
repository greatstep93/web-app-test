package ru.greatstep.webapptest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.web.reactive.config.BlockingExecutionConfigurer;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {

    @Override
    public void configureBlockingExecution(BlockingExecutionConfigurer configurer) {
        var executor = new SimpleAsyncTaskExecutor();
        executor.setConcurrencyLimit(1);
        executor.setVirtualThreads(false);
        configurer.setExecutor(executor);
    }

}
