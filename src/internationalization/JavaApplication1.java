/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internationalization;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Lartsev
 */
public class JavaApplication1 {

    String message;

    public JavaApplication1(String message) {
        this.message = message;
    }
    
    public void doString(){
        message = java.util.ResourceBundle.getBundle("javaapplication1/Bundle").getString("ENGLISH VERSION");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
    }
    
}
