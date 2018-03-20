package com.knight.ble.router.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者： hwq
 * 创建时间：2018/3/21 1:12
 * 描述：相关参数Key
 */

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamIntentExtrasData {
    String value();
}
