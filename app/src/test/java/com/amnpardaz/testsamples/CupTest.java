package com.amnpardaz.testsamples;

import com.amnpardaz.testsamples.Class.Cup;

import junit.framework.TestCase;

import org.junit.Test;

public class CupTest extends TestCase {

    public void testObject(){
        Cup cup = new Cup("water",75.0);
        assertEquals("wate",cup.getMake());
        assertEquals(75.0,cup.getPerstizh());
    }

    public void testIsEmpty(){
        Cup cup =new Cup("water",0);
        assertFalse(cup.isEmpty());
    }

    @Test
    public void testLiqNull(){
        Cup cup =new Cup("water",75.0);
        cup.setMake("");
        assertNotNull(cup.getMake());
    }
    @Test
    public void testExeption(){
        Cup cup =new Cup("water",75.0);

    }


}
