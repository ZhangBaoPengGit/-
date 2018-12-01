package com.ZhangBaoPeng.controller;


import com.ZhangBaoPeng.domain.Orders;
import com.ZhangBaoPeng.service.IOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 张宝鹏
 * @date 2018/11/24 12:13
 */
@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping("findAllOrder")
    public String findAllOrder(Model model,
                               @RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "3") Integer pageSize){
        PageInfo<Orders> pageInfo = orderService.findAllOrder(pageNum,pageSize);

        model.addAttribute("pageInfo",pageInfo);
        return "order/orderList";
    }
}
