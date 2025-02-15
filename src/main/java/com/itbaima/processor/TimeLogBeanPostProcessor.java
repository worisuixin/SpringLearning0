package com.itbaima.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * 时间日志功能的demo演示
 * 需要用到动态代理的知识点
 */
public class TimeLogBeanPostProcessor implements BeanPostProcessor {
    @Override
    //此后所有的bean创建的时候都会过这个方法，即都会执行这个方法中的操作。同理，也是需要将其配置到bean.xml文件中才能使用
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //使用动态代理对目标Bean进行增强，返回proxy对象，进而存储到单例池SingletonObject中
        Object beanProxy = Proxy.newProxyInstance(
                bean.getClass().getClassLoader(),
                bean.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //1输出开始时间
                        System.out.println(method.getName() + "开始时间" + new Date());
                        //2执行目标方法  原来的方法就写到这里，方法之外的就是动态代理增强的方法。
                        Object result = method.invoke(bean, args);
                        //3输出结束时间
                        System.out.println(method.getName() + "结束时间" + new Date());
                        return result;
                    }
                }
        );
        return beanProxy; //这个增强后的类就会存储到SingletonObject中
    }
}
