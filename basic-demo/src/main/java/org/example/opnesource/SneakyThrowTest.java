package org.example.opnesource;

import lombok.extern.slf4j.Slf4j;
import org.example.utility.UT;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SneakyThrowTest {
    public static void main(String[] args) throws IOException {
        System.out.println("[" + Thread.currentThread().getName() + "] pool start...");
//        UT.schedule.poolPerSec(new RunnableTask(), 1, 1);
        UT.schedule.poolPerSec(new IoExceptionRunnableTask(), 1, 1);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new RunnableTask());
        executorService.shutdown();

        System.out.println("[" + Thread.currentThread().getName() + "] pool end...");
    }
}

@Slf4j
class RunnableTask implements Runnable {

    //    @SneakyThrows
    @Override
    public void run() {
        throw new RuntimeException();
    }
}

@Slf4j
class IoExceptionRunnableTask implements Runnable  {
    @Override
    public void run() {
        // TODO: 2020-10-26 Thread 내 IOException 을 던지려면?
        /**
         * 1. IOException 을 RuntimeException 으로 감싸서 던지는 방법, 일종의 꼼수
         **/
        try {
            throw new IOException("IOException Test");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /**
         *
         **/
//        throw new IOException("IOException Test");

    }
}



