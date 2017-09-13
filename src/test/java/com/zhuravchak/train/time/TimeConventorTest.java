package com.zhuravchak.train.time;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yaroslav on 25-Aug-17.
 */
public class TimeConventorTest {


    @Test
    public void toMinute() throws Exception {
        TimeConventor conventor = new TimeConventor();
        int expected = 630;
        int actual = TimeConventor.toMinute("10:30");
        assertEquals(expected, actual);
    }

}