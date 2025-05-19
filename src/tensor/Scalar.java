package tensor;

import java.math.BigDecimal;

public interface Scalar {
  //12
    String getValue();
    void setValue(String value);

 //14
    @Override
    String toString();

 //15
    @Override
    boolean equals(Object obj);
 //18
    void plusScalar(Scalar scalar);
 //19
    void multiplyScalar(Scalar scalar);

    void printScalar();
    BigDecimal getBigDecimalValue();

}