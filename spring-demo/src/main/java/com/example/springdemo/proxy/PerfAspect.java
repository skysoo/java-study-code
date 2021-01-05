package com.example.springdemo.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class PerfAspect {

    @Around("execution(* com.example.springdemo.proxy.ProxyService.*(..))")
    public Object logPerf(ProceedingJoinPoint joint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object process = joint.proceed();
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        return process;
    }
}
