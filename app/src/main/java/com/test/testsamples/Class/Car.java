package com.amnpardaz.testsamples.Class;

public class Car {

    private String make;
    private double perstizh;

    public Car(String make,double perstizh) {
        this.make = make;
        this.perstizh= perstizh;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        if (make == null){
            return;
        }
        this.make = make;
    }

    public double getPerstizh() {
        return perstizh;
    }

    public void setPerstizh(double perstizh) {
        if (perstizh > 100 || perstizh <0){
            throw new ArithmeticException();
        }
        this.perstizh = perstizh;
    }

    public boolean isEmpty(){
        return perstizh == 0;
    }
}
