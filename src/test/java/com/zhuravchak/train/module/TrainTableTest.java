package com.zhuravchak.train.module;

import com.zhuravchak.train.module.*;
import com.zhuravchak.train.time.TimeConventor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Yaroslav on 13-Sep-17.
 */
public class TrainTableTest {
    private  TrainTable tt = null;
    private ArrayList<Train> trainList = TrainGenerator.generateTrains();
    @Before
    public void initTrainTableTest() {
        tt = new TrainTable(trainList);
    }
    @After
    public void clearTrainTableTest() {
        tt = null;
    }

    @Test
    public void arrangeTrainsByID() throws Exception {
         tt.arrangeTrainsByID();
         assertTrue(tt.trains.get(0).getID()<tt.trains.get(1).getID());

    }

    @Test
    public void arrangeTrainsByTime() throws Exception {
        tt.arrangeTrainsByTime();
        assertTrue(TimeConventor.toMinute(tt.trains.get(0).getTimeOfLeaving()) <
                           TimeConventor.toMinute(tt.trains.get(1).getTimeOfLeaving()));
    }

    @Test
    public void findTrainsWithGeneralSeats() throws Exception {

    }

    @Test
    public void findTrainsByCityAndTime() throws Exception {
        Train train = tt.trains.get(0);
        String city = train.getFinalDestination();
        String time = train.getTimeOfLeaving();

        List<Train> foundTrains = tt.findTrainsByCityAndTime(city, time);
        assertTrue(foundTrains.contains(train));
    }

    @Test
    public void getTrains() throws Exception {
         assertSame(trainList, tt.getTrains());
    }

    @Test
    public void setTrains() throws Exception {
        ArrayList<Train> newTrainList = TrainGenerator.generateTrains();
        tt.setTrains(newTrainList);
        assertSame(newTrainList, tt.getTrains());
    }

}