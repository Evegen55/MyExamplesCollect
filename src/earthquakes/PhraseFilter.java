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
public class PhraseFilter implements Filter{
    private String where;
    private String what;
    
    /**
     *
     * @param loc
     * @param phrase
     */
    public PhraseFilter(String loc, String phrase) {
        where = loc;
        //where = "any";
        //where = "end";
        what = phrase;
    }
    
    /**
     *
     * @param qe
     * @return
     */
    @Override
    public boolean satisfies(QuakeEntry qe) {
        if (where.equals("end") && qe.getInfo().endsWith(what)) {
            return true;
        } else if (where.equals("start") && qe.getInfo().startsWith(what)) {
            return true;
        }
        else if (where.equals("any") && qe.getInfo().contains(what)) {
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
        return "PhraseFilter";
    }
    
}
