package com.company.threads;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] tab1 = new int[5];
        int[] tab2 = new int[5];
        for(int i=0; i<tab1.length; i++){
            tab1[i] = i*2;
            tab2[i] = (i+1)*3;
        }
        TableauThread1 thread1 = new TableauThread1(tab1);
        TableauThread2 thread2 = new TableauThread2(tab2);
        thread1.join();
        thread2.join();
        thread1.start();
        thread2.start();
    }
}