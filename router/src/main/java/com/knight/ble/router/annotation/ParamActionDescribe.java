package com.knight.ble.router.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者： hwq
 * 创建时间：2018/3/21 1:11
 * 描述：页面跳转描述信息
 */

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamActionDescribe {
    String value();
}
