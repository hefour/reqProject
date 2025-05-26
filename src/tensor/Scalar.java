
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
    //16
    int compareTo(Scalar other);
    //17
    Scalar clone();

    //18
    void plusScalar(Scalar scalar);
    //19
    void multiplyScalar(Scalar scalar);
    //24
    static Scalar plusTwoScalars(Scalar scalar1, Scalar scalar2){
        return new ScalarImpl(scalar1.getBigDecimalValue().add(scalar2.getBigDecimalValue()).toPlainString());
    };
    //25
    static Scalar multiplyTwoScalars(Scalar scalar1, Scalar scalar2){
        return new ScalarImpl(scalar1.getBigDecimalValue().multiply(scalar2.getBigDecimalValue()).toPlainString());
    };


    void printScalar();
    BigDecimal getBigDecimalValue();

}
