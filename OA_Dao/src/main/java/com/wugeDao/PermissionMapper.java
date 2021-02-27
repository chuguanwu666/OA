package com.wugeDao;

import com.wugeDomain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {
    @Select("select *from permission where id in(select permissionId from role_permission where roleId=#{id})")
    List<Permission> findByID(int id);
    @Select("select *from permission")
    List<Permission> findAll();
    @Insert("insert into permission values(null,#{permissionName},#{url})")
    void save(Permission permission);
}
