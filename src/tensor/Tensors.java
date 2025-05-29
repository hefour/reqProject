package tensor;

public class Tensors {

    public static Scalar addScalarByScalar(Scalar scalar1, Scalar scalar2) {
        return new ScalarImpl("1");         //더미 값
    }

    public static Scalar multiplyScalrByScalar(Scalar scalar1, Scalar scalar2) {
        return new ScalarImpl("4");         //더미 값
    }

    public static Vector addVectorByVector(Vector stringVector, Vector cloneVector) {
        return new VectorImpl(8,"4");  //더미 값
    }

    public static Vector multiplyVectorByScalar(Vector stringVector, Scalar stringScalar) {
        return new VectorImpl(8, "9");  //더미 값
    }

    public static Matrix addMatrixByMatrix(Matrix m1, Matrix m2) {
        return new MatrixImpl("3",2,3);   //더미 값
    }

    public static Matrix multiplyMatrixByMatrix(Matrix m1, Matrix m2) {
        return new MatrixImpl("8",2,3);   //더미 값
    }

    public static Matrix combineToWidthtMatrixByMatrix(Matrix m1, Matrix m2) {
        return new MatrixImpl("3",2,3);   //더미 값
    }

    public static Matrix combineToHeightMatrixByMatrix(Matrix m1, Matrix m2) {
        return new MatrixImpl("4",2,3);   //더미 값
    }
}
