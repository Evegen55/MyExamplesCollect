/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package earthquakes;

import java.util.ArrayList;

/**
 *
 * @author Lartsev
 */
public class MatchAllFilter implements Filter {
    private ArrayList<Filter> arf;
    
    /**
     *
     */
    public MatchAllFilter() {
        arf = new ArrayList<>();
    }
    /**
     * 
     * @param f 
     */
    public void addFilter(Filter f) {
        arf.add(f);
    }
    
    /**
     *
     * @param qe
     * @return
     */
    @Override
    public boolean satisfies(QuakeEntry qe) {
        boolean ret = true;
        for (Filter fl : arf) {
            ret = ret && fl.satisfies(qe);
            }
        return ret;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        StringBuilder sb = new StringBuilder();
        for (Filter fl : arf) {
            sb.append(fl.getName());
            sb.append("\t");
            }
        return sb.toString();
    }
    
}
