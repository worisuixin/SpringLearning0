package com.itbaima.test;

import com.itbaima.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

public class ApplicationContextTest {
    public static void main(String[] args) throws IOException {
//        这里这个url到底是谁，无所谓，只要是xml文件即可，只要里面配置了bean的信息就可以了。  不过一般是叫applicationContext.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService) context.getBean("userService");   //这里其实是会将那个id转换为这个beanname进行传递的
//        这里就实现了几行代码实现了相同的功能，更加强大，所以用这个applicinationContext，但是底层还是BeanFactory
        System.out.println(userService);
        Object myBeanFactory1 = context.getBean("myBeanFactory1");
        System.out.println(myBeanFactory1);


        Object druidMysql = context.getBean("druidMysql");
        System.out.println(druidMysql);


        /**
//        理论上该怎么配置这个mybatis的SqlSessionFactory
// 静态工厂方法方式
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
// 无参构造实例化
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
// 实例工厂方法
        SqlSessionFactory sqlSessionFactory = builder.build(in);
//        这是基本的使用流程，但是spring的作用就是将变量的初始化交给spring。所以可以在配置文件中去配置，进而去使用，不需要显示的构造。
**/
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println(sqlSession);


    }
}
