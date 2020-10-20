package com.lpl.anno;

import java.lang.annotation.*;

/**
 * 人类注解
 */
@Documented     //将注解中的元素包含到Javadoc中
@Inherited      //该注解修饰了一个父类，如果子类没有被其它注解修饰，则它的子类也继承了该父类的注解
@Retention(RetentionPolicy.RUNTIME)     //该注解会在运行时存在（存在于class字节码文件中）
@Target(ElementType.TYPE)   //作用于接口、类、枚举、注解上
public @interface People {

    String name() default "人类";    //注解属性，姓名

    int age() default 0;       //注解属性，年龄

    Game[] value() ;    //玩的游戏，定义为游戏注解类型数组

}
