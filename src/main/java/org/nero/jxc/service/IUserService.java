package org.nero.jxc.service;

import org.nero.jxc.dto.Operate;
import org.nero.jxc.dto.UserInfo;
import org.nero.jxc.entity.User;
import org.nero.jxc.exceptions.UserAuthExpException;
import org.nero.jxc.exceptions.UserNotFoundException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:08
 */
public interface IUserService {


    /**
     * 登陆
     * @param username
     * @param token
     * @return
     */
    Operate<UserInfo> login(String username, String token) throws UserNotFoundException;

    /**
     * 认证
     * @param token
     * @return
     */
    Operate<UserInfo> auth(String token)throws UserAuthExpException;

}
