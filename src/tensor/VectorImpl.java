package tensor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class VectorImpl implements Vector {

    private List<BigDecimal> vector = new ArrayList<>();

    VectorImpl(int dimension, String stringValue) {
        BigDecimal temp = new BigDecimal(stringValue);
        for (int d = 0; d < dimension; d++) {
            vector.add(temp);
        }
    }

    VectorImpl(int dimension, int i, int j) {
        for (int d = 0; d < dimension; d++) {
            ScalarImpl randomValue = new ScalarImpl(i, j);
            vector.add(randomValue.getBigDecimalValue());
        }
    }

    public VectorImpl(BigDecimal[] arrValue) {
        this.vector.addAll(Arrays.asList(arrValue));
    }

    // ==================================☢️공사 중☢️====================================

    @Override
    public Scalar get(int index) {
        if (index < 0 || index >= vector.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + vector.size());
        }
        // BigDecimal → ScalarImpl 변환
        return new ScalarImpl(vector.get(index).toPlainString());
    }

    @Override
    public void set(int index, Scalar value) {
        if (index < 0 || index >= vector.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + vector.size());
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
        vector.set(index, bd);
    }

    @Override
    public int getDimensionCount() {
        return vector.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < vector.size(); i++) {
            sb.append(vector.get(i).toPlainString());
            if (i < vector.size() - 1) {
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
        return Objects.equals(vector, other.vector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vector);
    }

    public void printVector() {
        for (BigDecimal bd : vector) {
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
        return new VectorImpl(3,scalar.toString());
    }

    @Override
    public Vector clone(){
        return new VectorImpl(vector.toArray(new BigDecimal[vector.size()]));
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