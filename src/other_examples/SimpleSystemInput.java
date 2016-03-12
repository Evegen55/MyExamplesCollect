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

import java.util.Scanner;

/**
 *
 * @author Lartsev
 */
public class SimpleSystemInput {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("input A");
        int a = s.nextInt();
        System.out.println("your A is" + "\t" + a);
        System.out.println("input B");
        int b = s.nextInt();
        System.out.println("your B is" + "\t" + a);
        System.out.println("\n" + "An output is" + "\t" + (a + b));
    }
}
