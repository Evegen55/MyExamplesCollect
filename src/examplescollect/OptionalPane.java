
/**
 * Write a description of class OptionalPane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;

/**
 *
 * @author Evegen
 */
public class OptionalPane
{
   
    /**
     *
     * @param args
     */
    public static void main (String[] args) 
    {
        String fn = JOptionPane.showInputDialog("Enter first number");
        String sn = JOptionPane.showInputDialog("Enter second number");
        
        int num1 = Integer.parseInt(fn);
        int num2 = Integer.parseInt(sn);
        
        int sum = num1 * num2;
        
        JOptionPane.showMessageDialog(null, "The answer is " + sum, "the title", JOptionPane.PLAIN_MESSAGE);
    }
}
