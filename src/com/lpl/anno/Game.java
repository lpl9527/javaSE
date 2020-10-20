package com.lpl.anno;

import java.lang.annotation.*;

/**
 * 游戏注解
 */
@Repeatable(People.class)   //@Game注解可重复标注，声明了此注解的目标注解必须要指定value属性
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Game {

    String value() default "";  //游戏名称

    String name() default "";   //游戏名称
}
