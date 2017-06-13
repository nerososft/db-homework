package org.nero.jxc.service;

import org.nero.jxc.dto.Operate;
import org.nero.jxc.entity.*;
import org.nero.jxc.exceptions.UserAuthExpException;
import org.omg.CORBA.INTERNAL;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:06
 */
public interface IGoodsService {

    Operate<List<Food>> getFoods(Integer page, Integer num);

    Operate<List<Clothes>> getClothes(Integer page, Integer num);



    Operate<List<SellItem>> getSell(Integer page, Integer num);

    Operate<Integer> getMaxPage(String type, Integer num);

    Operate<Integer> getMaxSellPage(Integer num);

    Operate<Integer> goodsDown(String token, Integer id, String type) throws UserAuthExpException;

    Operate<List<Food>> searchFoods(String name, String pingpai, String date, String chandi, Float price_s, Float price_b, Float num_s, Float num_b,Long page,Long num);

    Operate<List<Clothes>> searchClothes(String name, String pingpai, String color, String size, String person, Float prices, Float priceb, Float nums, Float numb, Long page, Long num);

    Operate<Boolean> buyFood(Integer id);

    Operate<Boolean> buyClothes(Integer id);
}
