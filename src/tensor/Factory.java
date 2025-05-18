package tensor;

import java.math.BigDecimal;
import java.util.List;

public class Factory {

    // Scalar Factory Methods
    public static Scalar createScalarByString(String valueString) {
        // System.out.println("Factory: 문자열 값으로 Scalar 생성 요청: " + valueString); // 한국어로 변경 또는 주석 처리/삭제
        return new ScalarImpl(valueString);
    }

    public static Scalar createScalarByRandom(int minBound, int maxBound) {
        // System.out.println("Factory: 범위 값으로 Scalar 생성 요청: [" + minBound + ", " + maxBound + ")"); // 한국어로 변경 또는 주석 처리/삭제
        return new ScalarImpl(minBound, maxBound);
    }

    // Vector Factory Methods
    public static Vector createVectorByString(int dimension, String valueString) {
        // System.out.println("Factory: " + dimension + "차원, 모든 요소가 \"" + valueString + "\"인 Vector 생성 요청");
        return new VectorImpl(dimension, valueString);
    }

    public static Vector createVectorByRandom(int dimension, int minBound, int maxBound) {
        // System.out.println("Factory: " + dimension + "차원, 범위 [" + minBound + ", " + maxBound + ")의 무작위 값 Vector 생성 요청");
        return new VectorImpl(dimension, minBound, maxBound);
    }

    public static Vector createVectorByArray(List<BigDecimal> initialValueList) {
        // System.out.println("Factory: List<BigDecimal>로부터 Vector 생성 요청, 요소 개수: " + (initialValueList != null ? initialValueList.size() : "null"));
        return new VectorImpl(initialValueList);
    }

    // Matrix Factory Methods
    public static Matrix createMatrixByTypeNum(BigDecimal typeNum, int m, int n) {
        // System.out.println("Factory: 행렬 생성 (지정값)");
        return new MatrixImpl(typeNum, m, n);
    }

    public static Matrix createMatrixRandom(int minRandomVal, int maxRandomVal, int m, int n) {
        // System.out.println("Factory: 행렬 생성 (랜덤)");
        return new MatrixImpl(minRandomVal, maxRandomVal, m, n);
    }

    public static Matrix createMatrixByCSV(String csvData) {
        // System.out.println("Factory: 행렬 생성 (CSV)");
        return new MatrixImpl(csvData);
    }

    public static Matrix createMatrixByArray(int[][] arr) {
        // System.out.println("Factory: 행렬 생성 (2D배열)");
        return new MatrixImpl(arr);
    }

    public static Matrix createUnitMatrix(int n) {
        // System.out.println("Factory: 단위행렬 생성");
        return new MatrixImpl(n);
    }
}