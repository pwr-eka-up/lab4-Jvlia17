/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psae2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Julia Rzepka
 */
public class Multinumbers implements Serializable{ //3nd task
    private ArrayList<Numbers> multinumbers;
    
    public Multinumbers() {  //default constructor
        multinumbers = new ArrayList<Numbers>();
        int random_number = (int) (Math.random() * 10+1);
        for (int i = 0; i < random_number; i++) {
            Numbers number = new Numbers();
            multinumbers.add(number);
        }
    }
    
    public void print() {
        for (int i = 0; i < multinumbers.size(); i++) {
            multinumbers.get(i).print();
        }
    }
    
    public static void serialisation(Multinumbers multinumbers) 
    {
    
        File plik = new File("multinumbers.txt");
               
        try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(plik)))
        {
            oos.writeObject(multinumbers);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
   
    public static Multinumbers deserialisation() 
    {
    
        File plik = new File("multinumbers.txt");
               
        try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream(plik)))
        {
            Object ob1=ois.readObject();
            Multinumbers numbers1 = (Multinumbers) ob1;
            return numbers1;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
   
    public double countAverageOfAll() { //4th task
        double average = 0;
        int counter = 0;
        for (int i = 0; i < multinumbers.size(); i++) {
            for (int j = 0; j < multinumbers.get(i).number.size(); j++) {
                average+=multinumbers.get(i).number.get(j);
                counter++;
            }
        }
        return (average/counter);
    }
   
    public double minOfAll() { //4th task
        int min = multinumbers.get(0).number.get(0);
        for (int i = 0; i < multinumbers.size(); i++) {
            for (int j = 0; j < multinumbers.get(i).number.size(); j++) {
                if (multinumbers.get(i).number.get(j) < min)
                    min = multinumbers.get(i).number.get(j);
            }
        }
        return min;
    }

    public double maxOfAll() { //4th task
        int max = multinumbers.get(0).number.get(0);
        for (int i = 0; i < multinumbers.size(); i++) {
            for (int j = 0; j < multinumbers.get(i).number.size(); j++) {
                if (multinumbers.get(i).number.get(j) > max)
                    max = multinumbers.get(i).number.get(j);
            }
        }
        return max;
    }
   
}
