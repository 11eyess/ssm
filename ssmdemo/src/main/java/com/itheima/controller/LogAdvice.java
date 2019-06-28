package com.itheima.controller;

import com.itheima.domain.Log;
import com.itheima.domain.User;
import com.itheima.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Aspect
public class LogAdvice {


    @Autowired
    private LogService logService;


    @Autowired
    HttpServletRequest request;


    @Around("execution(* com.itheima.controller.*.*(..))")
    public Object before(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Date date = new Date();
        User user = (User) request.getSession().getAttribute("user");
        String name = null;
        if (user!=null){
            name = user.getName();
        }else{
             name = request.getParameter("name");
             name +="[登陆失败]";
        }
        Log log = new Log();
        log.setName(name);
        log.setTime(date);
        String name1 = "[类名]"+proceedingJoinPoint.getTarget().getClass().getName();
        String name2 = "[方法名]"+proceedingJoinPoint.getSignature().getName();
        log.setUrl(name1+name2);
        Object proceed = proceedingJoinPoint.proceed();

        long cost = new Date().getTime() - date.getTime();
        log.setCost(cost);

        System.out.println(111);
        logService.save(log);

        return proceed;
    }

}
