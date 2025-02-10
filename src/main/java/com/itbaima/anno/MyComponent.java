package com.itbaima.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解扫描示例代码
 */
@Target(ElementType.TYPE)  //注解使用范围：类
@Retention(RetentionPolicy.RUNTIME)  //注解保留阶段：整个运行期间
public @interface MyComponent {
    String value();  //这是注解的变量，要加一个括号。   声明为value就可以在声明注解的时候不用写这个value，直接写值
}
