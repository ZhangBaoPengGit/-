package com.ZhangBaoPeng.service;

import com.ZhangBaoPeng.domain.Product;
import com.ZhangBaoPeng.pageBeanUtil.pageBean;

/**
 * @author 张宝鹏
 * @date 2018/11/23 19:39
 */
public interface IProductService {

    public pageBean<Product> findAll(Integer pageNum, Integer pageSize);
    public void InsertProduct(Product product);

    Product findById(Integer id);

    void update(Product product);

    void delete(Integer id);
}
