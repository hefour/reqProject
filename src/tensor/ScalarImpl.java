package tensor;

import java.math.BigDecimal;
import java.security.SecureClassLoader;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

class ScalarImpl implements Scalar,Comparable<Scalar>{
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
    ScalarImpl(double testValue) {
        this.scalar = BigDecimal.valueOf(testValue);
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
    @Override
    public void plusScalar(Scalar scalar) {
        this.scalar=this.scalar.add(scalar.getBigDecimalValue());
    }
    //16번
    @Override
    public int compareTo(Scalar other) {
        return this.scalar.compareTo(other.getBigDecimalValue());
    }
    //17번
    @Override
    public Scalar clone(){
        return new ScalarImpl(this.getValue());
    }

    public void multiplyScalar(Scalar scalar) {
        this.scalar=this.scalar.multiply(scalar.getBigDecimalValue());
    }
    // BigDecimal을 많이 쓸거같아서 인터페이스에 추가하고 public으로 수정했습니다. -장준하
    public BigDecimal getBigDecimalValue() {
        return scalar;
    }


}