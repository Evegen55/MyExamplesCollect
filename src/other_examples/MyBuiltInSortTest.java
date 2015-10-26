/*
 * Copyright (C) 2015 Johnn
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package other_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Johnn
 */
public class MyBuiltInSortTest implements Comparable <Integer> {
    
   public static void main (String[] args) {
       Random random = new Random();
       List<Integer> numsToSort = new ArrayList();
       
       for (int i = 0; i<20; i++) {
       numsToSort.add(random.nextInt(100));
       }
       
       Collections.sort(numsToSort);//for list
       //Arrays.sort(numsToSort); //for arrays
       System.out.println("New array after builtin sort: " + numsToSort.toString());
 
   }

    //Что бы использовать метод sort, мы должны переопределить метод compareTo
   //интерфейса Comparable <подставить нужный тип>
    @Override
    public int compareTo(Integer t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return 0;
    }
}
