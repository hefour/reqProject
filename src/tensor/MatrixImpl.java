package tensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class MatrixImpl implements Matrix {
    private int rows;
    private int cols;
    private List<Scalar> matrix = new ArrayList<>();

    MatrixImpl(String stringValue, int m, int n) {
        this.rows = m;
        this.cols = n;

        for (int s = 0; s < m * n; s++) {
            this.matrix.add(new ScalarImpl(stringValue));
        }
    }

    MatrixImpl(int i, int j, int m, int n) {
        this.rows = m;
        this.cols = n;

        for (int s = 0; s < m * n; s++) {
            this.matrix.add(new ScalarImpl(i, j));
        }
    }

    MatrixImpl(String csvValue) {
        String[] arrRow = csvValue.strip().split("\\n");
        this.rows = arrRow.length;

        String[] firstRow = arrRow[0].strip().split(",", -1);
        this.cols = firstRow.length;

        if (this.rows == 1 && this.cols == 1 && firstRow[0].isEmpty()) {
            this.cols = 0;
        }

        for (int r = 0; r < rows; r++) {
            String[] arrCol = arrRow[r].strip().split(",", -1);
            for (String value : arrCol) {
                matrix.add(new ScalarImpl(value.strip()));
            }
        }
    }

    MatrixImpl(Scalar[][] arrValue) {
        this.rows = arrValue.length;
        this.cols = arrValue[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.matrix.add(new ScalarImpl(arrValue[i][j].toString()));
            }
        }
    }

    MatrixImpl(int n) {
        this.rows = n;
        this.cols = n;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.matrix.add(new ScalarImpl(i == j ? "1" : "0"));
            }
        }
    }

    @Override
    public Scalar get(int rowIndex, int colIndex) {
        return matrix.get(rowIndex * cols + colIndex);
    }

    @Override
    public void set(int rowIndex, int colIndex, Scalar setValue) {
        matrix.set(rowIndex * cols + colIndex, setValue);
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
        String[] rowString = new String[rows];

        for (int i = 0; i < rows; i++) {
            String[] colString = new String[cols];
            for (int j = 0; j < cols; j++) {
                colString[j] = get(i, j).toString();
            }
            rowString[i] = "[" + String.join(", ", colString) + "]";
        }

        return "[" + String.join(",\n ", rowString) + "]";
    }

    @Override
    public boolean equals(Object compare) {
        if (this == compare) return true;
        if (!(compare instanceof MatrixImpl other)) return false;
        if (rows != other.rows || cols != other.cols) return false;

        return Objects.equals(matrix, other.matrix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, cols, matrix);
    }

    @Override
    public Matrix clone() {
        Scalar[][] copyArr = new Scalar[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copyArr[i][j] = this.get(i, j).clone();            }
        }
        return new MatrixImpl(copyArr);
    }

    @Override
    public void add(Matrix other) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.get(i, j).add(other.get(i, j));
            }
        }
    }

    public static Matrix add(Matrix m1, Matrix m2) {

        int rows = m1.getRowCount();
        int cols = m2.getColumnCount();
        Scalar[][] result = new Scalar[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = ScalarImpl.add(m1.get(i, j), m2.get(i, j));
            }
        }

        return new MatrixImpl(result);
    }

    @Override
    public void multiply(Matrix other) {
        int newRow = this.rows;
        int newCol = other.getColumnCount();
        Scalar[][] result = new Scalar[newRow][newCol];

        for (int i = 0; i < newRow; i++) {
            for (int j = 0; j < newCol; j++) {
                Scalar sum = new ScalarImpl("0");
                for (int k = 0; k < this.cols; k++) {
                    Scalar temp1 = this.get(i, k);
                    Scalar temp2 = other.get(k, j);
                    Scalar midResult = ScalarImpl.multiply(temp1, temp2);
                    sum = ScalarImpl.add(sum, midResult);
                }
                result[i][j] = sum;
            }
        }

        this.rows = newRow;
        this.cols = newCol;
        this.matrix.clear();
        for (int i = 0; i < newRow; i++) {
            for (int j = 0; j < newCol; j++) {
                this.matrix.add(result[i][j]);
            }
        }
    }

    public static Matrix multiply(Matrix m1, Matrix m2) {

        int row = m1.getRowCount();
        int col = m2.getColumnCount();
        Scalar[][] result = new Scalar[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Scalar sum = new ScalarImpl("0");
                for (int k = 0; k < m1.getColumnCount(); k++) {
                    Scalar product = ScalarImpl.multiply(m1.get(i, k), m2.get(k, j));
                    sum = ScalarImpl.add(sum, product);
                }
                result[i][j] = sum;
            }
        }

        return new MatrixImpl(result);
    }

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
