package com.wugecontroller;

import com.github.pagehelper.PageInfo;

import com.wugeDomain.Orders;
import com.wugeService.OrdersService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @RolesAllowed("USER")
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1") Integer page,@RequestParam( name = "pageSize",defaultValue = "4")  Integer pageSize){
        List<Orders> all = ordersService.findAll(page,pageSize);
        ModelAndView modelAndView=new ModelAndView();
        PageInfo pageInfo= new PageInfo(all);
        modelAndView.addObject("page",pageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }
    @RequestMapping("/findById")
    public ModelAndView findById(Integer id){
        Orders orders = ordersService.findById(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("orders-show");
        modelAndView.addObject("orders",orders);
        return modelAndView;
    }
}
