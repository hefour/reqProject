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

    @Override
    public Scalar get(int index) {
        return new ScalarImpl(vector.get(index).toString());
    }

    @Override
    public void set(int index, Scalar setValue) {
        BigDecimal bd = new BigDecimal(setValue.get().strip());
        vector.set(index, bd);
    }

    @Override
    public int getDimensionCount() {
        return vector.size();
    }

    @Override
    public String toString() {
        String[] parts = new String[vector.size()];

        for (int i = 0; i < vector.size(); i++) {
            parts[i] = vector.get(i).toString();
        }

        return "[" + String.join(", ", parts) + "]";
    }

    @Override
    public boolean equals(Object compare) {
        if (this == compare) return true;
        if (!(compare instanceof VectorImpl other)) return false;
        
        return Objects.equals(this.vector, other.vector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vector);
    }

    @Override
    public Vector add(Vector opVector) {
        for (int i = 0; i < this.getDimensionCount(); i++) {
            vector.set(i, vector.get(i).add(opVector.get(i).getBigDecimalValue()));
        }

        return this;
    }

    @Override
    public Vector multiply(Scalar opScalar) {
        BigDecimal opValue = opScalar.getBigDecimalValue();
        
        for (int i = 0; i < this.getDimensionCount(); i++) {
            vector.set(i, vector.get(i).multiply(opValue));
        }
        
        return this;
    }

    public static Vector add(Vector v1, Vector v2) {
        BigDecimal[] result = new BigDecimal[v1.getDimensionCount()];

        for (int i = 0; i < v1.getDimensionCount(); i++) {
            BigDecimal indexValue1 = new BigDecimal(v1.get(i).get());
            BigDecimal indexValue2 = new BigDecimal(v2.get(i).get());
            result[i] = indexValue1.add(indexValue2);
        }

        return new VectorImpl(result);
    }

    public static Vector multiply(Vector vector, Scalar opScalar) {
        BigDecimal opValue = opScalar.getBigDecimalValue();
        BigDecimal[] result = new BigDecimal[vector.getDimensionCount()];

        for (int i = 0; i < vector.getDimensionCount(); i++) {
            BigDecimal indexValue = new BigDecimal(vector.get(i).get());
            result[i] = indexValue.multiply(opValue);
        }

        return new VectorImpl(result);
    }

    @Override
    public Vector clone() {
        BigDecimal[] copyArr = new BigDecimal[this.getDimensionCount()];
        for (int i = 0; i < this.getDimensionCount(); i++) {
            copyArr[i] = vector.get(i);
        }
        return new VectorImpl(copyArr);
    }

    @Override
    public Matrix toColumnMatrix() {
        Scalar[][] thisData = new Scalar[this.getDimensionCount()][1];
        for (int i = 0; i < this.getDimensionCount(); i++) {
            thisData[i][0] = this.get(i);
        }
        return new MatrixImpl(thisData);
    }

    @Override
    public Matrix toRowMatrix() {
        Scalar[][] thisData = new Scalar[1][this.getDimensionCount()];
        for (int i = 0; i < this.getDimensionCount(); i++) {
            thisData[0][i] = this.get(i);
        }
        return new MatrixImpl(thisData);
    }
}
