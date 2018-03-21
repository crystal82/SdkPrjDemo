package com.uascent.tx.sdk.jxtxwifisdk.base.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 作者：HWQ on 2018/3/21 16:39
 * 描述：
 */

public class DeviceBean implements Parcelable {
    String deviceType;
    String deviceName;
    String deviceId;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.deviceType);
        dest.writeString(this.deviceName);
        dest.writeString(this.deviceId);
    }

    public DeviceBean() {
    }

    protected DeviceBean(Parcel in) {
        this.deviceType = in.readString();
        this.deviceName = in.readString();
        this.deviceId = in.readString();
    }

    public static final Parcelable.Creator<DeviceBean> CREATOR = new Parcelable
            .Creator<DeviceBean>() {
        @Override
        public DeviceBean createFromParcel(Parcel source) {
            return new DeviceBean(source);
        }

        @Override
        public DeviceBean[] newArray(int size) {
            return new DeviceBean[size];
        }
    };
}
