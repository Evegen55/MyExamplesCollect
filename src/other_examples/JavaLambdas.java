/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other_examples;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Evgenn
 */
public class JavaLambdas {
    private Future f;
    
    /**
     * 
     */
    public void inThread() {
        Runnable r = () -> System.out.println("inThread() " + Thread.currentThread().getName());
        Thread t = new Thread(r);
        t.start();
    }
    
    /**
     * 
     */
    public void inExecutorService() {
        ExecutorService e = Executors.newCachedThreadPool();
        Runnable r = () -> System.out.println("inExecutorService() " + Thread.currentThread().getName());
        f = e.submit(r);
        //f.cancel(true);
    }
    
    public void lambdasInMainThread() {
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
        
        System.out.println("6th way - Streams API");
        friends.stream().forEach(System.out::println);
        
        System.out.println("7th way - Streams API - map(), filter()");
        friends
                .stream()
                .filter(friend -> friend.equals("Brian"))
                //.collect(toList())
                .forEach(System.out::println);
        
        
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
    /**
     * 
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        JavaLambdas jl = new JavaLambdas();
        //jl.inThread();
        //jl.inExecutorService();
        jl.lambdasInMainThread();
    }

    
    
}
