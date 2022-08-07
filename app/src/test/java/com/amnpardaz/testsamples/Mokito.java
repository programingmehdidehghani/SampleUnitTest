package com.amnpardaz.testsamples;

import com.amnpardaz.testsamples.Class.Engain;
import com.amnpardaz.testsamples.Class.MyList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Mokito {


     Engain engain;

    @Test
    void getA() {
        engain = new Engain(12,"a",75);
        assertEquals(12,engain.getA());
        assertEquals("a",engain.getB());
    }

    @Mock
    MyList mockedList = mock(MyList.class);

    @Test
    public void testList(){
        mockedList.size();
        verify(mockedList).size();
    }


    @Test
    public void testList1(){
        mockedList.size();
        verify(mockedList, times(1)).size();
    }

    @Test
    public void testList2(){
        mockedList.add("test");
        verify(mockedList).add(anyString());
    }

    @Test
    public void testList3(){
        when(mockedList.size()).thenReturn(mockedList.size());
    }




    @Test
    public void whenUsingTheSpyAnnotation_thenObjectIsSpied() {
        List<String> spyList = new ArrayList<>();
        List<String> spyList1 = spy(spyList);
        spyList1.add("one");
        spyList1.add("two");

        Mockito.verify(spyList1).add("one");
        Mockito.verify(spyList1).add("two");

        assertEquals(2, spyList1.size());
    }

    @Test
    public void whenSpyingOnList_thenCorrect() {
        List<String> list = new ArrayList<String>();
        List<String> spyList = spy(list);

        spyList.add("one");
        spyList.add("two");

        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");

        assertEquals(2, spyList.size());
    }

    @Test
    public void whenStubASpy_thenStubbed() {
        List<String> list = new ArrayList<String>();
        List<String> spyList = spy(list);

        assertEquals(0, spyList.size());

        Mockito.doReturn(100).when(spyList).size();
    }

    @Test
    public void differenceBetweenMockingSpyingAndStubbing() {
        List list = new ArrayList();
        list.add("abc");
        assertEquals(1, list.size());

        List mockedList = spy(list);
        when(mockedList.size()).thenReturn(10);
        assertEquals(10, mockedList.size());
    }

    @Test
    public void getData() {
        when(mockedList.getData()).thenReturn(mockedList.getData());
        //doReturn(mockito.getData()).when(mockito).getData();
    }


}
