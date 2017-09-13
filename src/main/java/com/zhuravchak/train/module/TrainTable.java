package com.zhuravchak.train.module;

import com.zhuravchak.train.time.TimeConventor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Yaroslav on 24-Jul-17.
 */
public class TrainTable implements Serializable {

    ArrayList<Train> trains ;

    public TrainTable(ArrayList<Train> trains){
        this.trains = trains;
    }

    public void arrangeTrainsByID(){
        Collections.sort(trains, new Comparator<Train>(){
            @Override
            public int compare(Train t1, Train t2) {
                if (t1.getID() > t2.getID()) {
                    return  1;
                } else if (t1.getID() < t2.getID()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }

    public void arrangeTrainsByTime(){
        Collections.sort(trains,  new Comparator<Train>(){
            @Override
            public int compare(Train t1, Train t2) {
                if (TimeConventor.toMinute(t1.getTimeOfLeaving())> TimeConventor.toMinute(t2.getTimeOfLeaving())) {
                    return  1;
                } else if (TimeConventor.toMinute(t1.getTimeOfLeaving())< TimeConventor.toMinute(t2.getTimeOfLeaving())) {
                    return -1;
                }
                    return 0;
            }
        });
    }

    public ArrayList<Train> findTrainsWithGeneralSeats(){
        ArrayList<Train> trainsWithGeneralSeats = new ArrayList<>();
        for (Train train: trains) {
            if (train.getNumberOfGeneralSeats()>0) {
                trainsWithGeneralSeats.add(train);
            }
        }
        return trainsWithGeneralSeats;
    }

    public  ArrayList<Train> findTrainsByCityAndTime(String city, String time){
        ArrayList<Train> neededTrains = new ArrayList<>();

        for (Train train: trains) {
            int timeLine = TimeConventor.toMinute(time);

            if (city.equalsIgnoreCase(train.getFinalDestination()) &&
                                    (TimeConventor.toMinute(train.getTimeOfLeaving()) >= timeLine)) {
                neededTrains.add(train);
            }
        }
        return neededTrains;
    }

    public ArrayList<Train> getTrains() {
        return trains;
    }

    public void setTrains(ArrayList<Train> trains) {
        this.trains = trains;
    }
}

