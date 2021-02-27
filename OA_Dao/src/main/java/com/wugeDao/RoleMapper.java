package com.wugeDao;

import com.wugeDomain.Permission;
import com.wugeDomain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleMapper {
    @Results(
            {
                    @Result(id = true,column ="id",property = "id"),
                    @Result(column ="roleName",property = "roleName"),
                    @Result(column ="roleDesc",property = "roleDesc") ,
                    @Result(column ="id",property = "permissions",javaType = List.class,many = @Many(select = "com.wugeDao.PermissionMapper.findByID"))

            }
    )
    @Select("select *from role where id in(select roleId from users_role where userId=#{id})")
    List<Role> findById(int id);
    @Select("select *from role where id=#{id}")
    Role findByIdRole(int id);
    @Select("select *from role")
    List<Role> findAll();
    @Insert("insert into role values (null,#{roleName},#{roleDesc})")
    void save(Role role);
    @Select("select *from permission where id not in(select permissionId from role_permission where roleId=#{id})")
    List<Permission> findOtherPermissions(int id);
    @Insert("insert into role_permission values (#{roleId},#{id})")
    void addPermission(@Param("roleId") int roleId, @Param("id") int id);
}
