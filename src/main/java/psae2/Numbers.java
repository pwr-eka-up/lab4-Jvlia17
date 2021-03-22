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
import java.util.Collections;
import java.util.ArrayList;

/**
 *
 * @author Julia Rzepka
 */
public class Numbers implements Serializable{
    
    ArrayList<Integer> number;
    
    public Numbers() {  //default constructor
        number = new ArrayList<Integer>();
        int random_number = (int) (Math.random() * 100+1);
        for (int i = 0; i < random_number; i++) {
            int random_value = (int) (Math.random() * 100+1);
            number.add(random_value);
        }
    }
    
    public Numbers(boolean bool) {
    
        File plik = new File("numbers.txt");
               
        try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream(plik)))
        {
            Object ob1=ois.readObject();
            Numbers numbers1 = (Numbers) ob1;
            this.number =new ArrayList<Integer> (numbers1.number);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            this.number=null;
        }
    }
    
    public void print() {
        for (int i = 0; i < number.size(); i++) {
            System.out.print(number.get(i)+", ");
        }
        System.out.println("\n");
    }
    
    public double countAverage() {
       double average=0;
       for (int i = 0; i < number.size(); i++) {
            average+=number.get(i);
        }
       return average/number.size();
   }
   
    public double min() {
       int minimum=number.get(0);;
       for (int i = 0; i < number.size(); i++) {
            if (number.get(i)<minimum)
                minimum = number.get(i);
        }
       return minimum;
   }
   
    public double max() {
       int maximum=number.get(0);;
       for (int i = 0; i < number.size(); i++) {
            if (number.get(i)>maximum)
                maximum = number.get(i);
        }
       return maximum;
   }
   
    public void sort() {
       Collections.sort(number);
   }

    public double mediana() {
       this.sort();
       double mediana;
       if (number.size()%2 ==0)
           mediana=((double)number.get(number.size()/2)+(double)number.get(number.size()/2 -1))/2;
           else
           mediana = (double) number.get(number.size()/2);
       return mediana;
   }
   
    public static void serialisation(Numbers numbers) //2nd task
    {
    
        File plik = new File("numbers.txt");
               
        try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(plik)))
        {
            oos.writeObject(numbers);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
