package com.amnpardaz.testsamples.Class;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.provider.Settings;

import androidx.lifecycle.MutableLiveData;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class RepositoryTest {

    @Mock
    Repository repository ;

    @Spy
    Repository repository1;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getData() {
       // mock(Repository.class);
        when(repository.getData()).thenReturn("this is mock string");
        System.out.println(repository.getData());
    }
    @Test
    public void getData1() {
        doReturn(repository1.getData()).when(repository1).getData();
        System.out.println(repository1.getData());
    }

    @Test
    public void getData2() {
        doNothing().when(repository).getValue("a","b");
    }

    @Test
    public void getLiveData2() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue("this is login test");
        when(repository.getMutableLiveData("mehdi","2323")).thenReturn(mutableLiveData);
        System.out.println(mutableLiveData.getValue());

    }
}