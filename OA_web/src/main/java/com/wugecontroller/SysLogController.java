package com.wugecontroller;

import com.wugeDomain.SysLog;
import com.wugeService.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("syslog-list");
        List<SysLog> all = sysLogService.findAll();
        modelAndView.addObject("sysLogs",all);

        return modelAndView;
    }
}
