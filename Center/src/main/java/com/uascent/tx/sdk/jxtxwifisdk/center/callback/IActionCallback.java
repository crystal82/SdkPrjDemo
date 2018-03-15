package com.uascent.tx.sdk.jxtxwifisdk.center.callback;

/**
 * 作者：HWQ on 2018/3/13 18:11
 * 描述：
 */

public interface IActionCallback<T> {

    void onSuccess(T info, int action);

    void onError(int errorCode, String describe);
}
