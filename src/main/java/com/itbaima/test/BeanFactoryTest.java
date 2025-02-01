package com.itbaima.test;

import com.itbaima.dao.UserDao;
import com.itbaima.service.UserService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {
    public static void main(String[] args) {
//        创建工厂对象  DefaultListableBeanFactory是Spring提供的一个实现类，它用于存储和管理Bean定义。
//        BeanFactory是Spring的核心容器，用于获取和管理应用程序中的Bean。
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

//        创建读取器，读取xml文件   这里创建了一个XmlBeanDefinitionReader对象，并将其与前面创建的beanFactory关联。
//        该类负责解析XML配置文件并将其加载到BeanFactory中。     配置文件中的bean类 用BeanFactory去加载。
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

//        读取配置文件给工厂  使用loadBeanDefinitions方法加载配置文件beans.xml。
//        ClassPathResource表示这个文件位于类路径下。
        reader.loadBeanDefinitions(new ClassPathResource("beans.xml"));

//        根据id获取bean实例对象  通过getBean方法使用userService的id来从beanFactory中获取UserService类型的Bean实例，
//        并将其强制转换为UserService类型。
        UserService userService = (UserService)beanFactory.getBean("userService");
//        这里就用到了ioc控制反转的思想，这里从未去手动创建一个类，而是把创建的权利给了BeanFactory。

        System.out.println(userService);

        UserDao userDao = (UserDao)beanFactory.getBean("userDao");
        System.out.println(userDao);
    }
}
