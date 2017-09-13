package com.zhuravchak.train.main;

import com.zhuravchak.train.menu.Menu;
import com.zhuravchak.train.module.Train;
import com.zhuravchak.train.module.TrainGenerator;
import com.zhuravchak.train.module.TrainTable;

import java.util.ArrayList;

/**
 * Created by Yaroslav on 24-Jul-17.
 */
public class Main {

    public static void main(String[] args) {
        TrainGenerator generator = new TrainGenerator();
        ArrayList<Train> trains = generator.generateTrains();
        TrainTable table = new TrainTable(trains);
        Menu menu = new Menu(table);
        menu.runMenu();
    }
}
