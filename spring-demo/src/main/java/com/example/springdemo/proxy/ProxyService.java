package com.example.springdemo.proxy;

import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.List;

@Service
public class ProxyService {
    private List<Integer> integerList = Arrays.asList(1,2,3,4,5);

    public void testA() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        int sum = 0;
        for (Integer i : integerList) {
            sum += i;
        }
        System.out.println(sum);

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public void testB(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        int mul = 0;
        for (Integer i : integerList) {
            mul *= i;
        }
        System.out.println(mul);

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }


    @PerfLogging
    public void proxyTestA() {
        int sum = 0;
        for (Integer i : integerList) {
            sum += i;
        }
        System.out.println(sum);
    }

    @PerfLogging
    public void proxyTestB(){
        int mul = 0;
        for (Integer i : integerList) {
            mul *= i;
        }
        System.out.println(mul);
    }
}
