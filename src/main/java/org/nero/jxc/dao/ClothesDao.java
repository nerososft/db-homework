package org.nero.jxc.dao;

import org.apache.ibatis.annotations.Param;
import org.nero.jxc.entity.Clothes;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:00
 */
public interface ClothesDao {

    List<Clothes> getListByPage(@Param("page") Integer page, @Param("pagenum") Integer pagenum);

    Integer getSize();


    Integer addClothes(@Param("id") Integer id,@Param("num") Integer num);

    Integer xiaJia(@Param("id") Integer id);

    List<Clothes> searchFoods(@Param("name") String name,
                              @Param("pingpai") Integer pingpai,
                              @Param("color") String color,
                              @Param("size") String size,
                              @Param("person") String person,
                              @Param("price_s") Float price_s,
                              @Param("price_b") Float price_b,
                              @Param("num_s") Float num_s,
                              @Param("num_b") Float num_b,
                              @Param("page") Long page,
                              @Param("num") Long num);

    Clothes getById(@Param("id") Integer id);

    Integer deleteById(@Param("id") Integer id);
}
