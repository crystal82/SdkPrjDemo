package com.uascent.tx.sdk.jxtxwifisdk.base.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 作者：HWQ on 2018/3/21 16:22
 * 描述：
 */

public class UserBean implements Parcelable {

    private String name;
    private String userName;
    private String token;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.userName);
        dest.writeString(this.token);
    }

    public UserBean() {
    }

    protected UserBean(Parcel in) {
        this.name = in.readString();
        this.userName = in.readString();
        this.token = in.readString();
    }

    public static final Parcelable.Creator<UserBean> CREATOR = new Parcelable
            .Creator<UserBean>() {
        @Override
        public UserBean createFromParcel(Parcel source) {
            return new UserBean(source);
        }

        @Override
        public UserBean[] newArray(int size) {
            return new UserBean[size];
        }
    };
}
