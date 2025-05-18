package tensor;

public interface Vector {
//11
    Scalar get(int index);
    void set(int index, Scalar value);

//13
    int size();

//14
    @Override
    String toString();

    @Override
    boolean equals(Object obj);

}