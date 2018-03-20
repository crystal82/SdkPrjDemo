package com.knight.ble.router.annotation;

/**
 * 作者： hwq
 * 创建时间：2018/3/21 1:09
 * 描述：Activity隐式跳转注解
 */

public @interface IntentCombineUri {
    String host();

    String path() default "";

    String port() default "";

    String scheme() default "";
}
