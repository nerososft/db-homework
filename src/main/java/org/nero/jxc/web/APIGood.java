package org.nero.jxc.web;

import com.sun.org.apache.bcel.internal.generic.FLOAD;
import org.nero.jxc.dto.Operate;
import org.nero.jxc.entity.*;
import org.nero.jxc.exceptions.UserAuthExpException;
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
 * Date   2017/4/9
 * Time   下午11:14
 */
@Controller
@RequestMapping("/api/goods")
public class APIGood {

    @Autowired
    private IGoodsService goodsService;


    @RequestMapping(value = "/{page}/{num}/foods",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<Food>> getFoods(@PathVariable("page") Integer page,
                                        @PathVariable("num") Integer num){
        return goodsService.getFoods(page,num);
    }
    @RequestMapping(value = "/{page}/{num}/clothes",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<Clothes>> getClothes(@PathVariable("page") Integer page,
                                           @PathVariable("num") Integer num){
        return goodsService.getClothes(page,num);
    }

    @RequestMapping(value = "/{page}/{num}/sells",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<SellItem>> getSells(@PathVariable("page") Integer page,
                                            @PathVariable("num") Integer num){
        return goodsService.getSell(page,num);
    }
    @RequestMapping(value = "/{num}/{type}/page",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Integer> getMaxPage(@PathVariable("num") Integer num,@PathVariable("type") String type){
        return goodsService.getMaxPage(type,num);
    }

    @RequestMapping(value = "/{num}/page",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Integer> getMaxSellPage(@PathVariable("num") Integer num){
        return goodsService.getMaxSellPage(num);
    }

//    GET http://localhost:8080/jxc/api/goods/asd7f98ads76fsa98f7ga9er6gv80afxsbdq9avf0xsdg/auth/1/clothes/down
    @RequestMapping(value = "/{token}/auth/{id}/{type}/down",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Integer> xiajia(@PathVariable("token")String token,
                                   @PathVariable("id") Integer id,
                                   @PathVariable("type")String type){
        try {
            return goodsService.goodsDown(token,id,type);
        } catch (UserAuthExpException e) {
            return new Operate<Integer>(false,e.getMessage());
        }
    }

    //goods/search/" + data.name + "/" + data.pingpai + "/" + data.date + "/" + data.chandi + "/" + data.price + "/" + data.num + "/" + page + "/" + num + "/foods"
    @RequestMapping(value = "/search/{name}/{pingpai}/{date}/{chandi}/{price_s}/{price_b}/{num_s}/{num_b}/{page}/{num}/foods",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<Food>> searchFood(@PathVariable("name") String name,
                                          @PathVariable("pingpai") String pingpai,
                                          @PathVariable("date") String date,
                                          @PathVariable("chandi") String chandi,
                                          @PathVariable("price_s") String price_s,
                                          @PathVariable("price_b") String price_b,
                                          @PathVariable("num_s") String num_s,
                                          @PathVariable("num_b") String num_b,
                                          @PathVariable("page") Long page,
                                          @PathVariable("num") Long num){
        Float prices = -1.0F;
        Float priceb = -1.0F;
        Float nums = -1.0F;
        Float numb = -1.0F;

        if(!price_s.equals("all")){
            prices = Float.valueOf(price_s);
        }
        if(!price_b.equals("all")){
            prices = Float.valueOf(price_b);
        }
        if(!nums.equals("all")){
            prices = Float.valueOf(num_s);
        }
        if(!numb.equals("all")){
            prices = Float.valueOf(num_b);
        }
        return goodsService.searchFoods(name,pingpai,date,chandi,prices,priceb,nums,numb,page,num);
    }



    //search/all/%E9%98%BF%E7%8E%9B%E5%B0%BC/%E7%BA%A2%E8%89%B2/L/%E8%80%81%E5%B9%B4%E4%BA%BA/all/all/all/all/0/12/clothes
    @RequestMapping(value = "/search/{name}/{pingpai}/{color}/{size}/{person}/{price_s}/{price_b}/{num_s}/{num_b}/{page}/{num}/clothes",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<Clothes>> searchClothes(@PathVariable("name") String name,
                                                @PathVariable("pingpai") String pingpai,
                                                @PathVariable("color") String color,
                                                @PathVariable("size") String size,
                                                @PathVariable("person") String person,
                                                @PathVariable("price_s") String price_s,
                                                @PathVariable("price_b") String price_b,
                                                @PathVariable("num_s") String num_s,
                                                @PathVariable("num_b") String num_b,
                                                @PathVariable("page") Long page,
                                                @PathVariable("num") Long num){
        Float prices = -1.0F;
        Float priceb = -1.0F;
        Float nums = -1.0F;
        Float numb = -1.0F;

        if(!price_s.equals("all")){
            prices = Float.valueOf(price_s);
        }
        if(!price_b.equals("all")){
            prices = Float.valueOf(price_b);
        }
        if(!nums.equals("all")){
            prices = Float.valueOf(num_s);
        }
        if(!numb.equals("all")){
            prices = Float.valueOf(num_b);
        }
        return goodsService.searchClothes(name,pingpai,color,size,person,prices,priceb,nums,numb,page,num);
    }
}
