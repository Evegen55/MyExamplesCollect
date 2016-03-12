/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package earthquakes;



/**
 *
 * @author Johnn
 */
public class Earthquakes_ProgrammingAndInterfaces {
    
    //test package EarthquakeMagnitudeDistanceDemo

    /**
     *
     */
    public void test1(){
        EarthQuakeClient s = new EarthQuakeClient();
        //s.createCSV();
        //s.bigQuakes();
        //s.closeToMe();
        //s.quakesOfDepth();
        s.quakesByPhrase();
    }

    /**
     *
     */
    public void quakesRu(){
        EarthQuakeClient s = new EarthQuakeClient();
        s.allQuaqesRussia();
    }
    
    /**
     *
     */
    public void test2() {
        ClosestQuakes c = new ClosestQuakes();
        c.findClosestQuakes();
    }
    
    /**
     *
     */
    public void test3() {
        LargestQuakes l = new LargestQuakes();
        l.findLargestQuakes();
    }

    /**
     *
     */
    public void test4() {
        LargestQuakes l = new LargestQuakes();
        l.findListOfLargestQuakes();
    }

    /**
     *
     */
    public void test5(){
        EarthQuakeClient2 s = new EarthQuakeClient2();
        //s.createCSV();
        //s.bigQuakes();
        //s.closeToMe();
        //s.quakesOfDepth();
        //s.quakesWithFilter();
        //s.testMatchAllFilter();
        s.testMatchAllFilter2();
    }
    
    /**
     *
     */
    public void testWeek2() {
        QuakeSortInPlace qsip = new QuakeSortInPlace();
        qsip.testSort();
    }
            

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Earthquakes_ProgrammingAndInterfaces d = new Earthquakes_ProgrammingAndInterfaces();
        //quakes in Russia
        d.quakesRu();
        
        //test package EarthquakeMagnitudeDistanceDemo
        //d.test1();
        //d.test2();
        //d.test3();
        //d.test4();
        //d.test5();
        
        //start testing week 2
        //d.testWeek2();
    }
    
}
