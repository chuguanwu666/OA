package com.wugecontroller;

import com.wugeDomain.SysLog;
import com.wugeService.SysLogService;
import com.wugeDomain.SysLogContextUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class Aop {
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private SysLogService sysLogService;
    @Pointcut("execution(* com.wugecontroller.*.*(..))")
    public void getPoint(){};
    @Before("getPoint()")
    public void before(JoinPoint jp) throws InterruptedException, NoSuchMethodException {
//       获取执行时间
        Date visitTime=new Date();
// 将执行时间放入Sys对象中
        SysLog sysLog=new SysLog();
        sysLog.setVisitTime(visitTime);
        Class aClass = jp.getTarget().getClass();
        String methodeName = jp.getSignature().getName();
//        获取方法参数
        Object[] args = jp.getArgs();
//获取执行方法;
        Class [] clazzs=new Class[args.length];
        Method method;
        if (args!=null){

            for (int i = 0; i < args.length; i++) {
                clazzs[i]=args[i].getClass();
            }
            method = aClass.getMethod(methodeName, clazzs);
        }else{
            method = aClass.getMethod(methodeName);
        }
        RequestMapping annotation = (RequestMapping) aClass.getAnnotation(RequestMapping.class);
        RequestMapping annotation1 = method.getAnnotation(RequestMapping.class);



        String url=annotation.value()[0]+annotation1.value()[0];
        sysLog.setUrl(url);
        sysLog.setIp(httpServletRequest.getRemoteAddr());
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        sysLog.setUsername(authentication.getName());
        sysLog.setMethod("[类名]" + aClass.getName() + "[方法名]" +
                method.getName());
        /*将类保存至本地线程*/
        SysLogContextUtils.setSysLog(sysLog);


    }
    @After("getPoint()")
    public void after(){
        SysLog sysLog = SysLogContextUtils.getSysLog();
       Long executeTime= new Date().getTime()-sysLog.getVisitTime().getTime();
       sysLog.setExecutionTime(executeTime);
        System.out.println(httpServletRequest.getRequestURI());
        sysLogService.save(sysLog);
    }
}
