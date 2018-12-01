package com.ZhangBaoPeng.dao;

import com.ZhangBaoPeng.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 张宝鹏
 * @date 2018/11/29 14:16
 */
public interface IRoleDao {

    @Select("select * from sys_role")
    public List<Role> findAllRole();

    @Insert("insert into sys_role values(com_sequence.nextval,#{roleName},#{roleDesc})")
    void insertRole(Role role);

    @Select("select * from sys_role where id in" +
            "(select roleid from sys_user_role where id=#{userId})")
    public List<Role> findUserRoleById(Integer userId);

}
