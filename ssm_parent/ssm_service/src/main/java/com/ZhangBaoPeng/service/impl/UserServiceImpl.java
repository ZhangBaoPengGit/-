package com.ZhangBaoPeng.service.impl;

import com.ZhangBaoPeng.dao.UserDao;
import com.ZhangBaoPeng.domain.SysUser;
import com.ZhangBaoPeng.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张宝鹏
 * @date 2018/11/28 17:30
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder pwdEncoder;
    /*
     *  自定义业务实现类实现框架的方法目的
     *  通过用户名得到User对象用于框架的验证
     * */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //通过username获取数据库的真实用户
        SysUser sysUser = userDao.findUserByName(username);
        //创建用于测试的初始化权限集合
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        //真实测试应该通过当前用户得到用户对应的角色集合测试
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        User user = new User(sysUser.getUsername(),sysUser.getPassword(),authorities);

        return user;
    }

    @Override
    public List<SysUser> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public void insertUser(SysUser sysUser) {
        sysUser.setPassword(pwdEncoder.encode(sysUser.getPassword()));
        userDao.insertUser(sysUser);
    }

    @Override
    public SysUser findUserById(Integer id) {
        return userDao.findUserById(id);
    }
}
