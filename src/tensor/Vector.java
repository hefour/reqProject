package tensor;

import java.math.BigDecimal;
import java.util.List;

public interface Vector {
    public List<BigDecimal> makeVector(int dimension, int minBound, int maxBound); // 3번
    public List<BigDecimal> makeVector(int dimension, String a); // 4번
    public List<BigDecimal> makeVector(List<BigDecimal> a); // 5번
}
