package com.zhuravchak.train.time;

/**
 * Created by Yaroslav on 28-Jul-17.
 */
public class TimeConventor {

    public static int toMinute(String time){
        String[] hoursAndMinutes = time.split(":");

        if (hoursAndMinutes.length != 2) {
            throw new NumberFormatException();
        }
        int hours = Integer.valueOf(hoursAndMinutes[0]);
        int minutes = Integer.valueOf(hoursAndMinutes[1]);

        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
            throw new NumberFormatException();
        }
        return hours * 60 + minutes;
    }
}
