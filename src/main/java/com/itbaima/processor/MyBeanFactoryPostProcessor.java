package com.itbaima.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("当放到map之后，在Bean实例化之前就会去执行");
//        甚至都不用调用，因为这个会自动的实例化。    这个方法的参数就是继承自BeanFactory，    所以直接参数就是BeanFactory
    }
}
