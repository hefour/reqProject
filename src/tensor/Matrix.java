package tensor;

public interface Matrix {
    //11
    Scalar get(int rowIndex, int colIndex);
    void set(int rowIndex, int colIndex, Scalar value);

    //13
    int getRowCount();
    int getColumnCount();

    //14
    @Override
    String toString();
    //15
    @Override
    boolean equals(Object obj);

    //17
    Matrix clone();

}