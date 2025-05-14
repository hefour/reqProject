package tensor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VectorImpl implements Vector {
    ScalarImpl scalar = new ScalarImpl();
    public List<BigDecimal> makeVector(int dimension, int minBound, int maxBound) {
        List<BigDecimal> vectorList = new ArrayList<>();
        for(int index=0;index<dimension;index++) {
            BigDecimal randomScalarValue = scalar.makeScalar(minBound, maxBound);
            vectorList.add(randomScalarValue);
        }
        return vectorList;
    }
    public List<BigDecimal> makeVector(int dimension, String valueString) {
        List<BigDecimal> vectorList = new ArrayList<>();
        for(int index=0;index<dimension; index++) {
            BigDecimal elementValue = scalar.makeScalar(valueString);
            vectorList.add(elementValue);
        }
        return vectorList;
    }
    public List<BigDecimal> makeVector(List<BigDecimal> valueList) {
        return new ArrayList<>(valueList);
    }

}
