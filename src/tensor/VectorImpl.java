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
        this.vectorList = new ArrayList<>(dimension);
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
        this.vectorList = new ArrayList<>(dimension);
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
        for (BigDecimal bd : initialValueArray) {
            if (bd == null) {
                throw new IllegalArgumentException("입력 배열에 null 요소가 포함될 수 없습니다.");
            }
            this.vectorList.add(bd);
        }
    }
    @Override
    public Scalar get(int index) {
        if (index >= vectorList.size() || index < 0 ) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + vectorList.size());
        }
        return new ScalarImpl(vectorList.get(index).toPlainString());
    }

    @Override
    public void set(int index, Scalar value) {
        if (index >= vectorList.size() || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + vectorList.size());
        }
        if (value == null) {
            throw new IllegalArgumentException("설정하려는 Scalar 값은 null일 수 없습니다.");
        }
        BigDecimal bd = value.getBigDecimalValue();
        vectorList.set(index, bd);
    }

    @Override
    public int getDimensionCount() {
        return vectorList.size();
    }

    @Override
    public String toString() {
        StringBuilder bui = new StringBuilder();
        bui.append("[");
        for (int i = 0; i < vectorList.size(); i++) {
            bui.append(vectorList.get(i).toPlainString());
            if (i < vectorList.size() - 1) {
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
        if (this.getDimensionCount() != other.getDimensionCount()) {
            throw new IllegalArgumentException("두 벡터의 길이가 다릅니다.");
        }

        BigDecimal[] result = new BigDecimal[this.getDimensionCount()];
        for (int i = 0; i < this.getDimensionCount(); i++) {
            BigDecimal a = vectorList.get(i);
            BigDecimal b = other.get(i).getBigDecimalValue();
            result[i] = a.add(b);
        }
        return new VectorImpl(result);
    }

    @Override
    public Vector multiply(Scalar scalar){
        BigDecimal scalarValue = scalar.getBigDecimalValue();
        BigDecimal[] result = new BigDecimal[getDimensionCount()];
        for (int i = 0; i < this.getDimensionCount(); i++) {
            result[i] = vectorList.get(i).multiply(scalarValue);
        }
        return new VectorImpl(result);
    }
    @Override
    public Vector clone(){
        return new VectorImpl(vectorList.toArray(new BigDecimal[vectorList.size()]));
    }

    @Override
    public Matrix toColumnMatrix() {
        Scalar[][] data = new Scalar[this.getDimensionCount()][1];
        for (int i = 0; i < this.getDimensionCount(); i++) {
            data[i][0] = new ScalarImpl(vectorList.get(i).toPlainString());
        }
        return new MatrixImpl(data);
    }

    @Override
    public Matrix toRowMatrix() {
        Scalar[][] data = new Scalar[1][this.getDimensionCount()];
        for (int i = 0; i < this.getDimensionCount(); i++) {
            data[0][i] = new ScalarImpl(vectorList.get(i).toPlainString());
        }
        return new MatrixImpl(data);
    }

}