package org.nero.jxc.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nero.jxc.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午11:38
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class GoodsServiceImplTest {


    @Autowired
    private IGoodsService goodsService;
    @Test
    public void getFoods() throws Exception {
        System.out.println(goodsService.getFoods(0,12));
    }

    @Test
    public void getClothes() throws Exception {

    }

    @Test
    public void searchFoods() throws Exception {
        System.out.println(goodsService.searchFoods("大果粒","all","2017-8-9","all",0.0f,100.0f,0.0f,100.0f,1L,12L));
    }



}