package org.nero.jxc.service.impl;

import org.nero.jxc.dao.UserDao;
import org.nero.jxc.dto.Operate;
import org.nero.jxc.dto.UserInfo;
import org.nero.jxc.entity.User;
import org.nero.jxc.exceptions.UserAuthExpException;
import org.nero.jxc.exceptions.UserNotFoundException;
import org.nero.jxc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.nero.jxc.CONSTANT.USER_AUTH_EXP;
import static org.nero.jxc.CONSTANT.USER_NOT_FOUND;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:08
 */
@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserDao userDao;


    public Operate<UserInfo> login(String username, String password) throws UserNotFoundException {

        User user = userDao.getUserInfoByUserNameAndPassword(username,password);

        if(user!=null){
            return new Operate<UserInfo>(true,new UserInfo(user.getId(),user.getUsername(),user.getToken(),user.getCtime(),user.getLevel()));
        }

        throw new UserNotFoundException(USER_NOT_FOUND.DESC);
    }

    public Operate<UserInfo> auth(String token)throws UserAuthExpException {
        User user = userDao.getUserByToken(token);
        if(user!=null){
            return new Operate<UserInfo>(true,new UserInfo(user.getId(),user.getUsername(),user.getToken(),user.getCtime(),user.getLevel()));
        }
        throw new UserAuthExpException(USER_AUTH_EXP.DESC);
    }
}
