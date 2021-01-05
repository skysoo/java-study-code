package org.example.utility.concurrency;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author skysoo
 * @version 1.0.0
 * @since 2020-06-25 오후 3:20
 *
 * Thread 내 Runtime Exception 발생시, 프로세스가 바로 죽게하지 않고 Exception 을 처리하려면 Thread 의
 * UncauchtExceptionHandler 를 구현해야 한다.
 **/
@Getter
@Slf4j
public class ThreadHandler implements Thread.UncaughtExceptionHandler {
    private String handleName;

    public ThreadHandler(String handleName) {
        this.handleName = handleName;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        log.error(handleName + "caught Exception in Thread - "
                + t.getName()
                + "=>" + e);
    }
}
