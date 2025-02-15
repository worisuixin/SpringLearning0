package com.itbaima.processor;

import com.itbaima.utils.BaseClassScanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.util.Map;

/**
 * 写这个类就是为了去实现直接将需要的bean直接注册到BeanMap里面，就可以直接去使用了。即依旧不用写到配置文件
 * 演示自定义的注解开发
 */

public class MyComponentBeanFactoryPostPocessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
//        通过扫描工具去扫描指定包及其子包下的所有类，收集使用@MyComponent注解的类
        Map<String, Class> myComponentAnnotationMap = BaseClassScanUtils.scanMyComponentAnnotation("com.itbaima");
//        遍历这个map，进而将这个所有的有这个注解的类组装为BeanDefinition进行注册
        myComponentAnnotationMap.forEach((beanName, clazz) -> {
//            获取beanClassName
            String beanClassName = clazz.getName();  //获取的就是那个全限定名，就是那个class属性
//            创建BeanDefinition
            BeanDefinition beanDefinition = new RootBeanDefinition();
            beanDefinition.setBeanClassName(beanClassName);
//            注册
            beanDefinitionRegistry.registerBeanDefinition(beanClassName, beanDefinition);

        });
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
