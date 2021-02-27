package com.wugecontroller;

import com.wugeDomain.Role;
import com.wugeService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/role")
public class RoleController  {
    @Autowired
    private RoleService roleService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("role-list");
        mv.addObject("roleList",roleService.findAll());
        return mv;
    }
@RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll";
    }
    @RequestMapping("/findUserByIdAndAllPermission")
    public ModelAndView findOtherPermissions(Integer id){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("permissionList",roleService.findOtherPermissions(id));
        Role byId = roleService.findById(id);
        modelAndView.addObject("role",byId);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }
    @RequestMapping("/addPermissionToRole")
    public String addPermissions(Integer roleId,int []ids){
        roleService.addPermissions(roleId,ids);
        return "redirect:findAll";
    }
}
