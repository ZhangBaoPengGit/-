package com.ZhangBaoPeng.controller;

import com.ZhangBaoPeng.domain.Role;
import com.ZhangBaoPeng.domain.SysUser;
import com.ZhangBaoPeng.service.IRoleService;
import com.ZhangBaoPeng.service.IUserService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 张宝鹏
 * @date 2018/11/29 10:55
 */
@Controller
@RequestMapping("user")
public class userController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @RequestMapping("findAllUser")
    public String findAllUser(Model model){

        List<SysUser> userList = userService.findAllUser();
        model.addAttribute("userList",userList);
        return "user/userList";
    }

    @RequestMapping("addUI")
    public String addUI(){
        return "user/userAdd";

    }

    @RequestMapping("insertUser")
    public String insertUser(SysUser sysUser){
        userService.insertUser(sysUser);
        return "redirect:/user/findAllUser";
    }

    @RequestMapping("managerUserRole")
    public String managerUserRole(Integer id,Model model){
        SysUser user =  userService.findUserById(id);
        List<Role> userRoles = user.getRoles();

        if(null!=userRoles&&userRoles.size()>0){
            StringBuilder sb = new StringBuilder();
            for (Role userRole : userRoles) {
                sb.append(userRole.getRoleName()+",");
            }
            model.addAttribute("roleStr",sb.toString());
        }
        List<Role> roles = roleService.findAllRole();
        model.addAttribute("user",user);

        model.addAttribute("roles",roles);
        return "user/managerUserRole";
    }

}
