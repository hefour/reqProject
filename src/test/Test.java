package test;

import tensor.Scalar;
import tensor.Vector;
import tensor.Matrix;

import static tensor.Factory.*;

public class Test {
    public static void main(String[] args) {

        Scalar a = createScalarByRandom(1, 2);
        System.out.print("생성된 스칼라 값: ");
        a.printScalar();

    }
}
