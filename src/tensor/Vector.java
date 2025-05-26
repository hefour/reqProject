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

    //17
    Vector clone();

    Vector add(Vector other);

    Vector multiply(Scalar scalar);

    static Vector addTwoVector(Vector one, Vector other){
        return one.add(other);
    }
    static Vector multiplyScalar(Vector vector, Scalar scalar){
        return vector.multiply(scalar);
    }

    Matrix toColumnMatrix();

    Matrix toRowMatrix();
}