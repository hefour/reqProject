package tensor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class VectorImpl implements Vector {

    private final List<BigDecimal> vectorList;

    VectorImpl(int dimension, String valueString) {
        if (dimension < 0) {
            throw new IllegalArgumentException("벡터의 차원(dimension)은 0 이상이어야 합니다.");
        }
        vectorList = new ArrayList<>(dimension);
        ScalarImpl basement = new ScalarImpl(valueString);
        for (int i = 0; i < dimension; i++) {
            BigDecimal num = basement.getBigDecimalValue();
            vectorList.add(num);
        }
    }


    VectorImpl(int dimension, int minBound, int maxBound) {
        if (dimension < 0) {
            throw new IllegalArgumentException("벡터의 차원(dimension)은 0 이상이어야 합니다.");
        }
        vectorList = new ArrayList<>(dimension);
        for (int i = 0; i < dimension; i++) {
            ScalarImpl random = new ScalarImpl(minBound, maxBound);
            vectorList.add(random.getBigDecimalValue());
        }
    }

    public VectorImpl(BigDecimal[] initialValueArray) {
        if (initialValueArray == null) {
            throw new IllegalArgumentException("입력 배열은 null일 수 없습니다.");
        }

        vectorList = new ArrayList<>(initialValueArray.length);
        for (BigDecimal v : initialValueArray) {
            if (v == null) {
                throw new IllegalArgumentException("입력 배열에 null 요소가 포함될 수 없습니다.");
            }
            this.vectorList.add(v);
        }
    }
    @Override
    public Scalar get(int index) {
        if ( index < 0  || index >= vectorList.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + vectorList.size());
        }
        return new ScalarImpl(vectorList.get(index).toPlainString());
    }

    @Override
    public void set(int index, Scalar value) {
        if ( index < 0  || index >= vectorList.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + vectorList.size());
        }
        if (value == null) {
            throw new IllegalArgumentException("설정하려는 Scalar 값은 null일 수 없습니다.");
        }
        vectorList.set(index, value.getBigDecimalValue());
    }

    @Override
    public int getDimensionCount() {
        return vectorList.size();
    }

    @Override
    public String toString() {
        StringBuilder bui = new StringBuilder("[");
        for (int i = 0; i < vectorList.size(); i++) {
            bui.append(vectorList.get(i).stripTrailingZeros().toPlainString());
            if (i != vectorList.size() - 1) {
                bui.append(", ");
            }
        }
        bui.append("]");
        return bui.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        VectorImpl other = (VectorImpl) obj;
        return Objects.equals(vectorList, other.vectorList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vectorList);
    }

    @Override
    public Vector add(Vector other) {
        int n=getDimensionCount();
        if (n != other.getDimensionCount()) {
            throw new IllegalArgumentException("두 벡터의 길이가 다릅니다.");
        }
        for (int i = 0; i < n; i++) {
            BigDecimal sum = vectorList.get(i).add(other.get(i).getBigDecimalValue());
            vectorList.set(i, sum);
        }
        return this;
    }

    @Override
    public Vector multiply(Scalar scalar){
        BigDecimal sv = scalar.getBigDecimalValue();
        int n=getDimensionCount();
        for (int i = 0; i < n; i++) {
            BigDecimal mul = vectorList.get(i).multiply(sv);
            vectorList.set(i, mul);
        }
        return this;
    }
    @Override
    public Vector clone(){
        BigDecimal[] copy = vectorList.toArray(new BigDecimal[0]);
        return new VectorImpl(copy);
    }

    @Override
    public Matrix toColumnMatrix() {
        int n=getDimensionCount();
        Scalar[][] column = new Scalar[n][1];
        for (int i = 0; i < n; i++) {
            column[i][0] = new ScalarImpl(vectorList.get(i).toPlainString());
        }
        return new MatrixImpl(column);
    }

    @Override
    public Matrix toRowMatrix() {
        int n=getDimensionCount();
        Scalar[][] row = new Scalar[1][n];
        for (int i = 0; i < n; i++) {
            row[0][i] = new ScalarImpl(vectorList.get(i).toPlainString());
        }
        return new MatrixImpl(row);
    }

    static Vector add(Vector v1, Vector v2) {
        int n=v1.getDimensionCount();
        if (n != v2.getDimensionCount()) {
            throw new IllegalArgumentException("두 벡터의 길이가 다릅니다.");
        }
        BigDecimal[] res=new BigDecimal[n];
        for (int i = 0; i < n; i++) {
            BigDecimal sum = v1.get(i).getBigDecimalValue().add(v2.get(i).getBigDecimalValue());
            res[i] = sum;
        }
        return new VectorImpl(res);
    }

    static Vector multiply(Vector v1, Scalar s1) {
        int n=v1.getDimensionCount();
        BigDecimal sv=s1.getBigDecimalValue();
        BigDecimal[] res=new BigDecimal[n];
        for (int i = 0; i < n; i++) {
            BigDecimal mul = v1.get(i).getBigDecimalValue().multiply(sv);
            res[i] = mul;
        }
        return new VectorImpl(res);
    }
}