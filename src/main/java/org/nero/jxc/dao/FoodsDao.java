package org.nero.jxc.dao;

import org.apache.ibatis.annotations.Param;
import org.nero.jxc.entity.Food;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:00
 */
public interface FoodsDao {
    /**
     * 分页获取
     * @param page
     * @param pagenum
     * @return
     */
    List<Food> getListByPage(@Param("page") Integer page, @Param("pagenum") Integer pagenum);

    String getPinpai(@Param("id") String id);

    Integer addFoods(@Param("id") Integer id,@Param("num") Integer num);

    Integer getPinpaiId(@Param("pingpai") String pingpai);

    Integer getSize();

    Integer xiaJia(@Param("id") Integer id);

    List<Food> searchFoods(@Param("name") String name,
                           @Param("pingpai") Integer pingpai,
                           @Param("date") String date,
                           @Param("chandi") String chandi,
                           @Param("price_s") Float price_s,
                           @Param("price_b") Float price_b,
                           @Param("num_s") Float num_s,
                           @Param("num_b") Float num_b,
                           @Param("page") Long page,
                           @Param("num") Long num);

    Food getById(@Param("id") Integer id);

    Integer deleteById(@Param("id") Integer id);
}

