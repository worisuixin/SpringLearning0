package com.itbaima.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("当放到map之后，在Bean实例化之前就会去执行");
//        甚至都不用调用，因为这个会自动的实例化。    这个方法的参数就是继承自BeanFactory，    所以直接参数就是BeanFactory

       // BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
       // beanDefinition.setBeanClassName("com.itbaima.dao.impl.UserDaoImpl");
        //这里，就是在pastProcessor中进行修改，也就是其作用。当然，会导致使其原本的bean被修改，进而导致无法正常运行。


//        下面演示没写入xml配置文件，但是直接就注册到map里面进行实例化。
//        注册BeanDefinition
        BeanDefinition beanDefinition = new RootBeanDefinition(); //因为这个类实现了BeanDefinition的接口，所以用来实例化
        beanDefinition.setBeanClassName("com.itbaima.dao.impl.PersonDaoImpl");
//        强转为DefaultListableBeanFactory     因为只有这个类有特定的注册方法，所以要强制转为这个类。
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;
        defaultListableBeanFactory.registerBeanDefinition("personDao", beanDefinition);
    }
}
