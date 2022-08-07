package com.amnpardaz.testsamples.Room;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class WordRoomDatabaseTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private WordDao userDao;
    private WordRoomDatabase db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();

        db = Room.inMemoryDatabaseBuilder(context, WordRoomDatabase.class)
                .allowMainThreadQueries()
                .build();
        userDao = db.wordDao();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {
        Word word = new Word("meh");
        userDao.insert(word);
        List<Word> allWords = LiveDataTestUtil.getValue(userDao.getAlphabetizedWords());
        assertEquals(allWords.get(0).getWord(), word.getWord());

    }
    @Test
    public void getAllWords() throws Exception {
        Word word = new Word("aaa");
        userDao.insert(word);
        Word word2 = new Word("bbb");
        userDao.insert(word2);
        List<Word> allWords = LiveDataTestUtil.getValue(userDao.getAlphabetizedWords());
        assertEquals(allWords.get(0).getWord(), word.getWord());
        assertEquals(allWords.get(1).getWord(), word2.getWord());
    }

    @Test
    public void deleteAll() throws Exception {
        Word word = new Word("word");
        userDao.insert(word);
        Word word2 = new Word("word2");
        userDao.insert(word2);
        userDao.deleteAll();
        List<Word> allWords = LiveDataTestUtil.getValue(userDao.getAlphabetizedWords());
        assertTrue(allWords.isEmpty());
    }

}