package tensor;

public class DimensionMismatchException extends TensorException {
    public DimensionMismatchException(String message) {
        super("차원 불일치: " + message);
    }
}
