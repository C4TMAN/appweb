package com.appweb.demo.mvc;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by zhangxiaoman on 2018/11/5.
 */
@Getter
@Setter
public class BaseResponse {
    String sign;

    String data;

    String code;

    String msg;
}
