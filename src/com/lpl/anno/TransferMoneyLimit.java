package com.lpl.anno;

import java.lang.annotation.*;

/**
 * 定义转账限额注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TransferMoneyLimit {

    double maxMoney() default 10000;    //转账限额，默认值为10000
}
