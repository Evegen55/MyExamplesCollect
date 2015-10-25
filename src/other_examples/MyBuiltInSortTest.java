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
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Johnn
 */
public class MyBuiltInSortTest {
    
   public static void main (String[] args) {
       Random random = new Random();
       List<Integer> numsToSort = new ArrayList();
       
       for (int i = 0; i<5; i++) {
       numsToSort.add(random.nextInt(100));
       }
       
       Collections.sort(numsToSort);
       System.out.println("New array after builtin sort: " + numsToSort.toString());
   
   }
    
}
