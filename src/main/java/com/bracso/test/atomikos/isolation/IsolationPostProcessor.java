package com.bracso.test.atomikos.isolation;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.jdbc.datasource.IsolationLevelDataSourceAdapter;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

/**
 * @author oburgosm
 */
public class IsolationPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof DataSource) {
            DataSource ds = (DataSource) bean;
            IsolationLevelDataSourceAdapter isolationds = new IsolationLevelDataSourceAdapter();
            isolationds.setTargetDataSource(ds);
            return new TransactionAwareDataSourceProxy(isolationds);
        } else {
            return bean;
        }
    }

}
