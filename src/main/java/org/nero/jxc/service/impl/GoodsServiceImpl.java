package org.nero.jxc.service.impl;

import org.nero.jxc.dao.*;
import org.nero.jxc.dto.Operate;
import org.nero.jxc.dto.UserInfo;
import org.nero.jxc.entity.*;
import org.nero.jxc.exceptions.UserAuthExpException;
import org.nero.jxc.service.IGoodsService;
import org.nero.jxc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.nero.jxc.CONSTANT.UNKNOW_TYPE;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:07
 */
@Service
public class GoodsServiceImpl implements IGoodsService {


    @Autowired
    private FoodsDao foodsDao;
    @Autowired
    private ClothesDao clothesDao;
    @Autowired
    private InstockDao instockDao;
    @Autowired
    private NoticeDao noticeDao;
    @Autowired
    private SellDao sellDao;

    @Autowired
    private IUserService userService;



    public Operate<List<Food>> getFoods(Integer page, Integer num) {

        List<Food> food = foodsDao.getListByPage(page,num);

        for(Food f:food){

            String pingpai = foodsDao.getPinpai(f.getPingpai());

            f.setPingpai(pingpai);
        }

        return new Operate<List<Food>>(true,food);
    }

    public Operate<List<Clothes>> getClothes(Integer page, Integer num) {
        List<Clothes> clothes = clothesDao.getListByPage(page,num);
        for(Clothes c:clothes){
            c.setPingpai(foodsDao.getPinpai(c.getPingpai()));
        }
        return new Operate<List<Clothes>>(true,clothes);
    }



    public Operate<List<SellItem>> getSell(Integer page, Integer num){
        return new Operate<List<SellItem>>(true,sellDao.getListByPage(page,num));
    }

    public Operate<Integer> getMaxPage(String type, Integer num) {
        if(type.equals("foods")) {
            return new Operate<Integer>(true, (int) Math.floor(foodsDao.getSize()/num));
        }else if(type.equals("clothes")){
            return new Operate<Integer>(true, (int) Math.floor(clothesDao.getSize()/num));
        }else{
            return new Operate<Integer>(true, (int) Math.floor(foodsDao.getSize()/num));
        }
    }

    public Operate<Integer> getMaxSellPage(Integer num) {
        return new Operate<Integer>(true, (int) Math.floor(sellDao.getSize()/num));
    }

    public Operate<Integer> goodsDown(String token, Integer id, String type) throws UserAuthExpException {
        Operate<UserInfo> userInfoOperate = userService.auth(token);

        if(type.equals("foods")){
            return new Operate<Integer>(true,foodsDao.xiaJia(id));
        }else if(type.equals("clothes")){
            return new Operate<Integer>(true,clothesDao.xiaJia(id));
        }
        return new Operate<Integer>(false,UNKNOW_TYPE.DESC);
    }

    public Operate<List<Food>> searchFoods(String name, String pingpai, String date, String chandi, Float price_s, Float price_b, Float num_s, Float num_b,Long page,Long num) {
        Integer pp;
        if(pingpai.equals("all")){
            pp = -1;
        }else{
            pp= foodsDao.getPinpaiId(pingpai);
        }

        List<Food> foods = foodsDao.searchFoods(name,pp,date,chandi,price_s,price_b,num_s,num_b,page,num);

        for(Food f:foods){

            String pingp = foodsDao.getPinpai(f.getPingpai());

            f.setPingpai(pingp);
        }

        return new Operate<List<Food>>(true,foods);
    }

    public Operate<List<Clothes>> searchClothes(String name, String pingpai, String color, String size, String person, Float prices, Float priceb, Float nums, Float numb, Long page, Long num) {
        Integer pp;
        if(pingpai.equals("all")){
            pp = -1;
        }else{
            pp= foodsDao.getPinpaiId(pingpai);
        }

        List<Clothes> clothes = clothesDao.searchFoods(name,pp,color,size,person,prices,priceb,nums,numb,page,num);

        for(Clothes f:clothes){

            String pingp = foodsDao.getPinpai(f.getPingpai());

            f.setPingpai(pingp);
        }

        return new Operate<List<Clothes>>(true,clothes);
    }

    public Operate<Boolean> buyFood(Integer id) {
        if(foodsDao.getById(id)!=null){
            if(foodsDao.getSize()<10){
                Integer addid = noticeDao.insertNotice(1,foodsDao.getById(id).getName()+"缺货");
            }
            if(foodsDao.deleteById(id)>0){

                return new Operate<Boolean>(true,"购买成功");
            }else{
                return new Operate<Boolean>(false,"购买失败");
            }
        }else{
            return new Operate<Boolean>(false,"未找到该商品");
        }
    }

    public Operate<Boolean> buyClothes(Integer id) {

        if(clothesDao.getById(id)!=null){
            if(clothesDao.getSize()<10){
                Integer addid = noticeDao.insertNotice(1,clothesDao.getById(id).getName()+"缺货");
            }
            if(clothesDao.deleteById(id)>0){
                return new Operate<Boolean>(true,"购买成功");
            }else{
                return new Operate<Boolean>(false,"购买失败");
            }
        }else{
            return new Operate<Boolean>(false,"未找到该商品");
        }
    }
}
