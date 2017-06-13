package org.nero.jxc.web;

import org.nero.jxc.dto.Operate;
import org.nero.jxc.dto.UserInfo;
import org.nero.jxc.exceptions.UserAuthExpException;
import org.nero.jxc.exceptions.UserNotFoundException;
import org.nero.jxc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.nero.jxc.CONSTANT.USER_AUTH_EXP;
import static org.nero.jxc.CONSTANT.USER_NOT_FOUND;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:59
 */
@Controller
@RequestMapping("/api/user")
public class APIUser {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/{username}/{password}/login",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<UserInfo> Login(@PathVariable("username") String username,@PathVariable("password") String password){
        Operate<UserInfo> result;
        try{
            result=userService.login(username,password);
            return result;
        }catch(UserNotFoundException e){
            result=new Operate<UserInfo>(false,USER_NOT_FOUND.DESC);
            return result;
        }
    }

    @RequestMapping(value = "/{token}/auth",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<UserInfo> auth(@PathVariable("token") String token){
        Operate<UserInfo> result;
        try{
            result=userService.auth(token);
            return result;
        }catch(UserAuthExpException e){
            result=new Operate<UserInfo>(false,USER_AUTH_EXP.DESC);
            return result;
        }
    }

}
