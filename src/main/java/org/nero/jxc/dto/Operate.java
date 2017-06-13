package org.nero.jxc.dto;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:10
 */
public class Operate<T> {

    private Boolean status;
    private String msg;
    private T data;

    public Operate(Boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Operate(Boolean status, T data) {
        this.status = status;
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Operate{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
