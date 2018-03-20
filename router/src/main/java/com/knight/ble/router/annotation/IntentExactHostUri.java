package com.knight.ble.router.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者： hwq
 * 创建时间：2018/3/21 1:14
 * 描述：精确的Uri
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IntentExactHostUri {
    String value() default "";
}
