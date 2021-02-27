package com.wugeDao;

import com.wugeDomain.Role;
import com.wugeDomain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Results(
            { @Result(property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",many = @Many(select = "com.wugeDao.RoleMapper.findById"))


            }
    )
     @Select("select *from users where username=#{name}")
    UserInfo loadUserByUsername(String username);
    @Select("select *from users")
    List<UserInfo> findAll();

    @Select("insert into users values (null,#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);
    @Results(
            { @Result(property = "id",column = "id"),
                    @Result(property = "email",column = "email"),
                    @Result(property = "username",column = "username"),
                    @Result(property = "password",column = "password"),
                    @Result(property = "phoneNum",column = "phoneNum"),
                    @Result(property = "status",column = "status"),
                    @Result(property = "roles",column = "id",javaType = List.class ,many = @Many(select = "com.wugeDao.RoleMapper.findById"))


            }
    )
    @Select("select *from users where id=#{id}")
    UserInfo findById(int id);
    @Select("select *from role where id not in(select roleId from users_role where userId=#{id})")
    List<Role> findByOtherRoles(int id);
    @Insert("insert into users_role values (#{userId},#{id})")
    void addRoleToUser(@Param("userId") int userId,@Param("id") int id);
}
