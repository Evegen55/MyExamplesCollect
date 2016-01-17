package earthquakes;




/**
 * Write a description of interface Filter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Filter
{

    /**
     *
     * @param qe
     * @return
     */
    public  boolean satisfies(QuakeEntry qe);

    /**
     *
     * @return
     */
    public String getName();
}
