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
package binary_search;

/**
 *
 * @author Lartsev
 */
public class BinarySearchByMe {
    
    private long[] a; //pre-sorted array

    public BinarySearchByMe(long[] a) {
        this.a = a;
    }
        
    public int find(long searchKey) {
        return recFind(searchKey, 0, a.length-1);
    }
   //-----------------------------------------------------------
    private int recFind(long searchKey, int lowerBound, int upperBound) {
        int curIn = (lowerBound + upperBound ) / 2;
        if(a[curIn]==searchKey) {
            return curIn;              // found it
        } else if(lowerBound > upperBound) {
            return a.length;             // can't find it
            // divide range
        } else {
            // it's in upper half
            if(a[curIn] < searchKey) {
                return recFind(searchKey, curIn+1, upperBound);
                // it's in lower half
            } else {
                return recFind(searchKey, lowerBound, curIn-1);
            }                      
        }  // end else divide range
    }  // end recFind()
    
    /*
    public static void main(String[] args){
    long[] a = {9, 18, 27, 36, 45, 54, 63, 72, 81, 90, 99, 108, 117, 126, 135, 144};
    long f = 27;
    BinarySearchByMe bs = new BinarySearchByMe(a);
    System.out.println("Find at position " + bs.find(f));
    }*/
}
