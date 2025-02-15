package com.itbaima.processor;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 演示Spring后处理器的BeanPostProcessor.
 * 这个没写完，功能上就是实例化之后先执行before，然后是属性填充，实例化，最后是after。
 * 这个就不是普通的bean了，但也是需要配置到bean.xml文件中，只不过和普通的bean的配置不一样。
 * 但是这个例子应该是没配置
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override   //先执行
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override  //后执行
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
