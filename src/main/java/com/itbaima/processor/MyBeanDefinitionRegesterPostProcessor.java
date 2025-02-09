package com.itbaima.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class MyBeanDefinitionRegesterPostProcessor implements BeanDefinitionRegistryPostProcessor {

    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        BeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClassName("com.itbaima.dao.impl.PersonDaoImpl");
        registry.registerBeanDefinition("personDao", beanDefinition);
//        这里就不需要强制转换了，因为这个接口的参数实现了这个东西，直接用就行。
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }

//    这个就需要两个方法都实现。一个是BeanFactoryPostProcessor，一个是BeanDefinitionRegistryPostProcessor.当然执行顺序是先后者再前者
}
