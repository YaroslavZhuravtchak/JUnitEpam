package com.zhuravchak.train.module;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Yaroslav on 25-Aug-17.
 */
public class TrainGeneratorTest {
    @Test
    public void generateTrains() throws Exception {
        ArrayList<Train> trains = TrainGenerator.generateTrains();
        assertNotNull(trains);

    }

}