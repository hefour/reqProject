package tensor;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

class ScalarImpl implements Scalar {
    private BigDecimal scalar;

    ScalarImpl(String scalarStringValue) {
       //예외 처리 필요
        this.scalar = new BigDecimal(scalarStringValue);
    }

    ScalarImpl(int minBound, int maxBound) {
        //예외 처리 필요
        double randomValue = minBound + (ThreadLocalRandom.current().nextDouble() * (maxBound - minBound));
        this.scalar = BigDecimal.valueOf(randomValue);
    }

    @Override
    public String getValue() {
        return scalar.toPlainString();
    }

    @Override
    public void setValue(String stringValue) {
        //예외 처리 필요
        this.scalar = new BigDecimal(stringValue);
    }

    @Override
    public void printScalar() {
        System.out.println(scalar.toPlainString());
    }

    @Override
    public String toString() {
        return scalar.toPlainString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ScalarImpl)) return false;
        ScalarImpl other = (ScalarImpl) obj;
        return scalar.compareTo(other.scalar) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scalar.stripTrailingZeros());
    }

    BigDecimal getBigDecimalValue() {
        return scalar;
    }
}
