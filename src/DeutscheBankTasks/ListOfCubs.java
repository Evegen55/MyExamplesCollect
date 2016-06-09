/*
 * Copyright (C) 2016 Evegen
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
package DeutscheBankTasks;

/**
 *
 * @author Evegen
 */
public class ListOfCubs {
    
    public void abc() {
        for (int i = 100; i<1000; i++) {
            String a = Integer.toString(i);
            int b = a.charAt(0)-48;
            int c = a.charAt(1)-48;
            int d = a.charAt(2)-48;
            
            int cubs = (int) (Math.pow(b, 3) + Math.pow(c, 3)+ Math.pow(d, 3));
            if (i == cubs) {
                System.out.println(i + "\t" + "b");
            }
        }
    }
    
    public static void main(String[] args) {
        ListOfCubs abs = new ListOfCubs();
        abs.abc();
    }
}
