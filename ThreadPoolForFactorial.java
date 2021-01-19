package com.java.excercise.thread.factorial;

import java.math.BigDecimal;

public class ThreadPoolForFactorial {

    public static BigDecimal factMt(int input, int numThreads) throws InterruptedException {
        BigDecimal result = BigDecimal.valueOf(1);
        Thread[] thread = new Thread[numThreads]; // pool of thread

        CalculateFactorial[] worker = new CalculateFactorial[numThreads];
        for(int i=1; i<= numThreads;i++){
            int start = i==1 ? 1: (input / numThreads *(i-1)) +1;
            int end = i==numThreads? input: input/numThreads*i;
            worker[i-1] = new CalculateFactorial(start, end);
            thread[i-1] = new Thread(worker[i-1]);
        }

        for(int i= 0; i<  numThreads; i++){
            thread[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            thread[i].join();
        }
        for (int i = 0; i < numThreads; i++) {
            result = result.multiply(worker[i].result);
        }
        return result;
    }
}
