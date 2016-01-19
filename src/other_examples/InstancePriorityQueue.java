/*
 * Copyright (C) 2016 Lartsev
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

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Lartsev
 */
public class InstancePriorityQueue {
    public static void main(String[] args)
    {
        InstancePriorityQueue ipq = new InstancePriorityQueue();
        ipq.test();
    }
    
    
    /**
     * 
     */
    public void test() {
        //use inner class to create comparator
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                // Assume neither string is null. Real code should
                // probably be more robust
                // You could also just return x.length() - y.length(),
                // which would be more efficient.
                if (x.length() < y.length()) {
                    return -1;
                    }
                if (x.length() > y.length()) {
                    return 1;
                }
                return 0;
            }
        };
        
        
        
        
        PriorityQueue<String> queue = new PriorityQueue<>(2, comparator);
        queue.add("short");
        queue.add("very long indeed");
        queue.add("medium");
        while (queue.size() != 0)
        {
            System.out.println(queue.remove());
        }
        System.out.println("----------------------------------------------------");
        
        //or use a helper method to create comparator
        Comparator<String> comparatorAsMethod = createComparator();
        PriorityQueue<String> queueAsM = new PriorityQueue<>(10, comparatorAsMethod);
        queueAsM.add("short");
        queueAsM.add("very long indeed");
        queueAsM.add("medium");
        while (!queueAsM.isEmpty())
        {
            System.out.println(queueAsM.remove());
        }
        System.out.println("----------------------------------------------------");
        //or use a natural order
        PriorityQueue<Integer> queueAsNat = new PriorityQueue<>();
        queueAsNat.add(1);
        queueAsNat.add(2);
        queueAsNat.add(3);
        queueAsNat.poll();
        while (!queueAsNat.isEmpty())
        {
            System.out.println(queueAsNat.remove());
        }
        
    }
    
    /**
     * 
     * @return 
     */
    public Comparator<String> createComparator() {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                // Assume neither string is null. Real code should
                // probably be more robust
                // You could also just return x.length() - y.length(),
                // which would be more efficient.
                if (x.length() < y.length()) {
                    return -1;
                    }
                if (x.length() > y.length()) {
                    return 1;
                }
                return 0;
            }
        };
		return comparator;
    }
    
}
