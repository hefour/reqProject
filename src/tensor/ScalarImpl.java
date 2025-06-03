package tensor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Random;

class ScalarImpl implements Scalar,Comparable<Scalar>{

    private BigDecimal scalar;

    ScalarImpl(String stringValue) {
        this.scalar = new BigDecimal(stringValue);
    }

    ScalarImpl(int i, int j) {
        Random random = new Random();
        double randomValue = i + random.nextDouble() * (j - i);
        this.scalar = BigDecimal.valueOf(randomValue).setScale(4, RoundingMode.HALF_UP);
    }

    @Override
    public String get() {
        return scalar.toString();
    }

    @Override
    public void set(String setValue) {
        this.scalar = new BigDecimal(setValue);
    }

    @Override
    public String toString() {
        return scalar.toString();
    }

    @Override
    public boolean equals(Object compare) {
        if (this == compare) return true;
        if (!(compare instanceof ScalarImpl other)) return false;
        return Objects.equals(this.scalar, other.scalar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scalar);
    }

    @Override
    public void add(Scalar opScalar) {
        this.scalar = this.scalar.add(opScalar.getBigDecimalValue());
    }

    //16번
    @Override
    public int compareTo(Scalar opScalar) {
        return this.scalar.compareTo(opScalar.getBigDecimalValue());
    }

    //17번
    @Override
    public Scalar clone(){
        return new ScalarImpl(this.get());
    }

    public void multiply(Scalar opScalar) {
        this.scalar = this.scalar.multiply(opScalar.getBigDecimalValue());
    }

    public BigDecimal getBigDecimalValue() {
        return scalar;
    }
}
