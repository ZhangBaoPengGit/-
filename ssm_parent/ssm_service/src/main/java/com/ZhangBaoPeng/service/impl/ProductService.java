package com.ZhangBaoPeng.service.impl;

import com.ZhangBaoPeng.dao.IProductDao;
import com.ZhangBaoPeng.domain.Product;
import com.ZhangBaoPeng.pageBeanUtil.pageBean;
import com.ZhangBaoPeng.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张宝鹏
 * @date 2018/11/23 19:40
 */
@Service
@Transactional
public class ProductService implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public pageBean<Product> findAll(Integer pageNum, Integer pageSize) {
        pageBean<Product> pb = new pageBean<Product>();
        pb.setPageNum(pageNum);
        pb.setPageSize(pageSize);
        Integer totalCount = productDao.findTotalCount();
        pb.setTotalCount(totalCount);
        Integer totalPage = totalCount/pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        pb.setTotalPage(totalPage);
        Integer startIndex = (pageNum-1)*pageSize;
        Integer endIndex = pageNum*pageSize;
        List<Product> list = productDao.findAll(startIndex,endIndex);
        pb.setList(list);
        return pb;
    }

    @Override
    public void InsertProduct(Product product) {
        productDao.InsertProduct(product);
    }

    @Override
    public Product findById(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void delete(Integer id) {
        productDao.delete(id);
    }
}
