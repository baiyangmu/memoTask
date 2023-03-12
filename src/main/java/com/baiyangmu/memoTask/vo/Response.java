package com.baiyangmu.memotask.vo;


import lombok.Data;

/**
 * @author fanyingxu
 */
@Data
public class Response<T> {

    private Integer resCode;
    private String resMsg;
    private String bizId;
    private T data;

    public Response() {
        resCode = 200000;
        resMsg = "success";
    }

    public Response(T data) {
        resCode = 200000;
        resMsg = "success";
        this.data = data;
    }
    public Response(T data, String bizId) {
        resCode = 200000;
        resMsg = "success";
        this.bizId = bizId;
        this.data = data;
    }

    public Response(T data, String bizId, Integer resCode, String resMsg) {
        this.resCode = resCode;
        this.resMsg = resMsg;
        this.bizId = bizId;
        this.data = data;
    }

    public static<T> Response<T> build(T data) {
        return new Response<>(data);
    }

    public static<T> Response<T> build(T data, String bizId) {
        return new Response<>(data,bizId);
    }

    public static<T> Response<T> build(T data, String bizId, Integer resCode, String resMsg) {
        return new Response<>(data, bizId, resCode, resMsg);
    }

    public static <T> Response<T> build(T data, Integer resCode, String resMsg) {
        return new Response<T>(data, null, resCode , resMsg);
    }


    public static <T> Response<T> buildFailed(Integer resCode, String resMsg) {
        return new Response<T>(null , null, resCode , resMsg);
    }




}
