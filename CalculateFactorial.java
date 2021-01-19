package com.java.excercise.thread.factorial;

import java.math.BigDecimal;

public class CalculateFactorial implements Runnable{
    BigDecimal result;
    private final int from;
    private final int to;


    public CalculateFactorial(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        result = BigDecimal.valueOf(from);
        for(int i=from+1; i<=to; i++){
            result = result.multiply(BigDecimal.valueOf(i));
        }
    }

}
