package tensor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Random;

class ScalarImpl implements Scalar,Comparable<Scalar>{

    private BigDecimal scalar;

    ScalarImpl(String stringNum) {
        this.scalar = new BigDecimal(stringNum);
    }

    ScalarImpl(int i, int j) {
        Random rand = new Random();
        double randomValue = i + rand.nextDouble() * (j - i);
        this.scalar = BigDecimal.valueOf(randomValue).setScale(4, RoundingMode.HALF_UP);
    }
// ==================================☢️공사 중☢️====================================
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
    // BigDecimal을 많이 쓸거같아서 인터페이스에 추가하고 public으로 수정했습니다. -장준하
    public BigDecimal getBigDecimalValue() {
        return scalar;
    }


}