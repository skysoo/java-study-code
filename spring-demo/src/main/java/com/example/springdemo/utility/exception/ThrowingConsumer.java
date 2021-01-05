package com.example.springdemo.utility.exception;

public interface ThrowingConsumer<T, E extends Exception> {
    void accept(T t) throws E;
}

