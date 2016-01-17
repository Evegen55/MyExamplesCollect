package earthquakes;




import java.util.*;
import edu.duke.*;

/**
 *
 * @author Lartsev
 */
public class EarthQuakeClient {
    
    /**
     *
     * @param quakeData
     * @param magMin
     * @return
     */
    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData, double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        //TODO
        for (QuakeEntry qe : quakeData) {
            if (qe.getMagnitude() > magMin) {
                answer.add(qe);
            }
        }
        return answer;              
    }
    
    /**
     *
     * @param quakeData
     * @param distMax
     * @param from
     * @return
     */
    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData, double distMax, Location from) {      
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for (QuakeEntry qe : quakeData) {
            if (qe.getLocation().distanceTo(from) < distMax) {
                answer.add(qe);
            }
        }
        return answer;
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
     */
    public void bigQuakes() {
	EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedata.atom";
        String  source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size() + " quakes");
        /*
        for (QuakeEntry qe : list) {
            if (qe.getMagnitude() > 5.0) {
                System.out.println(qe);
            }
        }
        */
        ArrayList<QuakeEntry> listBig = filterByMagnitude(list, 5.0);
        for (QuakeEntry qe : listBig) {
           System.out.println(qe); 
        }
	}
	
    /**
     *
     */
    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String  source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    /**
     *
     */
    public void closeToMe() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String  source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("# quakes read: " + list.size());
        
        //Durham, NC
        //Location city = new Location(35.988, -78.907);
        //Bridgeport, CA
        Location city = new Location(38.17, -118.82);
        ArrayList<QuakeEntry> close = filterByDistanceFrom(list, 1000*1000, city);
        for (int k=0; k< close.size(); k++) {
            QuakeEntry entry = close.get(k);
            double distanceInMeters = city.distanceTo(entry.getLocation());
            System.out.println(distanceInMeters/1000 + " " + entry.getInfo());
        }

    }
    
    //------------------------------------------------------------------------
    /*
    Assignment 2: Filtering by Depth
    In this assignment you will filter earthquakes by their depth, finding those earthquakes whose
    depth is between a minimum and maximum value. For more information on what the "depth"
    of an earthquake means, see the information here:
    http://earthquake.usgs.gov/learn/topics/seismology/determining_depth.php
    */
    
    /**
     * Write the method filterByDepth that has three parameters, an ArrayList of type
     * QuakeEntry named quakeData , a double named minDepth and a double named
     * maxDepth . This method should return an ArrayList of type QuakeEntry of all the
     * earthquakes from quakeData whose depth is between minDepth and maxDepth .
     * 
     * 
     * @param quakeData
     * @param minDepth
     * @param maxDepth
     * @return 
     */
    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData, double minDepth, double maxDepth) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        //TODO
        for (QuakeEntry qe : quakeData) {
            if (qe.getDepth() > minDepth  && qe.getDepth() < maxDepth) {
                answer.add(qe);
            }
        }
    return answer;              
    }
    
    /**
     * Write the void method quakesOfDepth that has no parameters to use filterByDepth
     * and print all the earthquakes from a data source whose depth is between a given
     * minimum and maximum value. You should also print out the number of earthquakes
     * found.
     *  
     */
    
   
    public void quakesOfDepth() {
	EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        //String  source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size() + " quakes");
        
        ArrayList<QuakeEntry> listBig = filterByDepth(list, -4000.0, -2000.0);
        for (QuakeEntry qe : listBig) {
           System.out.println(qe); 
        }
        //for quizz
        System.out.println(listBig.size()); 
    }
    
    //-------------------------------------------------------------------------
    /*
    Assignment 3: Filtering by Phrase in Title
    In this assignment you will filter earthquakes by a phrase in the title given for the earthquake
    in three ways, finding those earthquakes whose title starts with a phrase, ends with a phrase,
    or just has a phrase somewhere in the title.
    */
    
    
    /**
     * Write the method filterByPhrase that has three parameters, an ArrayList of type
     * QuakeEntry named quakeData , a String named where that indicates where to search
     * in the title and has one of three values: (“start”, ”end”, or “any”), and a String named
     * phrase , indicating the phrase to search for in the title of the earthquake. The title of
     * the earthquake can be obtained through the getInfo() method. The filterByPhrase
     * method should return an ArrayList of type QuakeEntry of all the earthquakes from
     * quakeData whose titles have the given phrase found at location where (“start” means
     * the phrase must start the title, “end” means the phrase must end the title and “any”
     * means the phrase is a substring anywhere in the title.)
     * 
     * @param quakeData
     * @param where
     * @param phrase
     * @return 
     */
    public ArrayList<QuakeEntry> filterByPhrase (ArrayList<QuakeEntry> quakeData, String where, String phrase) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (QuakeEntry qe : quakeData) {
            if (where.equals("end") && qe.getInfo().endsWith(phrase)) {
                answer.add(qe);
            } else if (where.equals("start") && qe.getInfo().startsWith(phrase)) {
                answer.add(qe);
            } else if (where.equals("any") && qe.getInfo().contains(phrase)) {
                answer.add(qe);
            }
        }
    return answer;              
    }

    /**
     *
     */
    public void quakesByPhrase() {
	EarthQuakeParser parser = new EarthQuakeParser();
        String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedata.atom";
        //String  source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size() + " quakes");
        
        //ArrayList<QuakeEntry> listBig = filterByPhrase(list, "end", "California");
        ArrayList<QuakeEntry> listBig = filterByPhrase(list, "any", "Ru");
        for (QuakeEntry qe : listBig) {
           System.out.println(qe); 
        }
        //for quizz
        System.out.println(listBig.size());
    }

    /**
     *
     */
    public void allQuaqesRussia() {
	EarthQuakeParser parser = new EarthQuakeParser();
        String sourcePastWeek= "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String sourcePastHours = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.atom";
        String sourcePastDay = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_day.atom";
        
        ArrayList<QuakeEntry> listHours = parser.read(sourcePastHours);
        ArrayList<QuakeEntry> listDaily = parser.read(sourcePastDay);
        ArrayList<QuakeEntry> listWeekly = parser.read(sourcePastWeek);
        
        System.out.println("Quakes in Russia");
        
        System.out.println("for past hours:");
        System.out.println("read data for past hour" + "\t"  + listHours.size() + " quakes");
        ArrayList<QuakeEntry> listBigHours = filterByPhrase(listHours, "any", "Russia");
        printArray(listBigHours);
        System.out.println("Amount of quakes for past hour" + "\t" + listBigHours.size());
        System.out.println("//=========================================================");
        System.out.println("for past day:");
        System.out.println("read data for past day" + "\t"  + listDaily.size() + " quakes");
        ArrayList<QuakeEntry> listBigDaily = filterByPhrase(listDaily, "any", "Russia");
        printArray(listBigDaily);
        System.out.println("Amount of quakes daily" + "\t" + listBigDaily.size());
        System.out.println("//=========================================================");
        System.out.println("for past week:");
        System.out.println("read data for past week" + "\t"  + listWeekly.size() + " quakes");
        ArrayList<QuakeEntry> listBigWeekly = filterByPhrase(listWeekly, "any", "Russia");
        printArray(listBigWeekly);
        System.out.println("Amount of quakes weekly" + "\t" + listBigWeekly.size());
        
    }
    
    /**
     *
     * @param list
     */
    public void printArray(ArrayList<QuakeEntry> list) {
        for (QuakeEntry qe : list) {
           System.out.println(qe); 
        }
    }
}
