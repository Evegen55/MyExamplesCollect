package matrixes;

/**
 *
 * @author Evgenn
 */
public class ModuleForAdditionMatrix extends CheckMatrix {

    /**
     *
     */
    public ModuleForAdditionMatrix(){}
    //метод для вычисления суммы матриц

    /**
     *
     * @param FirstArr
     * @param SecondArr
     * @return
     */
        public double [][] sumMatrix(double FirstArr[][], double SecondArr[][]) {
        int lengthArr = getArrayCountRow(FirstArr);
        int HeightArr = getArrayCountColumn(FirstArr);
        double SumArr[][]= new double [lengthArr][HeightArr];  
        if (checkArraysDimension(FirstArr,SecondArr)) {
            for (int i=0;i<FirstArr.length;i++) {
                for (int k=0;k<FirstArr[0].length;k++) {
                    SumArr[i][k]=FirstArr[i][k] + SecondArr[i][k];
                    }
                    }
                    }
                    return SumArr;
                    }

}
