package org.nero.jxc.dao;

import org.apache.ibatis.annotations.Param;
import org.nero.jxc.entity.User;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午6:59
 */
public interface UserDao {
    /**
     *  登陆
     * @param username
     * @param password
     * @return
     */
    User getUserInfoByUserNameAndPassword(@Param("username") String username, @Param("password") String password);

    /**
     *  验证
     * @param Token
     * @return
     */
    User getUserByToken(@Param("token") String Token);
}
