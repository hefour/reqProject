package test;
import tensor.Scalar;

import static tensor.Factory.*;

public class Test {
    public static void main(String[] args) {
        Scalar a=createScalarByRandom(1,2);
        a.printScalar();
        //createVector();
        //createMatrix();
    }
}
