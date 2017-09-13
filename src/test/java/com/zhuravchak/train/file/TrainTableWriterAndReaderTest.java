package com.zhuravchak.train.file;

import com.zhuravchak.train.module.Train;
import com.zhuravchak.train.module.TrainGenerator;
import com.zhuravchak.train.module.TrainTable;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;


import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Yaroslav on 13-Sep-17.
 */
public class TrainTableWriterAndReaderTest {


    @Test
    public void readTrainTable() throws Exception {
        List<Train> list = TrainTableWriterAndReader.readTrainTable(new File("table.txt"));
        assertTrue(list.size()>0);
    }

    @Test
    public void writeTrainTable() throws Exception {
        TrainTable table = new TrainTable(new TrainGenerator().generateTrains());
        int i = TrainTableWriterAndReader.writeTrainTable(new File("table.txt"), table);
        assertEquals(i, 0);
    }

}