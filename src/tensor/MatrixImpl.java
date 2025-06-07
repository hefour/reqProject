package tensor;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class MatrixImpl implements Matrix {
    private int rows;
    private int cols;
    private List<Scalar> matrixList;

    MatrixImpl(String stringValue, int m, int n) {
        if (m < 0 || n < 0) {
            throw new IllegalArgumentException("행렬의 차원(m, n)은 0 이상이어야 합니다.");
        }
        this.rows = m;
        this.cols = n;
        this.matrixList = new ArrayList<>(m * n);
        for (int i = 0; i < m * n; i++) {
            this.matrixList.add(new ScalarImpl(stringValue));
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

    MatrixImpl(Scalar[][] arr) {
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

    @Override
    public Matrix clone() {
        Scalar[][] copyScalar = new Scalar[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copyScalar[i][j] = get(i, j);
            }
        }
        return new MatrixImpl(copyScalar);
    }


    @Override
    public void add(Matrix other) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Scalar cScalar = get(i, j);
                Scalar oScalar=other.get(i, j);
                cScalar.add(oScalar);
                set(i, j, cScalar);
            }
        }
    }

    @Override
    public void multiply(Matrix other) {
        int oCols = other.getColumnCount();
        Scalar[][] copyScalar = new Scalar[rows][oCols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < oCols; j++) {
                Scalar sum=new ScalarImpl("0");
                for (int k = 0; k < cols; k++) {
                    Scalar mul=get(i,k).clone();
                    mul.multiply(other.get(k,j));
                    sum.add(mul);
                }
                copyScalar[i][j]=sum;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < oCols; j++) {
                set(i, j, copyScalar[i][j]);
            }
        }
        this.cols = oCols;  // 열 개수 갱신

    }
    static Matrix add(Matrix m1, Matrix m2) {
        Scalar[][] res = new Scalar[m1.getRowCount()][m1.getColumnCount()];
        for (int i = 0; i < m1.getRowCount(); i++) {
            for (int j = 0; j < m1.getColumnCount(); j++) {
                Scalar cScalar = m1.get(i, j).clone();
                Scalar oScalar = m2.get(i, j);
                cScalar.add(oScalar);
                res[i][j]=cScalar;
            }
        }
        return new MatrixImpl(res);
    }
    static Matrix multiply(Matrix m1, Matrix m2) {
        int c1=m1.getColumnCount();
        int r1=m1.getRowCount();
        int c2=m2.getColumnCount();
        Scalar[][] result = new Scalar[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                Scalar sum = new ScalarImpl("0");
                for (int k = 0; k < c1; k++) {
                    Scalar a = m1.get(i, k).clone();  // 원본 보존
                    Scalar b = m2.get(k, j);
                    a.multiply(b);
                    sum.add(a);
                }
                result[i][j] = sum;
            }
        }
        return new MatrixImpl(result);
    }

    public Matrix widthPaste(Matrix matrix) {
        int mCols = matrix.getColumnCount();
        Scalar[][] res = new Scalar[getRowCount()][getColumnCount()+mCols];
        for (int i = 0; i < getRowCount(); i++) {
            for (int j = 0; j < getColumnCount(); j++) {
                res[i][j] = get(i, j);
            }
            for (int j=0; j<mCols; j++) {
                res[i][j+getColumnCount()]=matrix.get(i,j);
            }
        }
        return new MatrixImpl(res);
    }
    static Matrix widthPaste(Matrix m1, Matrix m2) {
        return m1.widthPaste(m2);
    }
    public Matrix heightPaste(Matrix matrix) {
        int mRows = matrix.getRowCount();
        Scalar[][] res = new Scalar[getRowCount()+mRows][getColumnCount()];
        for (int i = 0; i < getRowCount(); i++) {
            for (int j = 0; j < getColumnCount(); j++) {
                res[i][j] = get(i, j);
            }
        }
        for (int i = 0; i < mRows; i++) {
            for (int j = 0; j < cols; j++) {
                res[getRowCount() + i][j] = matrix.get(i, j);
            }
        }
        return new MatrixImpl(res);
    }
    static Matrix heightPaste(Matrix m1, Matrix m2) {
        return m1.heightPaste(m2);
    }
    public Vector rowVector(int rowIndex) {
        BigDecimal[] row=new BigDecimal[getColumnCount()];
        for (int i = 0; i < getColumnCount(); i++) {
            row[i]=get(rowIndex,i).getBigDecimalValue();
        }
        return new VectorImpl(row);
    }
    public Vector colVector(int colIndex) {
        BigDecimal[] col=new BigDecimal[getRowCount()];
        for (int i = 0; i < getRowCount(); i++) {
            col[i]=get(i,colIndex).getBigDecimalValue();
        }
        return new VectorImpl(col);
    }
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