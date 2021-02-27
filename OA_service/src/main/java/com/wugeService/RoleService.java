package com.wugeService;

import com.wugeDomain.Permission;
import com.wugeDomain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    void save(Role role);
    List<Permission> findOtherPermissions(int id);
    Role findById(int id);
    void addPermissions(int roleId,int []ids);
}
