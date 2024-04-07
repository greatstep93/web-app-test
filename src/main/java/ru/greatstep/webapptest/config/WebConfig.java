package ru.greatstep.webapptest.config;

import static java.util.Objects.nonNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.lang.NonNull;
import org.springframework.web.reactive.config.BlockingExecutionConfigurer;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {

    @Value("${virtual}")
    private Boolean isVirtual;
    @Value("${limit}")
    private Integer limit;

    @Override
    public void configureBlockingExecution(@NonNull BlockingExecutionConfigurer configurer) {
        var executor = new SimpleAsyncTaskExecutor();
        executor.setConcurrencyLimit(nonNull(limit) && limit > 200 ? limit : 200);
        var factory = isVirtual
                ? Thread.ofVirtual().factory()
                : Thread.ofPlatform().factory();
        executor.setThreadFactory(factory);
        configurer.setExecutor(executor);
    }

}
