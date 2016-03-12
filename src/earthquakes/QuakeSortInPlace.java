package earthquakes;


/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

/**
 *
 * @author Evegen
 */
public class QuakeSortInPlace
{

    /**
     *
     */
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }
   
    /**
     *
     * @param quakes
     * @param from
     * @return
     */
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    /**
     * This method sorts the QuakeEntry’s in the ArrayList by madnitude using 
     * the SELECTION SORT algorithm
     * @param in 
     */
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    }

    /**
     *
     */
    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        //String source = "data/nov20quakedata.atom";
        //String source = "data/earthQuakeDataDec6sample1.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");
        //Modify the testSort method to comment out the line sortByMagnitude 
        //and add below this line a call to sortByLargestDepth. 
        //Run your program on any data file and you should see the earthquakes 
        //in sorted order from largest depth to smallest depth.
        //sortByMagnitude(list);
        
        //Modify the testSort method to comment out the line sortByLargestDepth, 
        //and add below this line a call to sortByMagnitudeWithBubbleSort. 
        //Run your program on any data file and you should see the earthquakes 
        //in sorted order from smallest to largest magnitude.
        sortByLargestDepth(list);
        //bubbleSort(list);
        
        
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
        
    }
    
    /**
     *
     */
    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }
    
    /**
     *
     * @param list
     */
    public void dumpCSV(ArrayList<QuakeEntry> list){
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for(QuakeEntry qe : list){
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
			                  qe.getLocation().getLatitude(),
			                  qe.getLocation().getLongitude(),
			                  qe.getMagnitude(),
			                  qe.getInfo());
	    }
		
	}
    
    /**
     *
     * @param quakeData
     * @param from representing an index position in the ArrayList
     * @return  an integer representing the index position of the QuakeEntry 
     * with the largest depth considering only those QuakeEntry’s from position from 
     * to the end of the ArrayList.
     */
    public int getLargestDepth(ArrayList<QuakeEntry> quakeData, int from){
        ArrayList<QuakeEntry> quakeDataFrom = new ArrayList<>();
        for (int i = from; i< quakeData.size(); i++) {
            quakeDataFrom.add(quakeData.get(i));
        }
        QuakeEntry max = Collections.max(quakeDataFrom, cmtrDepth);
        
        return quakeDataFrom.indexOf(max);
    }
    /**
     * This method sorts the QuakeEntry’s in the ArrayList by depth using the selection sort algorithm, 
     * but in reverse order from largest depth to smallest depth 
     * (the QuakeEntry with the largest depth should be in the 0th position in the ArrayList). 
     * This method should call the method getLargestDepth repeatedly until the ArrayList is sorted.
     * @param in 
     */
    public void sortByLargestDepth(ArrayList<QuakeEntry> in){
        Collections.sort(in, cmtrDepth);
    }
    /**
     * comparator
     */
   private final Comparator<QuakeEntry> cmtrDepth = (QuakeEntry t, QuakeEntry t1) -> {
        if (t.getDepth() < t1.getDepth())
            return -1;
        if (t.getDepth() == t1.getDepth())
            return 1;
        if (t1.getDepth() > t1.getDepth())
            return 0;
        return 1;
    };
   
   //--------------------------------------------------------------
   /**
    * a helper method for swap two integers
    * @param in
    * @param one
    * @param two 
    */
   private void swap(ArrayList<QuakeEntry> in, int one, int two)
      {
      QuakeEntry temp = in.get(one);
      
      in.set(one, in.get(two));
      in.set(two, temp);
      }
   
   //--------------------------------------------------------------
   /**
    * 
    * @param swapped 
    */
   public void bubbleSort(ArrayList<QuakeEntry> swapped){
      int out, in;
      int nElems = swapped.size();

      for(out=nElems-1; out>1; out--)   // outer loop (backward)
         for(in=0; in<out; in++)        // inner loop (forward)
            if(swapped.get(in).getMagnitude() > swapped.get(in+1).getMagnitude())// out of order? MAGNITUDE
               swap(swapped,in, in+1);          // swap them
      }  // end bubbleSort()
   
   //-------------------------------------------------------------------------
   //TODO Assignment 3: Check for Completion
   /**
    * 
    * @param quakes
    * @return true if the earthquakes are in sorted order by magnitude from smallest to largest. 
    * Otherwise this methods returns false. You’ll need to loop through the ArrayList 
    * and check adjacent earthquakes to see if any are out of order.
    */
   public boolean checkInSortedOrder(ArrayList<QuakeEntry> quakes) {
       //TODO
       for (QuakeEntry qe :  quakes) {
          // if() {}
       }
       return false;
   }
   
}
