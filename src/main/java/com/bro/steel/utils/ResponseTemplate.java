package com.bro.steel.utils;

import lombok.Builder;
import lombok.Data;

/**
 * @author zhanghonglin
 * @date 2020/12/14 19:30
 * @class ResponseTemplate
 * @description ResponseTemplate
 */
@Builder
@Data
public class ResponseTemplate {

    public Integer code;

    public String message;

    public Object data;

}
