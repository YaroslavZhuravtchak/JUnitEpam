package com.zhuravchak.train.module;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Yaroslav on 24-Jul-17.
 */
public class TrainGenerator {


    private static String[] finalDestinations = new String[] {"Харків", "Одеса", "Ужгород", "Чернівці", "Миколаїв",
                                                        "Івано-Франківськ", "Вінниця", "Чернігів", "Полтава", "Херсон"};
    private static String[] timesOfLeaving = new String[]{"12:30", "14:15", "23:00", "10:20",  "17:35", "18:45",
                                                        "20:00", "13:45", "00:25", "01:30", "02:10"};
    private static int[] numbersOfGeneralSeats = new int[]{0,12,20,0, 4, 0,9,34,0,15,4,24,0,0,0,0};
    private static int[] numbersOfReservedSeats = new int[]{0,12,30,27,22,4,24,0,6,0,0 };
    private static int[] numbersOfCoupeSeats = new int[]{0,12,5,20,2,4,18,0,25,0,0};
    private static int[] numbersOfSVSeats = new int[]{0,10,12,0,8,6,4,2,0,14,0,0};

    public static  ArrayList<Train> generateTrains(){

        Random random = new Random();
        ArrayList<Train> trains = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            trains.add( new Train( finalDestinations[random.nextInt(10)],
                                    timesOfLeaving[random.nextInt(11)],
                                    random.nextInt(99),
                                    numbersOfGeneralSeats[random.nextInt(10)],
                                    numbersOfReservedSeats[random.nextInt(10)],
                                    numbersOfCoupeSeats[random.nextInt(10)],
                                 numbersOfSVSeats[random.nextInt(10)]));
        }
        return trains;
    }
}
