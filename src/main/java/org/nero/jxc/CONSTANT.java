package org.nero.jxc;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2016/12/20
 * Time   下午3:30
 */
public enum CONSTANT {
    USER_NOT_FOUND("用户未找到"),
    USER_AUTH_EXP("登陆超时"),
    ADD_FAILED("添加失败"),
    NEW_FAILED("添加新商品失败"),
    UNKNOW_TYPE("类型未知");

    public String DESC;

    CONSTANT(String DESC){
        this.DESC = DESC;
    }
}
