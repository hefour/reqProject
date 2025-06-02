package tensor;

import java.math.BigDecimal;

public class Factory {

    public static Scalar createScalarByString(String valueString) {
        return new ScalarImpl(valueString);
    }

    public static Scalar createScalarByRandom(int minBound, int maxBound) {
        return new ScalarImpl(minBound, maxBound);
    }

    public static Vector createVectorByString(int dimension, String valueString) {
        return new VectorImpl(dimension, valueString);
    }

    public static Vector createVectorByRandom(int dimension, int minBound, int maxBound) {
        return new VectorImpl(dimension, minBound, maxBound);
    }

    public static Vector createVectorByArray(BigDecimal[] initialValueList) {
        return new VectorImpl(initialValueList);
    }

    public static Matrix createMatrixByTypeNum(String stringValue, int m, int n) {
        return new MatrixImpl(stringValue, m, n);
    }

    public static Matrix createMatrixRandom(int minRandomVal, int maxRandomVal, int m, int n) {
        return new MatrixImpl(minRandomVal, maxRandomVal, m, n);
    }

    public static Matrix createMatrixByCSV(String csvData) {
        return new MatrixImpl(csvData);
    }

    public static Matrix createMatrixByArray(Scalar[][] arr) {
        return new MatrixImpl(arr);
    }

    public static Matrix createUnitMatrix(int n) {
        return new MatrixImpl(n);
    }
}