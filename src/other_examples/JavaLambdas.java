/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other_examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author Evgenn
 */
public class JavaLambdas {

    /**
     * @param args the command line arguments
     */

    
    
    
    public static void main(String[] args) {
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", 
                "Raju", "Sara", "Scott");
        
        System.out.println("1st way");
        for(int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
            }
        
        System.out.println("2nd way");
        for(String name : friends) {
            System.out.println(name);
            }
        
        System.out.println("3rd way");
        friends.forEach(new Consumer<String>() {
            public void accept(final String name) {
                System.out.println(name);
                }
            });
        
        System.out.println("4rd way - лямбда - выражение");
        friends.forEach((final String name) -> 
                System.out.println(name));
        
        System.out.println("5th way - лямбда - выражение");
        friends.forEach(System.out::println);
        
        /*List<String> vitamins = new ArrayList<>();
        vitamins.add("A");
        System.out.println(vitamins);
        vitamins.add("B12");
        System.out.println(vitamins);
        vitamins.add("C");
        System.out.println(vitamins);
        vitamins.set(1,"B");
        System.out.println(vitamins);
        vitamins.add(1,"D");
        System.out.println(vitamins);
                */
        }
    
}
