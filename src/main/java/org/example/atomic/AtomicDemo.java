package org.example.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    public static void main(String[] args) {
        AtomicInteger num = new AtomicInteger(1);
        boolean flag=num.compareAndSet(1,2);
        System.out.println(num+" "+flag);
        int a = 16;
        System.out.println(16>>>1);
    }
}
