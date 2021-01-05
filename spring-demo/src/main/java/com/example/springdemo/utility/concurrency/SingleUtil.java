package com.example.springdemo.utility.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/**
 * @author skysoo
 * @version 1.0.0
 * @since 2020-06-29 오후 12:43
 **/
public class SingleUtil {
    private static final SingleThreadFactory FACTORY = new SingleThreadFactory();
    private static final SingleUtil o = new SingleUtil();

    public static SingleUtil get() {
        return o;
    }

    public Future<?> singleThread(Runnable r){
        return this.single(r);
    }

    public Future<?> single(Runnable r){
        ExecutorService es = this._createPool();
        return es.submit(r);
    }

    private ExecutorService _createPool() {
        return Executors.newSingleThreadExecutor(FACTORY);
    }

    public static class SingleThreadFactory implements ThreadFactory {
        private final ThreadGroup group;

        SingleThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            this.group = s != null ? s.getThreadGroup() : new ThreadGroup("EPZ-SCH-GRP");
        }

        @Override
        public Thread newThread(Runnable runnable) {
            Thread.setDefaultUncaughtExceptionHandler(new ThreadHandler("Default-Handler"));
            Thread t = new Thread(this.group,runnable,"SinglePool-" + runnable.getClass().getSimpleName().toUpperCase(),0L);

            if (t.isDaemon()){
                t.setDaemon(false);
            }
//
//            if (t.getPriority()!=5){
//                t.setPriority(5);
//            }
            return t;
        }
    }
}
