package com.wugeService.impl;

import com.wugeDao.RoleMapper;
import com.wugeDomain.Permission;
import com.wugeDomain.Role;
import com.wugeService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public void save(Role role) {
        roleMapper.save(role);
    }

    @Override
    public List<Permission> findOtherPermissions(int id) {
        return roleMapper.findOtherPermissions(id);
    }

    @Override
    public Role findById(int id) {
        return roleMapper.findByIdRole(id);
    }

    @Override
    public void addPermissions(int roleId, int[] ids) {
        for (int id : ids) {
            roleMapper.addPermission(roleId,id);
        }
    }
}
