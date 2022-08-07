package com.amnpardaz.testsamples.Class;

public class Engain {

    private int a;
    private String b;
    private int c;

    public Engain(int a, String b, int perstizh) {
        this.a = a;
        this.b = b;
        this.c = perstizh;
    }

    public int getC() {
        return c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public boolean isEmpty(){
        return b == null;
    }

    public void setC(int c) {
        if (c == 100){
            throw new ArithmeticException();
        }
        this.c = c;
    }

}
