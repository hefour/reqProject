package tensor;
import java.math.BigDecimal;
public interface Scalar {
    BigDecimal makeScalar(int i, int j);
    BigDecimal makeScalar(String s);
}
