/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Lartsev
 */
public class Logging {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Logger log = LogManager.getLogger(Logging.class);
        String stringMessage = "trouble";
        log.info(stringMessage);
    }
    
}
