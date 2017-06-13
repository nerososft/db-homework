package org.nero.jxc.web;

import org.nero.jxc.dto.Operate;
import org.nero.jxc.entity.Food;
import org.nero.jxc.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/5/10
 * Time   下午1:51
 */
@Controller
@RequestMapping("/api/shop")
public class APIShop{

    @Autowired
    private IGoodsService goodsService;


    @RequestMapping(value = "/{type}/{id}/buy",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Boolean> getFoods(@PathVariable("type") String type,
                                     @PathVariable("id") Integer id) {

        if (type.equals("foods")) {
            return goodsService.buyFood(id);
        } else if (type.equals("clothes")) {
            return goodsService.buyClothes(id);
        }else{
            return new Operate<Boolean>(false,"未知的商品类型");
        }
    }
}