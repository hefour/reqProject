package tensor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


class VectorImpl implements Vector {

    private final List<BigDecimal> vectorList;

    VectorImpl(int dimension, String valueString) {
        if (dimension < 0) {
            throw new IllegalArgumentException("벡터의 차원(dimension)은 0 이상이어야 합니다.");
        }
        this.vectorList = new ArrayList<>(dimension);
        ScalarImpl prototype = new ScalarImpl(valueString);
        for (int i = 0; i < dimension; i++) {
            BigDecimal base = prototype.getBigDecimalValue();
            vectorList.add(base);
        }
    }


    VectorImpl(int dimension, int minBound, int maxBound) {
        if (dimension < 0) {
            throw new IllegalArgumentException("벡터의 차원(dimension)은 0 이상이어야 합니다.");
        }
        this.vectorList = new ArrayList<>(dimension);
        for (int i = 0; i < dimension; i++) {
            // ScalarImpl 로 랜덤 생성 후 BigDecimal 값만 보관
            ScalarImpl rand = new ScalarImpl(minBound, maxBound);
            vectorList.add(rand.getBigDecimalValue());
        }
    }

    public VectorImpl(BigDecimal[] initialValueArray) {
        if (initialValueArray == null) {
            throw new IllegalArgumentException("입력 배열은 null일 수 없습니다.");
        }

        this.vectorList = new ArrayList<>();
        for (BigDecimal bd : initialValueArray) {
            if (bd == null) {
                throw new IllegalArgumentException("입력 배열에 null 요소가 포함될 수 없습니다.");
            }
            this.vectorList.add(bd);
        }
    }
    @Override
    public Scalar get(int index) {
        if (index < 0 || index >= vectorList.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + vectorList.size());
        }
        // BigDecimal → ScalarImpl 변환
        return new ScalarImpl(vectorList.get(index).toPlainString());
    }

    @Override
    public void set(int index, Scalar value) {
        if (index < 0 || index >= vectorList.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + vectorList.size());
        }
        if (value == null) {
            throw new IllegalArgumentException("설정하려는 Scalar 값은 null일 수 없습니다.");
        }
        // Scalar → BigDecimal
        BigDecimal bd;
        if (value instanceof ScalarImpl) {
            bd = ((ScalarImpl) value).getBigDecimalValue();
        } else {
            bd = new BigDecimal(value.get());
        }
        vectorList.set(index, bd);
    }

    @Override
    public int getDimensionCount() {
        return vectorList.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < vectorList.size(); i++) {
            sb.append(vectorList.get(i).toPlainString());
            if (i < vectorList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
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

    public void printVector() {
        for (BigDecimal bd : vectorList) {
            System.out.print(bd.toPlainString() + " ");
        }
        System.out.println();
    }

    @Override
    public Vector add(Vector other) {
        if (this.getDimensionCount() != other.getDimensionCount()) {
            throw new IllegalArgumentException("두 벡터의 길이가 다릅니다.");
        }

        BigDecimal[] result = new BigDecimal[this.getDimensionCount()];
        for (int i = 0; i < this.getDimensionCount(); i++) {
            BigDecimal a = new BigDecimal(this.get(i).get());
            BigDecimal b = new BigDecimal(other.get(i).get());
            result[i] = a.add(b);
        }
        return new VectorImpl(result);
    }

    @Override
    public Vector multiply(Scalar scalar){
        return this;
    }
    @Override
    public Vector clone(){
        return new VectorImpl(vectorList.toArray(new BigDecimal[vectorList.size()]));
    }

    @Override
    public Matrix toColumnMatrix() {
        Scalar[][] data = new Scalar[this.getDimensionCount()][1];
        for (int i = 0; i < this.getDimensionCount(); i++) {
            data[i][0] = this.get(i);
        }
        return new MatrixImpl(data);
    }

    @Override
    public Matrix toRowMatrix() {
        Scalar[][] data = new Scalar[1][this.getDimensionCount()];
        for (int i = 0; i < this.getDimensionCount(); i++) {
            data[0][i] = this.get(i);
        }
        return new MatrixImpl(data);
    }

}