package com.ZhangBaoPeng.service;

import com.ZhangBaoPeng.domain.Role;

import java.util.List;

/**
 * @author 张宝鹏
 * @date 2018/11/29 14:14
 */
public interface IRoleService {
    List<Role> findAllRole();

    void insertRole(Role role);
}
