package com.company.threads;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] tab1 = new int[5];
        int[] tab2 = new int[5];
        for(int i=0; i<tab1.length; i++){
            tab1[i] = i*2;
            tab2[i] = (i+1)*3;
        }
        TableauThread thread1 = new TableauThread(tab1);
        TableauThread thread2 = new TableauThread(tab2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();


        System.out.println("Fin du programme");
    }
}
