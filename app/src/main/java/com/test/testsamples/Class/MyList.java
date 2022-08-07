package com.amnpardaz.testsamples.Class;

import java.util.AbstractList;

public class MyList extends AbstractList<String> {

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    public String getData(){
        return "This is data ";
    }
}

