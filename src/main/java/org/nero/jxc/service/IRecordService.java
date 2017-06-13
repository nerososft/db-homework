package org.nero.jxc.service;

import org.apache.ibatis.annotations.Param;
import org.nero.jxc.dto.Operate;
import org.nero.jxc.entity.InstockItem;

import java.sql.Date;
import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:09
 */
public interface IRecordService {
    Operate<Integer> instock(String token,String intime,Integer gid,Integer num,Float price);
    Operate<List<InstockItem>> getInstock(Integer page, Integer num);
    Operate<Integer> getInstockPage(Integer num);
}
