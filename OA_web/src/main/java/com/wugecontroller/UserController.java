package com.wugecontroller;

import com.wugeDomain.Permission;
import com.wugeDomain.UserInfo;
import com.wugeService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-list");
        modelAndView.addObject("userList",userService.findAll());
        return modelAndView;

    }
    @RequestMapping("/save")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll";
    }
    @RequestMapping("/findById")
    public ModelAndView findById(int id){
        UserInfo byId = userService.findById(id);
        System.out.println(byId.getRoles());
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("user-show");
        modelAndView.addObject("user",byId);
        return modelAndView;
    }
    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(int id){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("roleList",userService.findByOtherRoles(id));
        modelAndView.addObject("user",userService.findById(id));
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(int userId,int []ids){
         userService.addRoleToUser(userId,ids);
         return "redirect:findAll";
    }

}
