package tensor;
import java.math.BigDecimal;
import java.util.Random;

public class ScalarImpl implements Scalar {
    private BigDecimal scalar;
    ScalarImpl(String scalarStringValue){
        scalar = new BigDecimal(scalarStringValue);
        //문자열 넣으면 NumberFormatException 발생
    }
    ScalarImpl(int minBound, int maxBound){
     scalar = new BigDecimal(Math.random()*(maxBound-minBound)+minBound);
    }
    ScalarImpl(){}

    @Override
    public void printScalar() {
        System.out.println(scalar);
    }
    public BigDecimal getScalar() {
        return scalar;
    }
}




