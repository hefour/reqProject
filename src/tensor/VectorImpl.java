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
        BigDecimal[] result = new BigDecimal[this.getDimensionCount()];
        
        for (int i = 0; i < this.getDimensionCount(); i++) {
            result[i] = this.get(i).getBigDecimalValue().add(opVector.get(i).getBigDecimalValue());
        }
        return new VectorImpl(result);
    }

    @Override
    public Vector multiply(Scalar opScalar) {
        BigDecimal opValue = opScalar.getBigDecimalValue();
        
        for (int i = 0; i < this.getDimensionCount(); i++) {
            vector.set(i, vector.get(i).multiply(opValue));
        }
        
        return this;
    }

    @Override
    public Vector clone() {
        BigDecimal[] copyArray = new BigDecimal[this.getDimensionCount()];
        for (int i = 0; i < this.getDimensionCount(); i++) {
            copyArray[i] = vector.get(i);
        }
        return new VectorImpl(copyArray);
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
