package tensor;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    @Override
    public Matrix widthPaste(Matrix other) {
        int originCols = this.cols;
        int addedCols = other.getColumnCount();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < addedCols; j++) {
                Scalar value = other.get(i, j).clone();
                matrix.add(i * originCols + j + i * addedCols, value);
            }
        }

        this.cols += addedCols;
        return this;
    }


    @Override
    public Matrix heightPaste(Matrix other) {
        int addedRows = other.getRowCount();

        for (int i = 0; i < addedRows; i++) {
            for (int j = 0; j < cols; j++) {
                Scalar value = other.get(i, j).clone();
                matrix.add(value);
            }
        }

        this.rows += addedRows;
        return this;
    }

    public static Matrix widthPaste(Matrix m1, Matrix m2) {
        int rows = m1.getRowCount();
        int col1 = m1.getColumnCount();
        int col2 = m2.getColumnCount();
        int totalCol = col1 + col2;

        Scalar[][] newData = new Scalar[rows][totalCol];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col1; j++) {
                newData[i][j] = m1.get(i, j).clone();
            }
            for (int j = 0; j < col2; j++) {
                newData[i][j + col1] = m2.get(i, j).clone();
            }
        }

        return new MatrixImpl(newData);
    }

    public static Matrix heightPaste(Matrix m1, Matrix m2) {
        int cols = m1.getColumnCount();
        int row1 = m1.getRowCount();
        int row2 = m2.getRowCount();
        int totalRow = row1 + row2;

        Scalar[][] newData = new Scalar[totalRow][cols];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < cols; j++) {
                newData[i][j] = m1.get(i, j).clone();
            }
        }

        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < cols; j++) {
                newData[i + row1][j] = m2.get(i, j).clone();
            }
        }

        return new MatrixImpl(newData);
    }

    public Vector rowVector(int rowIndex) {
        BigDecimal[] rowValue = new BigDecimal[cols];

        for (int col = 0; col < cols; col++) {
            int index = rowIndex * cols + col;
            Scalar scalar = matrix.get(index);
            rowValue[col] = scalar.getBigDecimalValue();
        }

        return new VectorImpl(rowValue);
    }

    @Override
    public Vector colVector(int colIndex) {
        BigDecimal[] colValue = new BigDecimal[rows];

        for (int row = 0; row < rows; row++) {
            int index = row * cols + colIndex;
            Scalar scalar = matrix.get(index);
            colValue[row] = scalar.getBigDecimalValue();
        }

        return new VectorImpl(colValue);
    }

    public Matrix getSubMatrix(int beginRow, int endRow, int beginCol, int endCol) {
        int subRow = endRow - beginRow + 1;
        int subCol = endCol - beginCol + 1;
        Scalar[][] subMatrixArray = new Scalar[subRow][subCol];

        for (int r = 0; r < subRow; r++) {
            for (int c = 0; c < subCol; c++) {
                int originalIndex = (beginRow + r) * cols + (beginCol + c);
                subMatrixArray[r][c] = matrix.get(originalIndex);
            }
        }

        return new MatrixImpl(subMatrixArray);
    }


    public Matrix getMinor(int rowIndex, int colIndex) {
        Scalar[][] minorArray = new Scalar[rows - 1][cols - 1];

        int minorRow = 0;
        for (int i = 0; i < rows; i++) {
            if (i == rowIndex) continue;

            int minorCol = 0;
            for (int j = 0; j < cols; j++) {
                if (j == colIndex) continue;

                int originalIndex = i * cols + j;
                minorArray[minorRow][minorCol] = matrix.get(originalIndex);
                minorCol++;
            }
            minorRow++;
        }

        return new MatrixImpl(minorArray);
    }

    public Matrix transpose() {
        Scalar[][] result = new Scalar[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix.get(i * cols + j);
            }
        }
        return new MatrixImpl(result);
    }

    public Scalar trace() {
        Scalar result = new ScalarImpl("0");

        for (int i = 0; i < rows; i++) {
            Scalar current = matrix.get(i * cols + i);
            result.add(current);
        }

        return result;
    }
    @Override
    public boolean isSquare() {
        return rows == cols;
    }

    @Override
    public boolean isUpperTriangular() {
        if (rows != cols) return false;

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                if ((matrix.get(i * cols + j)).getBigDecimalValue().compareTo(BigDecimal.ZERO) != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public boolean isLowerTriangular() {
        if (rows != cols) return false;

        for (int i = 0; i < rows - 1; i++) {
            for (int j = i + 1; j < cols; j++) {
                if ((matrix.get(i * cols + j)).getBigDecimalValue().compareTo(BigDecimal.ZERO) != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public boolean isIdentity() {
        if (rows != cols) return false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                BigDecimal val = (matrix.get(i * cols + j)).getBigDecimalValue();
                if (i == j) {
                    if (val.compareTo(BigDecimal.ONE) != 0) return false;
                } else {
                    if (val.compareTo(BigDecimal.ZERO) != 0) return false;
                }
            }
        }

        return true;
    }

    @Override
    public boolean isZero() {
        for (Scalar s : matrix) {
            if (s.getBigDecimalValue().compareTo(BigDecimal.ZERO) != 0) {
                return false;
            }
        }
        return true;
    }


    @Override
    public void swapRows(int row1, int row2) {
        if (row2 == row1) return;

        for (int col = 0; col < cols; col++) {
            int idx1 = row1 * cols + col;
            int idx2 = row2 * cols + col;

            Scalar temp = matrix.get(idx1);
            matrix.set(idx1, matrix.get(idx2));
            matrix.set(idx2, temp);
        }
    }

    @Override
    public void swapColumns(int col1, int col2) {
        if (col1 == col2) return;

        for (int row = 0; row < rows; row++) {
            int idx1 = row * cols + col1;
            int idx2 = row * cols + col2;

            Scalar temp = matrix.get(idx1);
            matrix.set(idx1, matrix.get(idx2));
            matrix.set(idx2, temp);
        }
    }

    @Override
    public void scaleRow(int rowIndex, Scalar scalar) {
        for (int col = 0; col < cols; col++) {
            int idx = rowIndex * cols + col;
            matrix.get(idx).multiply(scalar);
        }
    }

    @Override
    public void scaleColumn(int colIndex, Scalar scalar) {
        for (int row = 0; row < rows; row++) {
            int idx = row * cols + colIndex;
            matrix.get(idx).multiply(scalar);
        }
    }
    @Override
    public void addRowMultiple(int targetRow, int sourceRow, Scalar scalar) {
        for (int col = 0; col < cols; col++) {
            int targetIdx = targetRow * cols + col;
            int sourceIdx = sourceRow * cols + col;

            Scalar sourceCopy = matrix.get(sourceIdx).clone();
            sourceCopy.multiply(scalar);
            matrix.get(targetIdx).add(sourceCopy);
        }
    }

    @Override
    public void addColumnMultiple(int targetCol, int sourceCol, Scalar scalar) {
        for (int row = 0; row < rows; row++) {
            int targetIdx = row * cols + targetCol;
            int sourceIdx = row * cols + sourceCol;

            Scalar sourceCopy = matrix.get(sourceIdx).clone();
            sourceCopy.multiply(scalar);
            matrix.get(targetIdx).add(sourceCopy);
        }
    }

    @Override
    public Matrix getRREF() {
        MatrixImpl rref = new MatrixImpl("0", rows, cols);
        BigDecimal[][] data = new BigDecimal[rows][cols];

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                data[i][j] = this.get(i,j).getBigDecimalValue();
            }
        }

        int pivotRow = 0;
        for (int col=0; col<cols && pivotRow<rows; col++) {
            int maxRow = pivotRow;
            for (int i=pivotRow; i<rows; i++) {
                if (data[i][col].abs().compareTo(data[maxRow][col].abs()) > 0) {
                    maxRow = i;
                }
            }
            if (data[maxRow][col].compareTo(BigDecimal.ZERO) == 0) continue;

            BigDecimal[] temp = data[pivotRow];
            data[pivotRow] = data[maxRow];
            data[maxRow] = temp;

            BigDecimal divisor = data[pivotRow][col];
            for (int j=col; j<cols; j++) {
                data[pivotRow][j] = data[pivotRow][j].divide(divisor, 3, RoundingMode.HALF_UP);
            }
            data[pivotRow][col] = BigDecimal.ONE;

            for (int i=0; i<rows; i++) {
                if (i != pivotRow) {
                    BigDecimal factor = data[i][col];
                    for (int j=col; j<cols; j++) {
                        data[i][j] = data[i][j].subtract(factor.multiply(data[pivotRow][j]));
                    }
                }
            }
            pivotRow++;
        }

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (data[i][j].abs().compareTo(new BigDecimal("1E-30")) < 0) {
                    data[i][j] = BigDecimal.ZERO;
                }
            }
        }

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                rref.set(i, j, new ScalarImpl(data[i][j].toString()));
            }
        }
        return rref;
    }

    @Override
    public boolean isRREF() {
        int rowCount = this.getRowCount();
        int colCount = this.getColumnCount();
        int lastCol = -1;

        for (int r = 0; r < rowCount; r++) {
            int pivotCol = -1;
            for (int c = 0; c < colCount; c++) {
                Scalar val = this.get(r, c);
                if (!val.equals(new ScalarImpl("0"))) {
                    pivotCol = c;
                    break;
                }
            }

            if (pivotCol == -1) {
                for (int rr = r + 1; rr < rowCount; rr++) {
                    for (int cc = 0; cc < colCount; cc++) {
                        if (!this.get(rr, cc).equals(new ScalarImpl("0"))) {
                            return false;
                        }
                    }
                }
                break;
            }

            if (pivotCol <= lastCol) {
                return false;
            }
            lastCol = pivotCol;

            if (!this.get(r, pivotCol).equals(new ScalarImpl("1"))) {
                return false;
            }

            for (int rr = 0; rr < rowCount; rr++) {
                if (rr == r) continue;
                if (!this.get(rr, pivotCol).equals(new ScalarImpl("0"))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String determinant() {
        if (rows == 1) {
            return this.get(0,0).get();
        } else if (rows == 2) {
            BigDecimal a = this.get(0,0).getBigDecimalValue();
            BigDecimal b = this.get(0,1).getBigDecimalValue();
            BigDecimal c = this.get(1,0).getBigDecimalValue();
            BigDecimal d = this.get(1,1).getBigDecimalValue();
            BigDecimal det = a.multiply(d).subtract(b.multiply(c));
            return det.toString();
        } else {
            BigDecimal a = this.get(0,0).getBigDecimalValue();
            BigDecimal b = this.get(0,1).getBigDecimalValue();
            BigDecimal c = this.get(0,2).getBigDecimalValue();
            BigDecimal d = this.get(1,0).getBigDecimalValue();
            BigDecimal e = this.get(1,1).getBigDecimalValue();
            BigDecimal f = this.get(1,2).getBigDecimalValue();
            BigDecimal g = this.get(2,0).getBigDecimalValue();
            BigDecimal h = this.get(2,1).getBigDecimalValue();
            BigDecimal i = this.get(2,2).getBigDecimalValue();

            BigDecimal temp1 = a.multiply(e).multiply(i);
            BigDecimal temp2 = b.multiply(f).multiply(g);
            BigDecimal temp3 = c.multiply(d).multiply(h);
            BigDecimal temp4 = c.multiply(e).multiply(g);
            BigDecimal temp5 = b.multiply(d).multiply(i);
            BigDecimal temp6 = a.multiply(f).multiply(h);

            BigDecimal det = temp1.add(temp2).add(temp3).subtract(temp4).subtract(temp5).subtract(temp6);
            return det.toString();
        }
    }

    @Override
    public Matrix inverse() {
        BigDecimal detValue = new BigDecimal(this.determinant());

        MatrixImpl inv = new MatrixImpl("0", rows, cols);
        BigDecimal invDet = BigDecimal.ONE.divide(detValue, 30, RoundingMode.HALF_UP);

        if (rows == 2) {
            BigDecimal temp1 = this.get(0, 0).getBigDecimalValue();
            BigDecimal temp2 = this.get(0, 1).getBigDecimalValue();
            BigDecimal temp3 = this.get(1, 0).getBigDecimalValue();
            BigDecimal temp4 = this.get(1, 1).getBigDecimalValue();

            inv.set(0, 0, new ScalarImpl(temp4.multiply(invDet).stripTrailingZeros().toString()));
            inv.set(0, 1, new ScalarImpl(temp2.negate().multiply(invDet).stripTrailingZeros().toString()));
            inv.set(1, 0, new ScalarImpl(temp3.negate().multiply(invDet).stripTrailingZeros().toString()));
            inv.set(1, 1, new ScalarImpl(temp1.multiply(invDet).stripTrailingZeros().toString()));

            return inv;

        } else {
            BigDecimal[][] m = new BigDecimal[3][3];
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    m[r][c] = this.get(r, c).getBigDecimalValue();
                }
            }

            BigDecimal c00 = m[1][1].multiply(m[2][2]).subtract(m[1][2].multiply(m[2][1]));
            BigDecimal c01 = m[1][0].multiply(m[2][2]).subtract(m[1][2].multiply(m[2][0])).negate();
            BigDecimal c02 = m[1][0].multiply(m[2][1]).subtract(m[1][1].multiply(m[2][0]));

            BigDecimal c10 = m[0][1].multiply(m[2][2]).subtract(m[0][2].multiply(m[2][1])).negate();
            BigDecimal c11 = m[0][0].multiply(m[2][2]).subtract(m[0][2].multiply(m[2][0]));
            BigDecimal c12 = m[0][0].multiply(m[2][1]).subtract(m[0][1].multiply(m[2][0])).negate();

            BigDecimal c20 = m[0][1].multiply(m[1][2]).subtract(m[0][2].multiply(m[1][1]));
            BigDecimal c21 = m[0][0].multiply(m[1][2]).subtract(m[0][2].multiply(m[1][0])).negate();
            BigDecimal c22 = m[0][0].multiply(m[1][1]).subtract(m[0][1].multiply(m[1][0]));

            inv.set(0, 0, new ScalarImpl(c00.multiply(invDet).stripTrailingZeros().toString()));
            inv.set(1, 0, new ScalarImpl(c01.multiply(invDet).stripTrailingZeros().toString()));
            inv.set(2, 0, new ScalarImpl(c02.multiply(invDet).stripTrailingZeros().toString()));

            inv.set(0, 1, new ScalarImpl(c10.multiply(invDet).stripTrailingZeros().toString()));
            inv.set(1, 1, new ScalarImpl(c11.multiply(invDet).stripTrailingZeros().toString()));
            inv.set(2, 1, new ScalarImpl(c12.multiply(invDet).stripTrailingZeros().toString()));

            inv.set(0, 2, new ScalarImpl(c20.multiply(invDet).stripTrailingZeros().toString()));
            inv.set(1, 2, new ScalarImpl(c21.multiply(invDet).stripTrailingZeros().toString()));
            inv.set(2, 2, new ScalarImpl(c22.multiply(invDet).stripTrailingZeros().toString()));

            return inv;
        }
    }
}
