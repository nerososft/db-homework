package org.nero.jxc.exceptions;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:04
 */
public class GoodsNotEnoughException extends  Exception {
    public GoodsNotEnoughException() {
    }

    public GoodsNotEnoughException(String message) {
        super(message);
    }

    public GoodsNotEnoughException(String message, Throwable cause) {
        super(message, cause);
    }

}
