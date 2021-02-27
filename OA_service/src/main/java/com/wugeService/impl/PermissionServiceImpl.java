package com.wugeService.impl;

import com.wugeDao.PermissionMapper;
import com.wugeDomain.Permission;
import com.wugeService.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> findAll() {
        return permissionMapper.findAll();
    }

    @Override
    public void save(Permission permission) {
      permissionMapper.save(permission);
    }
}
