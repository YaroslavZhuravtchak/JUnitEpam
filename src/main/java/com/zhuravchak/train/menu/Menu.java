package com.zhuravchak.train.menu;

import com.zhuravchak.train.file.TrainTableWriterAndReader;
import com.zhuravchak.train.module.Train;
import com.zhuravchak.train.module.TrainTable;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Yaroslav on 26-Jul-17.
 */
public class Menu {
    TrainTable table;
    public Menu(TrainTable table) {
        this.table = table;
    }

    public static void showMenu(){
        System.out.println("________________________________________________________\n"+
                "Введіть:\n" +
                " I  для виводу всіх поїздів відсортованих за ID\n" +
                " T  для виводу всіх поїздів відсортованих за часом\n" +
                " G  для виводу поїздів в яких є вільні загальні місця\n" +
                " F  для пошуку поїзда по місту і часу відправлення\n" +
                " S  для запису розкладу в файл\n" +
                " R  для читання розкладу з файлу\n" +
                " E  для виходу\n"+
                "________________________________________________________\n");
    }

    public  String getSrtingFromConsole(){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        return str;
    }

    public  void runMenu(){
        while (true) {
            showMenu();
            String ch = getSrtingFromConsole();
            if (ch.equalsIgnoreCase( "I")) {
                table.arrangeTrainsByID();
                System.out.println(table.getTrains());
            }else if (ch.equalsIgnoreCase("T")) {
                table.arrangeTrainsByTime();
                System.out.println(table.getTrains());
            } else if (ch.equalsIgnoreCase("G")) {
                System.out.println(table.findTrainsWithGeneralSeats());
            } else if (ch.equalsIgnoreCase("F")) {
                try {
                    System.out.println("Введіть місто:");
                    String sity = getSrtingFromConsole();

                    System.out.println("Введіть час відправлення в форматі гг:xx :");
                    String time = getSrtingFromConsole();

                    ArrayList<Train> trains = table.findTrainsByCityAndTime(sity, time);

                    if(trains.size()==0){
                        System.out.println("\nПоїздів не знайдено");
                    } else {
                        System.out.println("\n" + trains);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Невірний формат часу");
                }
            } else if (ch.equalsIgnoreCase("S")) {

                System.out.println("Введіть шлях до файлу:");

                File file = new File(getSrtingFromConsole());
               if(TrainTableWriterAndReader.writeTrainTable(file, table)==0){
                   System.out.println("Розклад успішно записаний");
               }

            } else if (ch.equalsIgnoreCase("R")) {
                ArrayList<Train> trains;
                System.out.println("Введіть шлях до файлу:");

                    File file = new File(getSrtingFromConsole());
                    trains = TrainTableWriterAndReader.readTrainTable(file);

                    if( trains != null){
                       table.setTrains(trains);
                        System.out.println("Розклад успішно прочитаний");
                    }

            } else if (ch.equalsIgnoreCase("E")) {
                break;
            }
        }
    }

}
