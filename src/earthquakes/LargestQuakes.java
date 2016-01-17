/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package earthquakes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Lartsev
 * 
 * 
 * 
 * Assignment 5: Finding the Largest Magnitude Earthquakes
 * In this assignment you will write a new class and methods to determine the N biggest
 * earthquakes, those with largest magnitude.
 */
public class LargestQuakes {
    /**
     * Write a void method named findLargestQuakes that reads in earthquake data from a
     * source and storing them into an ArrayList of type QuakeData. Then it prints all the
     * earthquakes and how many earthquakes that were from the source. You should read
     * in earthquakes from the small file nov20quakedatasmall.atom , print all the
     * earthquakes and also print how many there are. After this works you should comment
     * out the printing of all the earthquakes, but continue to print out the total number of
     * earthquakes read in.
     */
    public void findLargestQuakes() {
	EarthQuakeParser parser = new EarthQuakeParser();
        String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedata.atom";
        //String  source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size() + " quakes");
        System.out.println("//---------------------------------------------------");
        System.out.println("ArrayList unsorted");
        System.out.println("//---------------------------------------------------");
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
        System.out.println("index of largest" + "\t" + indexOfLargest(list));
    }
    /**
     * Realise Inner class for compare ArrayList with some objects
     * 
     * @param Data
     * @return 
     */
    public int indexOfLargest(ArrayList<QuakeEntry> Data) {
        
        Comparator<QuakeEntry> cmtr = new Comparator<QuakeEntry>() {
            @Override
            public int compare(QuakeEntry t, QuakeEntry t1) {
                if (t.getMagnitude() < t1.getMagnitude())
                    return -1;
                if (t.getMagnitude() == t1.getMagnitude()) 
                    return 1;
                if (t1.getMagnitude() > t1.getMagnitude())
                    return 0;
            return 1;
            }
        };
        
        QuakeEntry max = Collections.max(Data, cmtr);
        int maxIndex = Data.indexOf(max);
        //----------------------------------------------------------------------
        System.out.println("//---------------------------------------------------");
        System.out.println("ArrayList sorted by Magnitude using inner class with Comparator");
        System.out.println("//---------------------------------------------------");
        Collections.sort(Data, cmtr);
        for (QuakeEntry qe : Data) {
            System.out.println(qe);
        }
        
        
        return maxIndex;
    }
    
    /**
     *
     * @param Data
     * @param howMany
     * @return
     */
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> Data, int howMany) {
        ArrayList<QuakeEntry> trimData = new ArrayList<QuakeEntry>();
        //------------------------------------------------------------
        //Use lambda-function:
        Comparator<QuakeEntry> cmtr = (QuakeEntry t, QuakeEntry t1) -> {
            if (t.getMagnitude() < t1.getMagnitude())
                return -1;
            if (t.getMagnitude() == t1.getMagnitude())
                return 1;
            if (t1.getMagnitude() > t1.getMagnitude())
                return 0;
            return 1;
        };
        //-------------------------------------------------------------
        Collections.sort(Data, cmtr);
        Collections.reverse(Data);
        if (howMany<=Data.size()) {
            for (int i =0; i < howMany; i++) {
                trimData.add(Data.get(i));
            }
        }
        return trimData;
    }
    
    /**
     *
     */
    public void findListOfLargestQuakes() {
	EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        //String  source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size() + " quakes");
        System.out.println("//---------------------------------------------------");
        System.out.println("ArrayList of Largest Quakes");
        System.out.println("//---------------------------------------------------");
         ArrayList<QuakeEntry> listTrimmed = getLargest(list, 10);
        for (QuakeEntry qe : listTrimmed) {
            System.out.println(qe);
        }
        
        //All earthquakes
        System.out.println("index of largest" + "\t" + indexOfLargest(list));
    }

    
    
}
