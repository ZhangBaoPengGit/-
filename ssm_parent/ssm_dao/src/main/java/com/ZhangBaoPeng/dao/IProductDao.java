package com.ZhangBaoPeng.dao;

import com.ZhangBaoPeng.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 张宝鹏
 * @date 2018/11/23 19:29
 */
public interface IProductDao {

    @Select(" select * from   (select rownum r ,p.* from product p where rownum <=${endIndex}) t where t.r > ${startIndex}")
    public List<Product> findAll(@Param("startIndex") Integer startIndex,
                                 @Param("endIndex") Integer endIndex);

    @Insert("insert into product values(com_sequence.nextval," +
            "#{productNum},#{productName},#{cityName}," +
            "#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void InsertProduct(Product product);

    @Select("select * from product where id=#{id}")
    Product findById(Integer id);

    @Update("update product set productName=#{productName},cityName=#{cityName}," +
            "departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc}," +
            "productStatus=#{productStatus} where id = #{id}")
    void update(Product product);

    @Delete("delete from product where id=#{id}")
    void delete(Integer id);

    @Select("select count(1) from product")
    Integer findTotalCount();

}
