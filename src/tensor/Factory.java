package tensor;

import java.math.BigDecimal;
import java.util.List;

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
    public static void createMatrix(){
        System.out.println("행렬생성");
        MatrixImpl testMatrix = new MatrixImpl("1, 2, 3, 4\n5, 6, 7, 8");
        testMatrix.printMatrixList();
    }

}
