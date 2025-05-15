package tensor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VectorImpl implements Vector {
    private List<BigDecimal> vectorList= new ArrayList<>();
    // 3번
    VectorImpl(int dimension,String valueString) {
        for (int index = 0; index < dimension; index++) {
            ScalarImpl scalar = new ScalarImpl(valueString);
            BigDecimal elementValue = scalar.getScalar();
            vectorList.add(elementValue);
        }
    }
    // 4번
    VectorImpl(int dimension, int minBound, int maxBound) {
        for(int index=0; index<dimension;index++){
            ScalarImpl scalar = new ScalarImpl(minBound, maxBound);
            BigDecimal randomScalarValue = scalar.getScalar();
            vectorList.add(randomScalarValue);
        }
    }
    // 5번
    VectorImpl(List<BigDecimal> valueList) {
            vectorList=new ArrayList<>(valueList);
    }

    @Override
    public void printVector() {
        for (BigDecimal bigDecimal : vectorList) {
            System.out.println(bigDecimal + " ");
        }
    }

}
