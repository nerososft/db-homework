package org.nero.jxc.dao;

import org.apache.ibatis.annotations.Param;
import org.nero.jxc.entity.Food;
import org.nero.jxc.entity.InstockItem;

import java.sql.Date;
import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:01
 */
public interface InstockDao {
    List<InstockItem> getListByPage(@Param("page") Integer page, @Param("pagenum") Integer pagenum);

    Integer insertInstock(@Param("intime") String intime,@Param("gid")Integer gid,@Param("num")Integer num,@Param("price")Float price,@Param("allprice")Float allprice);

    Integer getInstockSize();
}
