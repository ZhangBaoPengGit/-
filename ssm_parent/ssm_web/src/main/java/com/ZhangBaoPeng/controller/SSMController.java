package com.ZhangBaoPeng.controller;

import com.ZhangBaoPeng.domain.Product;
import com.ZhangBaoPeng.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ZhangBaoPeng.pageBeanUtil.pageBean;
import java.util.List;

/**
 * @author 张宝鹏
 * @date 2018/11/23 19:46
 */
@Controller
@RequestMapping("springmvc")
public class SSMController {

    @Autowired
    private IProductService productService;

    @RequestMapping("findAll")
    public String findAll(Model model,
                          @RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "3")Integer pageSize){
         pageBean<Product> pb = productService.findAll(pageNum,pageSize);
        model.addAttribute("pb",pb);
        return "product/productList";

    }

    @RequestMapping("productAddUI")
    public String productAddUI(){

        return "product/productAdd";
    }

    @RequestMapping("insertProduct")
    public String insertProduct(Product product){
        productService.InsertProduct(product);
        return "redirect:/springmvc/findAll";
    }

    @RequestMapping("updateProduct")
    public String updateProduct(Integer id,Model model){
        Product product = productService.findById(id);
        model.addAttribute(product);
        return "product/productUpdate";
    }

    @RequestMapping("update")
    public String update(Product product){
        productService.update(product);
        return "redirect:/springmvc/findAll";
    }

    @RequestMapping("deleteProduct")
    public String deleteProduct(Integer id){
        productService.delete(id);
        return "redirect:/springmvc/findAll";
    }
}
