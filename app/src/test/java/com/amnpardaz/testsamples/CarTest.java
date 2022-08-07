package com.amnpardaz.testsamples;

import com.amnpardaz.testsamples.Class.Car;

import junit.framework.TestCase;

import org.junit.Test;

public class CarTest extends TestCase {

    @Test
    public void testGetMake() {
        Car car = new Car("yo!",5656868);
        assertEquals("yo!",5656868,car.getMake());
    }

    @Test
    public void testSetMake() {

    }
}
