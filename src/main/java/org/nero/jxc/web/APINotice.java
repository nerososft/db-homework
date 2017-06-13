package org.nero.jxc.web;

import org.nero.jxc.dto.Operate;
import org.nero.jxc.entity.InstockItem;
import org.nero.jxc.entity.Notice;
import org.nero.jxc.entity.SellItem;
import org.nero.jxc.service.INoticeService;
import org.nero.jxc.service.IRecordService;
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
 * Date   2017/4/10
 * Time   上午9:20
 */
@Controller
@RequestMapping("/api/notice")
public class APINotice {


    @Autowired
    private INoticeService noticeService;


    @RequestMapping(value = "{token}/auth/{type}/{content}/add",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Integer> newNotice(@PathVariable("token")String token,
                                      @PathVariable("type") Integer type,
                                      @PathVariable("content") String content){
        return noticeService.addNotice(token,type,content);
    }


    @RequestMapping(value = "/{page}/{num}/notice",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<Notice>> getNotices(@PathVariable("page") Integer page,
                                            @PathVariable("num") Integer num){
        return noticeService.getNotice(page,num);
    }
    @RequestMapping(value = "/{num}/notice",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Integer> getMaxPage(@PathVariable("num") Integer num){
        return noticeService.getMaxPage(num);
    }
}

