package org.nero.jxc.service.impl;

import org.nero.jxc.dao.NoticeDao;
import org.nero.jxc.dao.UserDao;
import org.nero.jxc.dto.Operate;
import org.nero.jxc.entity.InstockItem;
import org.nero.jxc.entity.Notice;
import org.nero.jxc.entity.User;
import org.nero.jxc.service.INoticeService;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.nero.jxc.CONSTANT.ADD_FAILED;
import static org.nero.jxc.CONSTANT.USER_AUTH_EXP;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:07
 */
@Service
public class NoticeServiceImpl implements INoticeService {

    @Autowired
    private NoticeDao noticeDao;
    @Autowired
    private UserDao userDao;

    public Operate<Integer> addNotice(String token,Integer type, String content){
        User userInfo=userDao.getUserByToken(token);
        if(userInfo!=null) {
            Integer addid = noticeDao.insertNotice(type,content);
            if(addid<1){
                return new Operate<Integer>(false,ADD_FAILED.DESC);
            }
            return new Operate<Integer>(true,addid);
        }
        return new Operate<Integer>(false,USER_AUTH_EXP.DESC);
    }



    public Operate<List<Notice>> getNotice(Integer page, Integer num){
        return new Operate<List<Notice>>(true,noticeDao.getListByPage(page,num));
    }

    public Operate<Integer> getMaxPage(Integer num) {
        return new Operate<Integer>(true, (int) Math.floor(noticeDao.getSize()/num));
    }
}
