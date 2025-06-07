package tensor;

public class Tensors {

    public static Scalar addScalarByScalar(Scalar scalar1, Scalar scalar2) {
        return ScalarImpl.add(scalar1, scalar2);     //더미 값
    }

    public static Scalar multiplyScalrByScalar(Scalar scalar1, Scalar scalar2) {
        return ScalarImpl.multiply(scalar1, scalar2);    //더미 값
    }

    public static Vector addVectorByVector(Vector stringVector, Vector cloneVector) {
        return VectorImpl.add(stringVector, cloneVector);
    }

    public static Vector multiplyVectorByScalar(Vector stringVector, Scalar stringScalar) {
        return VectorImpl.multiply(stringVector, stringScalar);
    }

    public static Matrix addMatrixByMatrix(Matrix m1, Matrix m2) {
        return MatrixImpl.add(m1,m2); //더미 값
    }

    public static Matrix multiplyMatrixByMatrix(Matrix m1, Matrix m2) {
        return MatrixImpl.multiply(m1,m2); //더미 값
    }

    public static Matrix combineToWidthtMatrixByMatrix(Matrix m1, Matrix m2) {
        return MatrixImpl.widthPaste(m1,m2);
    }

    public static Matrix combineToHeightMatrixByMatrix(Matrix m1, Matrix m2) {
        return MatrixImpl.heightPaste(m1,m2);
    }
}
