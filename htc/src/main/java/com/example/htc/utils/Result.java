package com.example.htc.utils;


import com.example.htc.constant.ResponseCode;

import java.io.Serializable;

public class Result implements Serializable {

    //uuid,用作唯一标识符，供序列化和反序列化时检测是否一致
    private static final long serialVersionUID = 7498483649536881777L;
    //标识代码，0表示成功，非0表示出错
    private Integer code;
    //提示信息，通常供报错时使用
    private String msg;
    //正常返回时返回的数据
    private Object data;
    public Result(Integer status, String msg, Object data) {
        this.code = status;
        this.msg = msg;
        this.data = data;
    }
    //返回成功数据
    public static Result success(Object data) {
        return new Result(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), data);
    }
    public static Result success(Integer code,String msg) {
        return new Result(code, msg, null);
    }
    //返回出错数据
    public static Result error(ResponseCode code) {
        return new Result(code.getCode(), code.getMsg(), null);
    }

    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

}

