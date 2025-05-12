package tensor;
import java.math.BigDecimal;

public class ScalarImpl implements Scalar {

    public BigDecimal makeScalar(String customScalar){
        return new BigDecimal(customScalar);
        //문자열 넣으면 NumberFormatException 발생
    }
    public BigDecimal makeScalar(int i, int j) {
        return new BigDecimal(Math.random()*(j-i)+i);
    }

}




