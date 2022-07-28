package com.core.response;

import com.core.en.IamHttpEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 公共返回BEAN
 * @param <T>
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IamResponse<T> implements Serializable {

    private int code;   //状态码
    private String message; //错误信息
    private T data; //返回数据

    /**
     * 请求成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> IamResponse<T> success(T data){
        IamResponse<T> resp = new IamResponse<>();
        resp.setCode(IamHttpEnum.SUCCESS.getCode());
        resp.setMessage(IamHttpEnum.SUCCESS.getMessage());
        resp.setData(data);
        return resp;
    }

    /**
     * 请求失败
     * @param <T>
     * @return
     */
    public static <T> IamResponse<T> failed(){
        IamResponse<T> resp = new IamResponse<>();
        resp.setCode(IamHttpEnum.FAILED.getCode());
        resp.setMessage(IamHttpEnum.FAILED.getMessage());
        return resp;
    }

    /**
     * 请求失败，自定义错误编码及错误信息
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> IamResponse<T> failed(int code, String message){
        IamResponse<T> resp = new IamResponse<>();
        resp.setCode(code);
        resp.setMessage(message);
        return resp;
    }

    @Override
    public String toString() {
        return "IamResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
