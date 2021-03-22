/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psae2;

/**
 *
 * @author Julia Rzepka
 */
public class Task1 {
    
    public static void main(String[] args) {
        Numbers number = new Numbers(true);
        System.out.println("\nThis is a list of numbers: ");
        number.print(); 
        System.out.println("\nThis is the average of numbers: ");
        System.out.println(number.countAverage());
        System.out.println("\nThis is the minimum: ");
        System.out.println(number.min());
        System.out.println("\nThis is the maximum: ");
        System.out.println(number.max());
        System.out.println("\nThis is the sorted list: ");
        number.sort();
        number.print();
        System.out.println("\nThis is the mediana: ");
        System.out.println(number.mediana());
        Numbers.serialisation(number);
        //Numbers.deserialisation();
        Multinumbers multinumber = new Multinumbers();
        System.out.println("\nThose are the lists inside multilist: ");
        multinumber.print();
        Multinumbers.serialisation(multinumber);
        Multinumbers.deserialisation();
        System.out.println("\nThis is the average of the lists: ");
        System.out.println(multinumber.countAverageOfAll());
        System.out.println("\nThis is the minimum of all lists: ");
        System.out.println(multinumber.minOfAll());
        System.out.println("\nThis is the maximum of all lists: ");
        System.out.println(multinumber.maxOfAll());
    }
}
