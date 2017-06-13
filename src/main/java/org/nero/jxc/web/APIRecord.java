package org.nero.jxc.web;

import org.nero.jxc.dto.Operate;
import org.nero.jxc.entity.InstockItem;
import org.nero.jxc.entity.SellItem;
import org.nero.jxc.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/10
 * Time   上午9:20
 */
@Controller
@RequestMapping("/api/instock")
public class APIRecord {

    @Autowired
    private IRecordService recordService;
    //http://localhost:8085/jxc/api/instock/fs78f6sa78vad87vfa7fga9s8g/auth/2017-05-10/1/30/2222/add
    @RequestMapping(value = "/{token}/auth/{intime}/{gid}/{num}/{price}/add",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})

    @ResponseBody
    public Operate<Integer> Instock(@PathVariable("token") String token,
                                    @PathVariable("intime") String intime,
                                    @PathVariable("gid") Integer gid,
                                    @PathVariable("num") Integer num,
                                    @PathVariable("price") Float price){

        return recordService.instock(token,intime,gid,num,price);
    }

    @RequestMapping(value = "/{num}/page",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Integer> getMaxPage(@PathVariable("num") Integer num){
        return recordService.getInstockPage(num);
    }

    @RequestMapping(value = "/{page}/{num}/instock",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<InstockItem>> getInstock(@PathVariable("page") Integer page,
                                                 @PathVariable("num") Integer num){
        return recordService.getInstock(page,num);
    }
}
