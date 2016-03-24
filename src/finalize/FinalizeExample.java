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
package finalize;

/**
 *
 * @author Cameron, Dane (2015-03-26). 
 *   A Software Engineer Learns Java and Object Orientated Programming (p. 103).
 *   Cisdal. Kindle Edition. 
 * @author Lartsev
 * If you would like to see finalize in action, try executing the following program. 
 * It creates 1 million objects, and immediately dereferences them 
 * (for reasons that will be explained shortly), making them available 
 * for garbage collection:


 */
public class FinalizeExample {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize called");
    }
     
    public static void main(String[] args) {
        for (int i = 0; i < 10000000; i++) {
            FinalizeExample f = new FinalizeExample();
        }
    }
}
