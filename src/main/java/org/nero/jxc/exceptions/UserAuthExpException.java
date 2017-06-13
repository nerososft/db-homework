package org.nero.jxc.exceptions;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:05
 */
public class UserAuthExpException extends Exception {
    public UserAuthExpException() {
    }

    public UserAuthExpException(String message) {
        super(message);
    }

    public UserAuthExpException(String message, Throwable cause) {
        super(message, cause);
    }
}
