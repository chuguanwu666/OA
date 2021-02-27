package com.wugeService;

import com.wugeDomain.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll();
    void save(Permission permission);

}
