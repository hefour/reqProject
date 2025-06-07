package tensor;

public class Tensors {

    public static Scalar addScalarByScalar(Scalar scalar1, Scalar scalar2) {
        return ScalarImpl.add(scalar1, scalar2);
    }

    public static Scalar multiplyScalarByScalar(Scalar scalar1, Scalar scalar2) {
        return ScalarImpl.multiply(scalar1,scalar2);
    }

    public static Vector addVectorByVector(Vector stringVector, Vector cloneVector) {
        return VectorImpl.add(stringVector,cloneVector);
    }

    public static Vector multiplyVectorByScalar(Vector stringVector, Scalar stringScalar) {
        return VectorImpl.multiply(stringVector, stringScalar);
    }

    public static Matrix addMatrixByMatrix(Matrix m1, Matrix m2) {
        return new MatrixImpl("3",2,3);   //더미 값
    }

    public static Matrix multiplyMatrixByMatrix(Matrix m1, Matrix m2) {
        return new MatrixImpl("8",2,3);   //더미 값
    }

    public static Matrix combineToWidthMatrixByMatrix(Matrix m1, Matrix m2) {
        return new MatrixImpl("3",2,3);   //더미 값
    }

    public static Matrix combineToHeightMatrixByMatrix(Matrix m1, Matrix m2) {
        return new MatrixImpl("4",2,3);   //더미 값
    }
}
