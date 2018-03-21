package com.knight.libmodule;

import java.io.IOException;

/**
 * 作者：HWQ on 2018/3/7 16:41
 * 描述：
 */

public interface RequestBack {
    void onFailure(IOException e);

    void onResponse(String info);
}
