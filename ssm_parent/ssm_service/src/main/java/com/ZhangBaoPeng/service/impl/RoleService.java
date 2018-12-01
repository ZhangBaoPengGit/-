package com.ZhangBaoPeng.service.impl;

import com.ZhangBaoPeng.dao.IRoleDao;
import com.ZhangBaoPeng.domain.Role;
import com.ZhangBaoPeng.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张宝鹏
 * @date 2018/11/29 14:15
 */
@Service
public class RoleService implements IRoleService {

    @Autowired
    private IRoleDao roleDao;
    @Override
    public List<Role> findAllRole() {
        return roleDao.findAllRole();
    }

    @Override
    public void insertRole(Role role) {
        roleDao.insertRole(role);
    }
}
