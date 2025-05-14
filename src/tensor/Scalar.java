    package tensor;
    import java.math.BigDecimal;
    public interface Scalar {
        BigDecimal makeScalar(int minValue, int maxValue); // 1번
        BigDecimal makeScalar(String s); // 2번
    }
