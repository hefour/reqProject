package tensor;
import java.math.BigDecimal;
import java.util.Random;

public class ScalarImpl implements Scalar {

    public BigDecimal makeScalar(String scalarStringValue){
        return new BigDecimal(scalarStringValue);
        //문자열 넣으면 NumberFormatException 발생
    }
    public BigDecimal makeScalar(int minBound, int maxBound) {
        return new BigDecimal(Math.random()*(maxBound-minBound)+minBound);
    }

}




