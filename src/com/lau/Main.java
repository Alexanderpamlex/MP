package com.lau;

import java.util.Scanner;

class MyThread implements Runnable {

    private boolean isActive;

    void disable(){
        isActive=false;
    }

    MyThread(){
        isActive = true;
    }

    public void run(){

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter=1; // счетчик циклов
        while(isActive){
            System.out.println("Loop " + counter++);
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                System.out.println("Thread has been interrupted");
            }
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
public class Main {

    public static void main(String[] args) {
        System.out.println("Main thread started...");
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        int sec = in.nextInt();
        MyThread myThread = new MyThread();
        new Thread(myThread,"MyThread").start();

        try{
            Thread.sleep(sec*1000);
            myThread.disable();
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.println("Main thread finished...");
    }
}
