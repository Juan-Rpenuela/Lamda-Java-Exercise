package edu.escuelaing.arsw.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase para operaciones estadísticas sobre listas enlazadas.
 * Permite leer datos de archivos y calcular media y desviación estándar.
 */
public class Statistics 
{
    LinkedList<Double> data = new LinkedList<>();

    /**
     * Lee datos desde un archivo y los almacena en una lista enlazada.
     * @return Lista enlazada con los datos leídos.
     */
    public LinkedList<Double> storeData(String filePath){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.addNode(Double.parseDouble(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * Calcula la media de los datos en la lista.
     * @param data Lista de enteros.
     * @return Media aritmética.
     */
      public double getMean(LinkedList<Double> data) {
        double[] sum = {0};
        data.forEach(x ->  {
            sum[0] += x;
        });
        return  sum[0] / data.getSize();
    }

    /**
     * Calcula la desviación estándar de los datos en la lista.
     * @param data Lista de enteros.
     * @return Desviación estándar.
     */
    public double getStdDev(LinkedList<Double> data) {
        double mean = getMean(data);
        final double[] sum = {0};
        data.forEach(x ->  {
            sum[0] += Math.pow(x - mean, 2);
        });
        return Math.sqrt(sum[0] / (data.getSize()-1));
    }


   
    /**
     * Método principal. Lee los datos, calcula y muestra la media y desviación estándar.
     * @param args Argumentos de línea de comandos (no usados).
     */
    public static void main( String[] args ){
        Statistics stadistics = new Statistics();
        LinkedList<Double> data = stadistics.storeData("src/data/data.txt");
        System.out.println(data.getData());
        System.out.println("Mean: " + stadistics.getMean(data));
        System.out.println("Standard Deviation: " + stadistics.getStdDev(data));
    }
}


