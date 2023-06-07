package com.czy.common;

import java.io.Serializable;

public interface IResultCode extends Serializable {
    String getMsg();

    int getCode();
}
