package com.itheima.interceptor;


import com.itheima.domain.Log;
import com.itheima.domain.User;
import com.itheima.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


public class PrivilegeInterceptor implements HandlerInterceptor {

//    @Autowired
//    private LogMapper logMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user!=null){
//            String name = user.getName();
//            StringBuffer url = request.getRequestURL();
//             Date date = new Date();
//            Log log = new Log();
//            log.setName(name);
//            log.setTime(date);
//            log.setUrl(url.toString());
//            request.getSession().setAttribute("log",log);
            return true;
        }else {
            response.sendRedirect(request.getContextPath()+"/denied.jsp");
            return false;
        }
    }

//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        Date date = new Date();
//        Log log = (Log) request.getSession().getAttribute("log");
//        long l = date.getTime() - log.getTime().getTime();
//        log.setCost(l);
//        logMapper.save(log);
//    }
}
