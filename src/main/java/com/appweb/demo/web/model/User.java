package com.appweb.demo.web.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by zhangxiaoman on 2018/11/5.
 */
@Getter
@Setter
@Builder
public class User {

    String name;

    String id;

    Integer age;
}
