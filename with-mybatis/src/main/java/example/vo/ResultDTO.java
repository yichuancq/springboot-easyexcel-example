package example.vo;

import java.io.Serializable;

/**
 * 返回结果结构
 *
 * @param <T>
 */
public class ResultDTO<T> implements Serializable {
    private Integer code = 0;
    private String msg = "";
    private Integer count = 0;
    private T data;

    public ResultDTO(int code, String msg, int count, T data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
