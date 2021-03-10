package com.example.springdemo.config;

import com.example.springdemo.context.ApplicationContextProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@Component
public class UserInterceptor implements HandlerInterceptor {

    /**
     * Controller 요청을 전달하기 전처리 구간
     *
     * DELETE Method 수행시 특정 사용자에 대한 삭제는 차단하려는 로직
     **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        if (method.equals("DELETE")) {
            log.warn("USER DELETE 수행");
            if (request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1).equals("31")) {
                log.warn("User 31 cannot be deleted.");
                return false;
            }
        }
        return true;
    }

    /**
     * Controller 가 요청을 처리하고 난 후처리 구간 (클라이언트에게 요청 결과를 응답하기 전)
     *
     * User 정보에 변화(수정,삽입,삭제)가 있으면 적용된 캐쉬 값을 갱신하려는 로직
     **/
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();
        CacheManager cacheManager = (CacheManager) ctx.getBean("myCacheManager");
        String method = request.getMethod();

        if (!method.equals("GET")) {
            log.warn("USER {} 작업 수행!!!",method);
            try {
                Cache users = cacheManager.getCache("userList");
                users.clear();
                log.info("Refresh to userList of Cache!!");
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String method = request.getMethod();
        String requestURI = request.getRequestURI();
        log.info("Handler 처리 완료!!! {} ;; {}",method, requestURI);
    }
}
