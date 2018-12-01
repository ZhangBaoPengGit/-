package com.ZhangBaoPeng.service;

import com.ZhangBaoPeng.domain.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author 张宝鹏
 * @date 2018/11/28 17:30
 */
public interface IUserService extends UserDetailsService {
    List<SysUser> findAllUser();

    void insertUser(SysUser sysUser);

    SysUser findUserById(Integer id);
}
