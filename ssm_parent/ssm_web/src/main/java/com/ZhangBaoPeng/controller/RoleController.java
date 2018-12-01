package com.ZhangBaoPeng.controller;

import com.ZhangBaoPeng.domain.Role;
import com.ZhangBaoPeng.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 张宝鹏
 * @date 2018/11/29 14:10
 */
@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private IRoleService roleService;
    @RequestMapping("findAllRole")
    public String findAllRole(Model model){

        List<Role> roleList = roleService.findAllRole();
        model.addAttribute(roleList);
        return "role/roleList";
    }

    @RequestMapping("addRoleUI")
    public String addRoleUI(){
        return "role/roleAdd";
    }

    @RequestMapping("insertRole")
    public String insertRole(Role role){
        roleService.insertRole(role);
        return "redirect:/role/findAllRole";
    }
}
