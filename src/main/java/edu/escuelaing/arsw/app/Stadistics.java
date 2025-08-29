package edu.escuelaing.arsw.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

/**
 * Hello world!
 *
 */
public class Stadistics 
{
    LinkedList<Integer> data = new LinkedList<>();

    public LinkedList<Integer> storeData(){
        String filePath = "src/data/data.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.addNode(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public double getMean (LinkedList<Integer> data){
        double sum = 0;
        int count = 0;
        while (data.getData() != null){
            sum += data.getData();
            count++;
            data.nextNode();
        }
        return sum / count;
    }

    public static double getStdDev(LinkedList<Integer> data, Function<LinkedList<Integer>, Double> meanFunction){
        double mean = meanFunction.apply(data);
        double sum = 0;
        int count = 0;
        while (data.getData() != null){
            sum += Math.pow(data.getData() - mean, 2);
            count++;
            data.nextNode();
        }
        return Math.sqrt(sum / count);
    }


   
    public static void main( String[] args ){
        Stadistics stadistics = new Stadistics();
        LinkedList<Integer> data = stadistics.storeData();
        System.out.println(data.getData());
        
        }
    }

