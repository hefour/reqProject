package tensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class MatrixImpl implements Matrix {
    private int rows;
    private int cols;
    private List<Scalar> matrixList = new ArrayList<>();

    MatrixImpl(String stringValue, int m, int n) {
        this.rows = m;
        this.cols = n;

        for (int s = 0; s < m * n; s++) {
            this.matrixList.add(new ScalarImpl(stringValue));
        }
    }

    MatrixImpl(int i, int j, int m, int n) {
        this.rows = m;
        this.cols = n;

        for (int s = 0; s < m * n; s++) {
            this.matrixList.add(new ScalarImpl(i, j));
        }
    }

    MatrixImpl(String csvValue) {
        String[] rowsArr = csvValue.strip().split("\\n");
        this.rows = rowsArr.length;

        String[] firstRow = rowsArr[0].strip().split(",", -1);
        this.cols = firstRow.length;

        if (this.rows == 1 && this.cols == 1 && firstRow[0].isEmpty()) {
            this.cols = 0;
        }

        for (int r = 0; r < rows; r++) {
            String[] colsArr = rowsArr[r].strip().split(",", -1);
            for (String value : colsArr) {
                matrixList.add(new ScalarImpl(value.strip()));
            }
        }
    }

    MatrixImpl(Scalar[][] arrValue) {
        this.rows = arrValue.length;
        this.cols = arrValue[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.matrixList.add(new ScalarImpl(arrValue[i][j].toString()));
            }
        }
    }

    MatrixImpl(int n) {
        this.rows = n;
        this.cols = n;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.matrixList.add(new ScalarImpl(i == j ? "1" : "0"));
            }
        }
    }

// ==================================☢️공사 중☢️====================================

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

    @Override
    public Matrix clone() {
        Scalar[][] copyScalar = new Scalar[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copyScalar[i][j] = matrixList.get(i);
            }
        }
        return this;
    }

    @Override
    public void add(Matrix other) {}

    @Override
    public void multiply(Matrix other) {}

    public Matrix widthPaste(Matrix matrix) {
        return this;
    }
    public Matrix heightPaste(Matrix matrix) {
        return this;
    }
    public Vector rowVector(int rowIndex) {
        return new VectorImpl(3,"2");
    }
    public Vector colVector(int colIndex) {return new VectorImpl(3,"2"); }
    public Matrix getSubMatrix(int beginRow, int endRow, int beginCol, int endCol){
        return this;
    }
    public Matrix getMinor(int rowIndex, int colIndex){
        return this;
    }
    public Matrix transpose(){
        return this;
    }
    public Scalar trace(){
        return new ScalarImpl("3");
    }

    @Override
    public boolean isSquare() {
        return false;
    }

    @Override
    public boolean isUpperTriangular() {
        return false;
    }

    @Override
    public boolean isLowerTriangular() {
        return false;
    }

    @Override
    public boolean isIdentity() {
        return false;
    }

    @Override
    public boolean isZero() {
        return false;
    }

    @Override
    public void swapRows(int row1, int row2) {
        System.out.println("두 행을 스왑함");
    }

    @Override
    public void swapColumns(int col1, int col2) {
        System.out.println("두 열을 스왑함");
    }

    @Override
    public void scaleRow(int rowIndex, Scalar scalar) {
        System.out.println("한 행에 스칼라 곱함");
    }

    @Override
    public void scaleColumn(int colIndex, Scalar scalar) {
        System.out.println("한 열에 스칼라 곱함");
    }

    @Override
    public void addRowMultiple(int targetRow, int sourceRow, Scalar scalar) {
        System.out.println("한 행에 스칼라 더하기");
    }

    @Override
    public void addColumnMultiple(int targetCol, int sourceCol, Scalar scalar) {
        System.out.println("한 열에 스칼라 더하기");
    }

    @Override
    public Matrix getRREF() {
        return this;
    }

    @Override
    public boolean isRREF() {
        return false;
    }

    @Override
    public String determinant() {
        return "";
    }

    @Override
    public Matrix inverse() {
        return this;
    }

    ;
}