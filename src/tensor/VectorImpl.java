package tensor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class VectorImpl implements Vector {

    private final List<BigDecimal> vectorList;

    VectorImpl(int dimension, String valueString) {
        if (dimension < 0) {
            throw new IllegalArgumentException("벡터의 차원(dimension)은 0 이상이어야 합니다.");
        }
        this.vectorList = new ArrayList<>(dimension);
        ScalarImpl prototype = new ScalarImpl(valueString);
        BigDecimal base = prototype.getBigDecimalValue();
        for (int i = 0; i < dimension; i++) {
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


    VectorImpl(List<BigDecimal> initialValueList) {
        if (initialValueList == null) {
            throw new IllegalArgumentException("입력 리스트는 null일 수 없습니다.");
        }
        // 요소 복사
        this.vectorList = new ArrayList<>(initialValueList);
        for (BigDecimal bd : vectorList) {
            if (bd == null) {
                throw new IllegalArgumentException("입력 리스트에 null 요소가 포함될 수 없습니다.");
            }
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
            bd = new BigDecimal(value.getValue());
        }
        vectorList.set(index, bd);
    }

    @Override
    public int size() {
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
}