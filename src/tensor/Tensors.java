package tensor;
import tensor.Scalar;
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

}