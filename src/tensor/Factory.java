package tensor;

import java.math.BigDecimal;

public class Factory {

    public static void createScalar(){
        System.out.println("스칼라생성");
        ScalarImpl test = new ScalarImpl();
        BigDecimal ab = test.makeScalar(3,6);
        System.out.println(ab);
    }
    public static Vector createVector(){
        System.out.println("벡터생성");
        return new VectorImpl();
    }
    public static Matrix createMatrix(){
        System.out.println("행렬생성");
        return new MatrixImpl();
    }

}
