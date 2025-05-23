package tensor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class MatrixImpl implements Matrix {
    private int rows;
    private int cols;
    private List<Scalar> matrixList;

    MatrixImpl(BigDecimal typeNum, int m, int n) {
        if (m < 0 || n < 0) {
            throw new IllegalArgumentException("행렬의 차원(m, n)은 0 이상이어야 합니다.");
        }
        this.rows = m;
        this.cols = n;
        this.matrixList = new ArrayList<>(m * n);
        String valueStr = typeNum.toPlainString();
        for (int i = 0; i < m * n; i++) {
            this.matrixList.add(new ScalarImpl(valueStr));
        }
    }

    MatrixImpl(int minRandomVal, int maxRandomVal, int m, int n) {
        if (m < 0 || n < 0) {
            throw new IllegalArgumentException("행렬의 차원(m, n)은 0 이상이어야 합니다.");
        }
        this.rows = m;
        this.cols = n;
        this.matrixList = new ArrayList<>(m * n);
        for (int k = 0; k < m * n; k++) {
            this.matrixList.add(new ScalarImpl(minRandomVal, maxRandomVal));
        }
    }

    MatrixImpl(String csvData) {
        if (csvData == null) {
            throw new IllegalArgumentException("CSV 데이터는 null일 수 없습니다.");
        }
        String data = csvData.strip();
        if (data.isEmpty()) {
            this.rows = 0;
            this.cols = 0;
            this.matrixList = new ArrayList<>(0);
            return;
        }
        String[] rowsArr = data.split("\\n");
        this.rows = rowsArr.length;
        String[] firstCols = rowsArr[0].strip().split(",", -1);
        this.cols = firstCols.length;

        if (this.rows == 1 && this.cols == 1 && firstCols[0].isEmpty()) {
            this.cols = 0;
        }
        this.matrixList = new ArrayList<>(this.rows * this.cols);
        for (String rowStr : rowsArr) {
            String[] colsArr = rowStr.strip().split(",", -1);
            if (colsArr.length != this.cols) {
                throw new IllegalArgumentException(
                        "csv 데이터 열 개수가 일치하지 않습니다. 기대: " + this.cols + ", 실제: " + colsArr.length
                );
            }
            if (this.cols == 0) continue;
            for (String num : colsArr) {
                this.matrixList.add(new ScalarImpl(num.strip()));
            }
        }
        if (this.matrixList.size() != this.rows * this.cols) {
            throw new IllegalArgumentException(
                    "csv 데이터 크기가 일치하지 않습니다. 기대 크기: " + (this.rows * this.cols) + ", 실제 크기: " + this.matrixList.size()
            );
        }
    }

    MatrixImpl(int[][] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("입력 배열은 null일 수 없습니다.");
        }
        if (arr.length == 0) {
            this.rows = 0;
            this.cols = 0;
            this.matrixList = new ArrayList<>(0);
            return;
        }
        this.rows = arr.length;
        this.cols = (arr[0] == null) ? 0 : arr[0].length;
        this.matrixList = new ArrayList<>(rows * cols);
        for (int i = 0; i < rows; i++) {
            if (arr[i] == null || arr[i].length != cols) {
                throw new IllegalArgumentException("행별 열 개수가 일치해야 합니다.");
            }
            for (int j = 0; j < cols; j++) {
                this.matrixList.add(new ScalarImpl(String.valueOf(arr[i][j])));
            }
        }
    }

    MatrixImpl(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("단위 행렬의 크기(n)는 0 이상이어야 합니다.");
        }
        this.rows = n;
        this.cols = n;
        this.matrixList = new ArrayList<>(n * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.matrixList.add(new ScalarImpl(i == j ? "1" : "0"));
            }
        }
    }

    @Override
    public Scalar get(int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex >= rows || colIndex < 0 || colIndex >= cols) {
            throw new IndexOutOfBoundsException(
                    "인덱스 범위를 벗어났습니다: (" + rowIndex + ", " + colIndex + ")"
            );
        }
        if (rows == 0 || cols == 0) {
            throw new IndexOutOfBoundsException("비어 있는 행렬에서 요소를 가져올 수 없습니다.");
        }
        return matrixList.get(rowIndex * cols + colIndex);
    }

    @Override
    public void set(int rowIndex, int colIndex, Scalar value) {
        if (rowIndex < 0 || rowIndex >= rows || colIndex < 0 || colIndex >= cols) {
            throw new IndexOutOfBoundsException(
                    "인덱스 범위를 벗어났습니다: (" + rowIndex + ", " + colIndex + ")"
            );
        }
        if (value == null) {
            throw new IllegalArgumentException("설정할 값은 null일 수 없습니다.");
        }
        if (rows == 0 || cols == 0) {
            throw new IndexOutOfBoundsException("비어 있는 행렬에 값을 설정할 수 없습니다.");
        }
        matrixList.set(rowIndex * cols + colIndex, value);
    }

    @Override
    public int getRowCount() {
        return rows;
    }

    @Override
    public int getColumnCount() {
        return cols;
    }

    @Override
    public String toString() {
        if (rows == 0 && cols == 0) {
            return "[[]]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < rows; i++) {
            if (i > 0) sb.append(",\n ");
            sb.append("[");
            for (int j = 0; j < cols; j++) {
                sb.append(get(i, j).toString());
                if (j < cols - 1) sb.append(", ");
            }
            sb.append("]");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MatrixImpl)) return false;
        MatrixImpl other = (MatrixImpl) obj;
        if (rows != other.rows || cols != other.cols) return false;
        return Objects.equals(matrixList, other.matrixList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, cols, matrixList);
    }
}