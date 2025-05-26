package tensor;
import tensor.Scalar;
import tensor.Matrix;
public class Tensors {
    public static void validateScalar(Scalar scalar, String input) {
        ScalarImpl expectedScalar = new ScalarImpl(input);
        System.out.println("연산 결과 값은 "+scalar+"입니다.");
        if(expectedScalar.equals(scalar))
            System.out.println("비교 결과 true!");
        else
            System.out.println("비교 결과 false...");
    }
    public static void printScalar(Scalar scalar) {
        System.out.println("현재 생성된 스칼라는 "+scalar.toString()+"입니다. ");

    }
    public static void validateVector(Vector vector,String input) {
        Vector expectedVector = new VectorImpl(vector.size(), input);
        System.out.println("연산 결과 값은 "+ vector+"입니다.");
        if(expectedVector.equals(vector))
            System.out.println("비교 결과 true!");
        else
            System.out.println("비교 결과 false...");

    }

    public static void printVector(Vector vector) {
        System.out.println("현재 생성된 백터는 " +vector.toString() + "입니다. ");
    }
    public static void validateMatrix(Matrix matrix) {

    }

    public static void printMatrix(Matrix matrix) {
        System.out.println("Tensors.printMatrix 호출됨. Matrix 값:");
        if (matrix != null) {
            System.out.println(matrix.toString()); // Matrix 인터페이스의 toString() 호출
        } else {
            System.out.println("null");
        }
    }

    public static void validateMatrix(Matrix matrix, String expectedStateDescription) {
        System.out.println("Tensors.validateMatrix 호출됨.");
        System.out.println("검증 대상 Matrix:\n" + (matrix != null ? matrix.toString() : "null"));
        System.out.println("기대 상태 설명: " + expectedStateDescription);

    }

    public static Matrix add(Matrix m1, Matrix m2) {
        System.out.println("Tensors.add(Matrix, Matrix) 정적 메소드 호출됨.");
        return null;
    }

    public static Matrix multiply(Matrix m1, Matrix m2) {
        System.out.println("Tensors.multiply(Matrix, Matrix) 정적 메소드 호출됨.");
        return null;
    }




}