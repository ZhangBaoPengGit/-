package com.ZhangBaoPeng.dao;

import com.ZhangBaoPeng.domain.Orders;
import com.ZhangBaoPeng.domain.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 张宝鹏
 * @date 2018/11/24 12:24
 */
public interface IOrderDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "productId",property = "product",javaType = Product.class,
                    one = @One(select = "com.ZhangBaoPeng.dao.IProductDao.findById"))
    })
    List<Orders> findAllOrder();
}
