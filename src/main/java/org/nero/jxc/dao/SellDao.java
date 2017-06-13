package org.nero.jxc.dao;

import org.apache.ibatis.annotations.Param;
import org.nero.jxc.entity.Food;
import org.nero.jxc.entity.SellItem;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:01
 */
public interface SellDao {
    List<SellItem> getListByPage(@Param("page") Integer page, @Param("pagenum") Integer pagenum);

    Integer getSize();
}
