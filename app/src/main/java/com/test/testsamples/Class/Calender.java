package com.amnpardaz.testsamples.Class;

public class Calender {

    public int add(int n1, int n2){

        if (n1< 100|| n2 < 100){
            throw new RuntimeException("number is lower 100");
        }
        if (n1 > 50000 || n2 > 50000){
            throw new RuntimeException("number is higher 50000");
        }

        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return n1+n2;
    }
}
