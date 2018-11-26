package com.java;

/**
 * 业务类型枚举
 * Author: Boris
 * Date: 2018/11/23 18:06
 * Description:
 */
public enum ESConnnectionTypeEnum {


    COMPUTE_USER("compute_user", "计算人群业务"),
        ;
    private String key;
    private String desc;

    ESConnnectionTypeEnum(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public String getKey() {
        return key;
    }

    public String getDesc() {
        return desc;
    }
}
