/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package earthquakes;

/**
 *
 * @author Lartsev
 */
public class DepthFilter implements Filter{
    private double minDepth;
    private double maxDepth;
    
    /**
     *
     */
    public DepthFilter() {
        minDepth = 0;
        minDepth = 0;
    }
    /**
     * 
     * @param min
     * @param max 
     */
    public DepthFilter(double min, double max) {
        this.minDepth = min;
        this.maxDepth = max;
    }

    /**
     *
     * @param qe
     * @return
     */
    @Override
    public boolean satisfies(QuakeEntry qe) {
        if (qe.getDepth()>minDepth && qe.getDepth()<maxDepth) {
            return true;                                                           
        } else 
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "DepthFilter";
    }
}
