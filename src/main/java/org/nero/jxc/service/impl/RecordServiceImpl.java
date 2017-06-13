package org.nero.jxc.service.impl;

import org.nero.jxc.dao.ClothesDao;
import org.nero.jxc.dao.FoodsDao;
import org.nero.jxc.dao.InstockDao;
import org.nero.jxc.dao.UserDao;
import org.nero.jxc.dto.Operate;
import org.nero.jxc.dto.UserInfo;
import org.nero.jxc.entity.Clothes;
import org.nero.jxc.entity.InstockItem;
import org.nero.jxc.entity.User;
import org.nero.jxc.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

import static org.nero.jxc.CONSTANT.ADD_FAILED;
import static org.nero.jxc.CONSTANT.NEW_FAILED;
import static org.nero.jxc.CONSTANT.USER_AUTH_EXP;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:10
 */
@Service
public class RecordServiceImpl implements IRecordService {

    @Autowired
    private InstockDao instockDao;

    @Autowired
    private UserDao userDao;
    @Autowired
    private FoodsDao foodsDao;
    @Autowired
    private ClothesDao clothesDao;

    @Transactional
    public Operate<Integer> instock(String token,String intime, Integer gid, Integer num, Float price){
        User userInfo=userDao.getUserByToken(token);
        if(userInfo!=null) {
            Integer addFoods = foodsDao.addFoods(gid,num);
            Integer addClothes = clothesDao.addClothes(gid,num);
            if (addFoods < 1 && addClothes < 1) {
                return new Operate<Integer>(false, NEW_FAILED.DESC);
            }
            Integer addid = instockDao.insertInstock(intime, gid, num, price,num*price);
            if (addid < 1) {
                return new Operate<Integer>(false, ADD_FAILED.DESC);
            }
            return new Operate<Integer>(true, addid);
        }
        return new Operate<Integer>(false,USER_AUTH_EXP.DESC);
    }

    public Operate<List<InstockItem>> getInstock(Integer page, Integer num){
        return new Operate<List<InstockItem>>(true,instockDao.getListByPage(page,num));
    }

    public Operate<Integer> getInstockPage(Integer num) {
        return new Operate<Integer>(true, (int) Math.floor(instockDao.getInstockSize()/num));
    }
}
