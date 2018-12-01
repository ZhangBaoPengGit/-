package com.ZhangBaoPeng.dao;

import com.ZhangBaoPeng.domain.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    @Select("select * from sys_user where username=#{username}")
    SysUser findUserByName(String username);

    @Select("select * from sys_user")
    List<SysUser> findAllUser();

    @Insert("insert into sys_user values(com_sequence.nextval,#{username},#{email}," +
            "#{password},#{phoneNum},#{status})")
    void insertUser(SysUser sysUser);

    @Select("select * from sys_user where id=#{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "Id",property = "roles",javaType = List.class,
                    many = @Many(select = "com.ZhangBaoPeng.dao.IRoleDao.findUserRoleById"))
    })

    SysUser findUserById(Integer id);
}
