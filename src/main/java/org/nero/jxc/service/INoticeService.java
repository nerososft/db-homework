package org.nero.jxc.service;

import org.nero.jxc.dto.Operate;
import org.nero.jxc.entity.InstockItem;
import org.nero.jxc.entity.Notice;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:07
 */
public interface INoticeService {
    Operate<Integer> addNotice(String token,Integer type,String content);
    Operate<List<Notice>> getNotice(Integer page, Integer num);

    Operate<Integer> getMaxPage(Integer num);
}
