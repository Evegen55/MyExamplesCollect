package earthquakes;




/**
 * Write a description of class MinMaxFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinMagFilter implements Filter
{
    private double magMin; 
    
    /**
     *
     * @param min
     */
    public MinMagFilter(double min) { 
        magMin = min;
    } 

    /**
     *
     * @param qe
     * @return
     */
    public boolean satisfies(QuakeEntry qe) { 
        return qe.getMagnitude() >= magMin; 
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "MinMagFilter";
    }

}
