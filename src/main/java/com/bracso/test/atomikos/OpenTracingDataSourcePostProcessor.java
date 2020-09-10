package com.bracso.test.atomikos;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.atomikos.opentracing.jdbc.OpenTracingDataSourceBean;
import io.opentracing.Tracer;


/**
 *
 * @author oburgosm
 */
public class OpenTracingDataSourcePostProcessor implements BeanPostProcessor {
    
    private final Tracer tracer;

    public OpenTracingDataSourcePostProcessor(Tracer tracer) {
        this.tracer = tracer;
    }
    
    

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof DataSource) {
            return new OpenTracingDataSourceBean((DataSource) bean);
        }
        return bean;
    }
    
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        if (bean instanceof DataSource) {
//            return new TracingDataSource(this.tracer, (DataSource) bean);
//        }
//        return bean;
//    }
    
    
    
}
