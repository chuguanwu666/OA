package com.wugecontroller;

import com.wugeDao.ProductMapper;
import com.wugeDomain.Product;
import com.wugeService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Proxy;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
 @Autowired
    private ProductService productService;


    @RequestMapping("/findAll")
    public ModelAndView findAll(){


    ModelAndView modelAndView=new ModelAndView();
        List<Product> all = productService.findAll();
        System.out.println(all);
        modelAndView.addObject("list",all);
    modelAndView.setViewName("product-list");
 return modelAndView;
    }
    @RequestMapping("/save")
    public String save(Product product){
        productService.save(product);
        return "redirect:findAll";
    }
}
