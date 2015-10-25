/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixes;

/**
 *
 * @author Evgenn
 */
public class TestCase {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        double MatrixArrayFirst [][] = new double[][] {
                                                   {1,2,3},
                                                   {4,5,6},
                                                   {7,8,9},
                                                   //{7,8,9}
                                                };
        double MatrixArraySecond [][] = new double [][] {
                                                   {10,11,12},
                                                   {13,14,15},
                                                   {16,17,18},
        //                                           {7,8,9}
                                                };
        double MatrixArrayThird [][] = new double [][] {
                                                   {10,11,12},
                                                   {13,14,15},
                                                   {16,17,18},
                                                   {7,8,125},{}
                                                };
                                                
        ModuleForAdditionMatrix eXample = new ModuleForAdditionMatrix();
        System.out.println ("Test First Matrix");
        eXample.printMatrixArray(MatrixArrayFirst);
        System.out.println ("Test Second Matrix");
        eXample.printMatrixArray(MatrixArraySecond);
        System.out.println (" ");
        System.out.println (" ");
        System.out.println ("Test Case 1 - Summ of Matrix");
        eXample.printMatrixArray(eXample.sumMatrix(MatrixArrayFirst,MatrixArraySecond));
        System.out.println (" ");
        System.out.println (" ");
        /*System.out.println ("Test Case - Checking Dimensions" + " " + eXample.checkArraysDimension(MatrixArrayFirst,MatrixArraySecond));
        System.out.println ("Test Case - Checking RectangularFirst" + " " + eXample.checkArray (MatrixArrayFirst));
        System.out.println ("Test Case - Checking RectangularSecond" + " " + eXample.checkArray (MatrixArraySecond));
        System.out.println ("Test Case - Checking num of rows" + " " + eXample.getArrayCountRow (MatrixArraySecond));
        System.out.println ("Test Case - Checking num of columns" + " " + eXample.getArrayCountColumn (MatrixArraySecond));
        System.out.println (" ");
        System.out.println (" ");
        System.out.println ("Test Case - Third Matrix");
        eXample.printMatrixArray(MatrixArrayThird);
        System.out.println ("Test Case 2 - Checking RectangularThird" + " " + eXample.checkArray (MatrixArrayThird));
        System.out.println ("Test Case 2 - Checking num of rows" + " " + eXample.getArrayCountRow (MatrixArrayThird));
        System.out.println ("Test Case 2- Checking num of columns" + " " + eXample.getArrayCountColumn (MatrixArrayThird));
        System.out.println (" ");
        System.out.println (" ");
        */
        ModuleForMultiplyMatrix eXampleMult = new ModuleForMultiplyMatrix();
        System.out.println ("Test Case 3 - Multiple Matrix");
        eXampleMult.printMatrixArray(eXampleMult.MultiplyMatrix(MatrixArrayFirst,MatrixArraySecond));
        //
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        }

}
