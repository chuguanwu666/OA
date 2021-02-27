package com.wugecontroller;

import com.wugeDomain.Permission;
import com.wugeService.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
   private PermissionService permissionService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("permission-list");
        modelAndView.addObject("permissionList",permissionService.findAll());
        return modelAndView;

    }
    @RequestMapping("/save")
    public String save(Permission permission) {
  permissionService.save(permission);
  return "redirect:findAll";
    }
}
