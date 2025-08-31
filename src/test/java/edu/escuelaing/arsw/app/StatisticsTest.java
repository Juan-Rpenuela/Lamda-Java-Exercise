package edu.escuelaing.arsw.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
    @Test
    public void testData1() {
        Statistics stadistics = new Statistics();
        LinkedList<Double> data = stadistics.storeData("src/data/data.txt");
        double mean = stadistics.getMean(data);
        double std = stadistics.getStdDev(data);
        assertEquals(550.6, mean, 0.01);
        assertEquals(572.03, std, 0.01);
    }

    @Test
    public void testData2() {
        Statistics stadistics = new Statistics();
        LinkedList<Double> data = stadistics.storeData("src/data/data2.txt");
        double mean = stadistics.getMean(data);
        double std = stadistics.getStdDev(data);
        assertEquals(60.32, mean, 0.01);
        assertEquals(62.26, std, 0.01);
    }
}
