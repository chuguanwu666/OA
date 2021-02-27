package com.wugeService;

import com.wugeDomain.Role;
import com.wugeDomain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserInfo> findAll();
    void save(UserInfo userInfo);
    UserInfo findById(int id);
    List<Role> findByOtherRoles(int id);
    void addRoleToUser(int userId,int []ids);
}
