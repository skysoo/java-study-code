package org.example;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LambdaException {
    @Test
    public void lambdaExceptionTest(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        list.forEach(a -> {
        });
    }
}
