package tensor;

import java.math.BigDecimal;
import java.rmi.MarshalException;

public interface Matrix {
    // 11. 요소 지정/조회
    Scalar get(int rowIndex, int colIndex);
    void set(int rowIndex, int colIndex, Scalar value);

    // 13. 크기 정보 조회
    int getRowCount();
    int getColumnCount();

    // 14. 콘솔 출력
    @Override String toString();

    // 15. 동등성 판단
    @Override boolean equals(Object obj);

    // 17. 객체 복제
    Matrix clone();

    // 22. 행렬 덧셈 (Non-Static)
    //void add(Matrix other);

    // 23. 행렬 곱셈 (Non-Static)
    //void multiply(Matrix other);

    // 28. 두 행렬 덧셈 (Static)
    static Matrix add(Matrix m1, Matrix m2) {
        System.out.println("// 28. 정적 행렬 덧셈 호출됨 (구현 필요)");
        return null; // 최종 구현 필요
    }

    // 29. 두 행렬 곱셈 (Static)
    static Matrix multiply(Matrix m1, Matrix m2) {
        System.out.println("// 29. 정적 행렬 곱셈 호출됨 (구현 필요)");
        return null; // 최종 구현 필요
    }

    // 32. 가로로 행렬 합치기
    static Matrix pasteToWidth(Matrix matrix1, Matrix matrix2) {
        return null;
    }
    Matrix widthPaste(Matrix matrix);

    // 33. 세로로 행렬 합치기
    static Matrix pasteToHeight(Matrix matrix1, Matrix matrix2){
        return null;
    }
    Matrix heightPaste(Matrix matrix);

    // 34. 특정 행 벡터로 추출
    Vector rowVector(Matrix matrix);

    // 35. 특정 열 벡터로 추출
    Vector colVector(Matrix matrix);

    // 36. 특정 범위의 부분 행렬 추출
    Matrix getSubMatrix(int startRow, int endRow, int startCol, int endCol);

    // 37. minor 행렬 추출
    Matrix getMinor(int rowIndex, int colIndex);

    // 38. 전치 행렬 생성
    Matrix transpose(Matrix matrix);

    // 39. 대각요소의 합
    Scalar trace(Matrix matrix);

    // 40. 정사각 행렬 판별
    boolean isSquare();

    // 41. 상삼각 행렬 판별
    boolean isUpperTriangular();

    // 42. 하삼각 행렬 판별
    boolean isLowerTriangular();

    // 43. 단위 행렬 판별
    boolean isIdentity();

    // 44. 영 행렬 판별
    boolean isZero();

    // 45. 행 교환
    void swapRows(int row1, int row2);

    // 46. 열 교환
    void swapColumns(int col1, int col2);

    // 47. 행 스칼라 곱
    void scaleRow(int rowIndex, Scalar scalar);

    // 48. 열 스칼라 곱
    void scaleColumn(int colIndex, Scalar scalar);

    // 49. 행에 다른 행의 배수 더하기
    void addRowMultiple(int targetRow, int sourceRow, Scalar scalar);

    // 50. 열에 다른 열의 배수 더하기
    void addColumnMultiple(int targetCol, int sourceCol, Scalar scalar);


}