package com.wugeService.impl;

import com.wugeDao.UserMapper;
import com.wugeDomain.Role;
import com.wugeDomain.UserInfo;
import com.wugeService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
   private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo = userMapper.loadUserByUsername(s);
        List<GrantedAuthority> list = getGrantedAuthority(userInfo.getRoles());

        User u=new User(userInfo.getUsername(),userInfo.getPassword(),list);

        return u;
    }
    public List<GrantedAuthority> getGrantedAuthority(List<Role> roles){
        List list=new ArrayList();
        for (Role role : roles) {
            SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority("ROLE_"+role.getRoleName().toUpperCase());
            list.add(simpleGrantedAuthority);

        }
        return list;

    }

    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userMapper.save(userInfo);

    }

    @Override
    public List<UserInfo> findAll() {
        return userMapper.findAll();
    }

    @Override
    public UserInfo findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public List<Role> findByOtherRoles(int id) {
        return userMapper.findByOtherRoles(id);
    }

    @Override
    public void addRoleToUser(int userId, int[] ids) {
        for (int id : ids) {
            userMapper.addRoleToUser(userId,id);
        }
    }
}
