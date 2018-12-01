package com.ZhangBaoPeng.service;

import com.ZhangBaoPeng.domain.Orders;
import com.github.pagehelper.PageInfo;

/**
 * @author 张宝鹏
 * @date 2018/11/24 12:15
 */
public interface IOrderService {
    PageInfo<Orders> findAllOrder(Integer pageNum, Integer pageSize);
}
