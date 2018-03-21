package com.uascent.tx.sdk.jxtxwifisdk.base;

import com.knight.ble.router.annotation.IntentCombineUri;
import com.knight.ble.router.annotation.IntentExactHostUri;
import com.knight.ble.router.annotation.ParamActionDescribe;
import com.knight.ble.router.annotation.ParamIntentExtrasData;
import com.uascent.tx.sdk.jxtxwifisdk.base.bean.DeviceBean;
import com.uascent.tx.sdk.jxtxwifisdk.base.bean.UserBean;

import java.util.ArrayList;

/**
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com ==>> baronzhang.com)
 *         2017/3/6
 */
public interface RouterService {

    @IntentExactHostUri("router://com.knight.main")
    void startMainActivity(@ParamActionDescribe("describe") String describe,
                           @ParamIntentExtrasData("user") UserBean userBean);

    @IntentCombineUri(scheme = "router", host = "com.knight.user")
    void startUserActivity(@ParamActionDescribe("describe") String describe,
                           @ParamIntentExtrasData("time") String time);

    @IntentCombineUri(scheme = "router", host = "com.knight.control", port =
            "6666", path = "/control")
    void startDeviceControlActivity(@ParamIntentExtrasData("user") UserBean userBean,
                                    @ParamIntentExtrasData("device") ArrayList<DeviceBean> deviceBeans);

    @IntentExactHostUri("router://com.knight.setnet")
    void startDeviceSetNetActivity(@ParamActionDescribe("describe") String describe,
                                   @ParamIntentExtrasData("type") String type,
                                   @ParamIntentExtrasData("time") String time,
                                   @ParamIntentExtrasData("user") UserBean userBean);
}
