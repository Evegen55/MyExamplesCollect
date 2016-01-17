package earthquakes;

import java.util.*;
import edu.duke.*;

/**
 *
 * @author Lartsev
 */
public class EarthQuakeClient2
{

    /**
     *
     */
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    /**
     *
     * @param quakeData
     * @param f
     * @return
     */
    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        return answer;
    } 

    /**
     *
     */
    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        
        
        //Filter f = new MinMagFilter(4.0); 
        
        
        Location denver = new Location(39.7392, -104.9903);
        Filter floc = new DistanceFilter(1000000, denver);
        Filter fph = new PhraseFilter("end", "a");
        
        
        ArrayList<QuakeEntry> m7  = filter(list, floc); 
        
        ArrayList<QuakeEntry> m8  = filter(m7, fph);
        
        // ArrayList<QuakeEntry> mloc  = filter(list, floc);
        
        Filter fm = new MagnitudeFilter(3.5, 4.5);
        Filter fd = new DepthFilter(-55000.0, -20000.0);
        ArrayList<QuakeEntry> m9  = filter(list, fm); 
        ArrayList<QuakeEntry> m10  = filter(m9, fd);
       
       
       
        for (QuakeEntry qe: m8) {
            System.out.println(qe);
        } 
        System.out.println(m8.size());
        
        
    }
    
    /**
     *
     */
    public void testMatchAllFilter () {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        
        MatchAllFilter maf = new MatchAllFilter();
        Filter fm = new MagnitudeFilter(1.0, 4.0);
        Filter fd = new DepthFilter(-180000.0, -30000.0);
        Filter fph = new PhraseFilter("any", "o");
        maf.addFilter(fm);
        maf.addFilter(fd);
        maf.addFilter(fph);
        ArrayList<QuakeEntry> m  = filter(list, maf);
        
         for (QuakeEntry qe: m) {
            System.out.println(qe);
        }
        System.out.println(m.size());
    }
    
    /**
     *
     */
    public void testMatchAllFilter2 () {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        
        MatchAllFilter maf = new MatchAllFilter();
        Filter fm = new MagnitudeFilter(0.0, 5.0);
        Location billund = new Location(55.7308, 9.1153);
        Filter floc = new DistanceFilter(3000000, billund);
        Filter fph = new PhraseFilter("any", "e");
        
        maf.addFilter(fm);
        maf.addFilter(floc);
        maf.addFilter(fph);
        ArrayList<QuakeEntry> m  = filter(list, maf);
        
         for (QuakeEntry qe: m) {
            System.out.println(qe);
        }
        System.out.println(m.size());
    }

    /**
     *
     */
    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
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

}
