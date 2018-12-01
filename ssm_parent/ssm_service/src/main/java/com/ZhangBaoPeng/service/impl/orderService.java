package com.ZhangBaoPeng.service.impl;

import com.ZhangBaoPeng.dao.IOrderDao;
import com.ZhangBaoPeng.domain.Orders;
import com.ZhangBaoPeng.service.IOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张宝鹏
 * @date 2018/11/24 12:16
 */
@Service
@Transactional
public class orderService implements IOrderService {

    @Autowired
    private IOrderDao orderDao;
    @Override
    public PageInfo<Orders> findAllOrder(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Orders> list = orderDao.findAllOrder();
        PageInfo<Orders> pi = new PageInfo<>(list);
        return pi;
    }
}
