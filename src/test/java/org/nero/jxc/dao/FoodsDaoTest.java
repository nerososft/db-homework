package org.nero.jxc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午11:02
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class FoodsDaoTest {

    @Autowired
    private FoodsDao foodsDao;
    @Test
    public void getListByPage() throws Exception {
        System.out.println(foodsDao.getListByPage(0,12));
    }
    @Test
    public void getPinpai() throws Exception {
        System.out.println(foodsDao.getPinpai("2"));
    }
    @Test
    public void getPingpaiId(){
        System.out.println(foodsDao.getPinpaiId("哇哈哈")                                                      );
    }
}