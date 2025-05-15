package tensor;

import java.math.BigDecimal;
import java.util.List;

public class Factory {

    public static Scalar createScalarByRandom(int minBound, int maxBound) {
        System.out.println("스칼라생성");
        return new ScalarImpl(minBound, maxBound);
    }
    public static Scalar createScalarByString(String valueString) {
        System.out.println("스칼라생성");
        return new ScalarImpl(valueString);
    }
    public static Vector createVectorByRandom(int dimension, int minBound, int maxBound){
        System.out.println("벡터생성");
        return new VectorImpl(dimension, minBound, maxBound);
    }
    public static Vector createVectorByString(int dimension,String valueString){
        System.out.println("벡터생성");
        return new VectorImpl(dimension,valueString);
    }
    public static Vector createVectorByArray(List<BigDecimal> valueList){
        System.out.println("벡터생성");
        return new VectorImpl(valueList);
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

