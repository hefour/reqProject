package tensor;

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

    void printScalar();


}