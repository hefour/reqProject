package tensor;

import java.math.BigDecimal;
import java.util.List;

public class Factory {

    public static void createScalar(){
        System.out.println("스칼라생성");
        ScalarImpl test = new ScalarImpl();
        BigDecimal ab = test.makeScalar(3,6);
        System.out.println(ab);
    }
    public static Vector createVector(){
        System.out.println("벡터생성");
        return new VectorImpl();
    }

    public static Matrix createMatrixByTypeNum(BigDecimal typeNum, int m, int n) {
        return new MatrixImpl(typeNum, m, n);
    }

    public static Matrix createMatrixRandom(int i, int j, int m, int n) {
        return new MatrixImpl(i, j, m, n);
    }

    public static Matrix createMatrixByCSV(String csvData) {
        return new MatrixImpl(csvData);
    }

    public static Matrix createMatrixByArray(int[][] arr) {
        return new MatrixImpl(arr);
    }

    public static Matrix createUnitMatrix(int n) {
        return new MatrixImpl(n);
    }
}
