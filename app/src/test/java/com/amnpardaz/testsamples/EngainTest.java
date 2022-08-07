package com.amnpardaz.testsamples;

import com.amnpardaz.testsamples.Class.Calender;
import com.amnpardaz.testsamples.Class.Engain;
import com.amnpardaz.testsamples.Class.Math;
import com.amnpardaz.testsamples.Class.Object;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class EngainTest {

    @BeforeAll
    public static void test12(){
        System.out.println("BeforeAll initAll() method called");
    }

    @BeforeEach
    void makeObject(){
        System.out.println("BeforeEach initEach() method called");
    }

    @Test
    void getA() {
        Engain engain = new Engain(12,"s",75);
        assertEquals(12,engain.getA());
        assertEquals("s",engain.getB());

    }
    @Test
    public void testIsEmpty(){
        Engain engain =new Engain(10,"m",75);
        assertFalse(engain.isEmpty());
    }



    @Test
    public void throwExeption(){
        Engain engain =new Engain(10,"m",75);
        assertThrows(ArithmeticException.class,()->engain.setC(100),"hi");
    }
    @Test
    public void testIsNull(){
        Engain engain =new Engain(10,"m",75);
        assertNull(engain.getA());
    }

    @Test
    public void testSame(){
        Engain engain =new Engain(75,"m",74);
        assertNotSame(engain.getA(),engain.getC());
    }

    @Test
    public void testNotSame(){
        Object object =new Object(20,20);
        assertNotSame(object.getExpected(),object.getActual());
    }

    @Test
    @DisplayName("then is 1000")
    public void testFail(){
        Calender calender = new Calender();
        int sum = assertTimeout(Duration.ofMillis(100),() -> calender.add(120,120));
        assertEquals(240,sum);
    }

    @Test
    @DisplayName("there is problem")
    public void testAssertAll(){
        Math math =new Math();
        assertAll(
                ()->  assertEquals(6,math.plus(3,3)),
                ()->  assertEquals(9,math.multiplay(3,3)),
                ()->  assertEquals(9,math.devesiton(18,2))
        );
    }

    @Test
    @DisplayName("then is problemArray")
    public void testArray(){
        String[] expectedOutput = {"apple", "mango", "grape"};
        //assuem that the below array is returned from the method
        //to be tested.
        String[] methodOutput = {"apple", "mango", "grape"};
        assertArrayEquals(expectedOutput,methodOutput);
    }

    @Test
    @DisplayName("then is problemArray")
    public void testArray12(){
        List<String> actual = Arrays.asList("fee", "fi", "foe");
        List<String> expected = Arrays.asList("fee", "fi", "foe");
        assertThat(actual, is(expected));
    }

    @Test
    @DisplayName("then is problemArray")
    public void testArray13(){
        String m ="l";
        String y ="l";
        assertThat(m, is(y));
    }

    @Test
    @DisplayName("then is problemArray")
    public void testArray15(){
        List<String> actual = Arrays.asList("fee", "fi", "foe");
        List<String> expected = Arrays.asList("fee", "fi", "foe");
        assertLinesMatch(actual,expected);
    }

    @Test
    @DisplayName("then is 1000")
    public void testFaila(){
        Calender calender = new Calender();
        int sum = assertTimeoutPreemptively(Duration.ofMillis(1001),() -> calender.add(120,120));
        assertEquals(240,sum);
    }
}
