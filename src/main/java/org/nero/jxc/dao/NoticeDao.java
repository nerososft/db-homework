package org.nero.jxc.dao;

import org.apache.ibatis.annotations.Param;
import org.nero.jxc.entity.Food;
import org.nero.jxc.entity.Notice;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:01
 */
public interface NoticeDao {
    List<Notice> getListByPage(@Param("page") Integer page, @Param("pagenum") Integer pagenum);

    Integer insertNotice(@Param("type") Integer type,@Param("content") String content);

    Integer getSize();
}
