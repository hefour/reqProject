package tensor;

import java.math.BigDecimal;
import java.util.List;

public interface Vector {
    public List<BigDecimal> makeVector(int n, int i, int j); // 3번
    public List<BigDecimal> makeVector(int n, String a); // 4번
    public List<BigDecimal> makeVector(List<BigDecimal> a); // 5번
}
