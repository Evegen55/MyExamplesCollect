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
package matrixes;

/**
 *
 * @author Johnn
 */
public abstract class CheckMatrix {
    
    /**
     * @param First is an array which has to be check for rectangularity.
     * (проверка массива на прямоугольность).
     * @return boolean
     */
    public boolean checkArray(double First[][]) {
       boolean checking = false;
       for (int i=1;i<First.length;i++) {
           checking = First[i].length == First[i-1].length;
        
        }
       return checking;    
    }
    /**
     * @param FirstA is a first array which dimension has to be check and compare 
     * with other array. (проверка равенства размерности двух массивов)
     * @param SecondA is a second array which has to be check and compare 
     * with other array.
     * @return boolean
     */
    public boolean checkArraysDimension(double FirstA[][], double SecondA[][])
    {
       boolean checking = false;
       if (
       checkArray(FirstA) &&
       checkArray(SecondA) &&
       FirstA.length == SecondA.length &&
       FirstA[0].length == SecondA[0].length &&
       getArrayCountColumn(FirstA)!=-1 &&
       getArrayCountRow(FirstA)!=-1
       ) {
       checking = true;
       }
       return checking;
    }
    /**
     * @param PrintedArr is an  array which has to be printed. 
     * (вывести на печать двумерный массив)
     */   
    public void printMatrixArray(double PrintedArr[][]) {
    if (checkArray(PrintedArr)) {
            for (double[] PrintedArr1 : PrintedArr) {
                for (int k = 0; k<PrintedArr[0].length; k++) {
                    System.out.print(PrintedArr1[k] + "\t");
                }
                System.out.println();
            }
         }else {System.out.println("Matrix is not rectangular");} 
    }
    /**
     *
     * @param MatrixArrayNoName is an array which rows has to be counted
     * (метод возвращает количество строк)
     * @return amount of rows
     */
    public int getArrayCountRow(double MatrixArrayNoName [][]) {
         int i = 0;
         if (MatrixArrayNoName.length<=0) {
            i = -1;
        }else{i=MatrixArrayNoName.length;}
        return i;
    }
    /**
     *
     * @param MatrixArrayNoName is an array which columns has to be counted 
     * (метод возвращает количество столбцов)
     * @return amount of columns
     */
     public int getArrayCountColumn(double MatrixArrayNoName [][]) {
         int i = 0;
         if (MatrixArrayNoName.length<=0 ||
                 MatrixArrayNoName[0].length<=0 ||
                 checkArray(MatrixArrayNoName)==false) {
            i = -1;}else{
             i=MatrixArrayNoName[0].length;
         }
        return i;
    }
    //метод, который выполняет отдельную проверку на равенство ширины двух матриц

    /**
     *
     * @param MatrixArrayNoNameFirst
     * @param MatrixArrayNoNameSecond
     * @return
     */
     public boolean checkArraysWidth(double MatrixArrayNoNameFirst [][],
             double MatrixArrayNoNameSecond [][]) {
         boolean checking = false;
         if (getArrayCountColumn(MatrixArrayNoNameFirst)==getArrayCountColumn(MatrixArrayNoNameSecond)){
             checking = true;
        }
         return checking;        
        }
}

