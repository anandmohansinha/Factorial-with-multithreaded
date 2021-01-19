package com.java.excercise.thread.factorial;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) throws InterruptedException {
       BigDecimal result =  ThreadPoolForFactorial.factMt(100, 4);
        System.out.println(result);
    }
}
