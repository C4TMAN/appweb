package com.appweb.demo.mvc;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by zhangxiaoman on 2018/11/5.
 */
@Getter
@Setter
public class BaseRequest<T> {
    String sign;

    String data;
}
