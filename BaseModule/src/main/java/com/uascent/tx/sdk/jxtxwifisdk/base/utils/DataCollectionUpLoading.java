package com.uascent.tx.sdk.jxtxwifisdk.base.utils;

/**
 * 作者：HWQ on 2018/3/13 14:10
 * 描述：采集行为数据时，通常需要在Web页面/App
 * 里面添加一些代码，当用户的行为达到某种条件时，就会向服务器上报用户的行为。
 * 其实添加这些代码的过程就可以叫做“埋点”，在很久以前就已经出现了这种技术。
 * <p>
 * 代码埋点：某种条件上班数据
 * <p>
 * 全埋点：某种行为数据全部上报，如点击||||Sensors Analytics
 * AndroidSDK全埋点的实现就是通过在代码编译阶段，找到源代码中需要上报事件的位置，
 * 插入SDK的事件上报代码。它用到的框架是 AspectJ 。
 * <p>
 * 可视化埋点：后台配置监视范围，
 * <p>
 * Android埋点SDK技术分析（注解日志和性能调优框架 Hugo ）
 */

public class DataCollectionUpLoading {
}
