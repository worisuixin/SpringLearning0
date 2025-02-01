package com.itbaima.test;

import com.itbaima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
    public static void main(String[] args) {
//        这里这个url到底是谁，无所谓，只要是xml文件即可，只要里面配置了bean的信息就可以了。  不过一般是叫applicationContext.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService) context.getBean("userService");   //这里其实是会将那个id转换为这个beanname进行传递的
//        这里就实现了几行代码实现了相同的功能，更加强大，所以用这个applicinationContext，但是底层还是BeanFactory
        System.out.println(userService);
    }
}
