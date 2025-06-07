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
        double randomValue = ThreadLocalRandom.current().nextDouble(minBound,maxBound);
        this.scalar = BigDecimal.valueOf(randomValue);
    }

    @Override
    public String get() {
        return scalar.toPlainString();
    }

    @Override
    public void set(String stringValue) {
        //예외 처리 필요
        this.scalar = new BigDecimal(stringValue);
    }

    @Override
    public String toString() {
        return scalar.stripTrailingZeros().toPlainString();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj==null || getClass()!=obj.getClass()) return false;
        ScalarImpl other = (ScalarImpl) obj;
        return scalar.compareTo(other.scalar) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(scalar.stripTrailingZeros());
    }

    @Override
    public void add(Scalar scalar) {
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
        return new ScalarImpl(this.get());
    }

    public void multiply(Scalar scalar) {
        this.scalar=this.scalar.multiply(scalar.getBigDecimalValue());
    }

    public BigDecimal getBigDecimalValue() {
        return scalar;
    }

    static Scalar add(Scalar scalar1, Scalar scalar2) {
        BigDecimal s1=scalar1.getBigDecimalValue();
        BigDecimal s2=scalar2.getBigDecimalValue();
        return new ScalarImpl(s1.add(s2).toPlainString());
    }

    static Scalar multiply(Scalar scalar1, Scalar scalar2) {
        BigDecimal s1=scalar1.getBigDecimalValue();
        BigDecimal s2=scalar2.getBigDecimalValue();
        return new ScalarImpl(s1.multiply(s2).toPlainString());
    }


}