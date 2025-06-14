package tensor;

public class MatrixSizeException extends TensorException {
  public MatrixSizeException(int expectedRows, int expectedCols, int actualRows, int actualCols) {
    super(String.format("행렬 크기 불일치 - 기대: %dx%d, 실제: %dx%d",
            expectedRows, expectedCols, actualRows, actualCols));
  }
}