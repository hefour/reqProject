package tensor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VectorImpl implements Vector {
    ScalarImpl scalar = new ScalarImpl();
    public List<BigDecimal> makeVector(int n, int i, int j) {
        List<BigDecimal> vectorList = new ArrayList<>();
        for(int k=0;k<n;k++) {
            BigDecimal a = scalar.makeScalar(i, j);
            vectorList.add(a);
        }
        return vectorList;
    }
    public List<BigDecimal> makeVector(int n, String a) {
        List<BigDecimal> vectorList = new ArrayList<>();
        for(int k=0;k<n;k++) {
            BigDecimal b = scalar.makeScalar(a);
            vectorList.add(b);
        }
        return vectorList;
    }
    public List<BigDecimal> makeVector(List<BigDecimal> a) {
        return new ArrayList<>(a);
    }

}
