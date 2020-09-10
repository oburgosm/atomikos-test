package com.bracso.test.atomikos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bracso.test.atomikos.OpenTracingDataSourcePostProcessor;
import io.opentracing.Tracer;

/**
 *
 * @author oburgosm
 */
@Configuration
public class OpenTracingConfiguration {
    
    private final Tracer tracer;

    public OpenTracingConfiguration(Tracer opentracingTracer) {
        this.tracer = opentracingTracer;
        io.opentracing.util.GlobalTracer.registerIfAbsent(opentracingTracer);
    }
    
    
    
    @Bean
    public OpenTracingDataSourcePostProcessor openTracingDataSourcePostProcessor() {
        return new OpenTracingDataSourcePostProcessor(this.tracer);
    }
    
}
