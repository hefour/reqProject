package test;

import tensor.Factory;
import tensor.Scalar;
import tensor.Vector;
import tensor.Matrix;
import tensor.Tensors;

import static tensor.Factory.*;

public class Test {
    public static void main(String[] args) {
        System.out.println("01. String 값을 지정하여 스칼라를 생성할 수 있다");
        Scalar stringScalar = createScalarByString("3");  // 01.
        Tensors.printScalar(stringScalar);
        System.out.println();

        System.out.println("02. i이상 j미만의 무작위 값을 요소로 하는 스칼라를 생성할 수 있다.");
        Scalar randomScalar = createScalarByRandom(1, 2);          // 02.
        Tensors.printScalar(randomScalar);
        System.out.println();

        System.out.println("12.스칼라 값을 지정/조회할 수 있다");
        System.out.println("스칼라 값을 5로 지정합니다.");
        stringScalar.setValue("5");
        System.out.println("지정 후 조회한 스칼라 값 : "+stringScalar.toString());
        System.out.println();

        System.out.println("14.스칼라 객체를 콘솔에 출력할 수 있다.");
        System.out.println("출력 스칼라 값 : "+stringScalar.toString());
        System.out.println();

        System.out.println("15. 스칼라 객체의 동등성 판단을 할 수 있다.");
        System.out.println("비교 스칼라 1 : "+stringScalar.toString());
        System.out.println("비교 스칼라 2 : "+randomScalar.toString());
        System.out.println(stringScalar.equals(randomScalar)? "일치!" : "불일치..");

        System.out.println("18. 스칼라는 다른 스칼라와 덧셈이 가능하다.");
        Scalar testScalar = createScalarByString("2");
        System.out.println("기존 스칼라 : "+stringScalar.toString());
        System.out.println("더한 스칼라 : "+testScalar.toString());
        stringScalar.plusScalar(testScalar);
        Tensors.validateScalar(stringScalar,"7");
        System.out.println();

        System.out.println("19. 스칼라는 다른 스칼라와 곱셈이 가능하다.");
        System.out.println("기존 스칼라 : "+stringScalar.toString());
        System.out.println("곱한 스칼라 : "+testScalar.toString());
        stringScalar.multiplyScalar(testScalar);
        Tensors.validateScalar(stringScalar,"14");

        System.out.println("24. 전달받은 두 스칼라의 덧셈이 가능하다. ");

        System.out.println("스칼라 1 : "+stringScalar.toString());
        System.out.println("스칼라 2 : "+testScalar.toString());
        Scalar resultScalar=Scalar.plusTwoScalars(stringScalar,testScalar);
        Tensors.validateScalar(resultScalar,"16");

        System.out.println("25. 전달받은 두 스칼라의 곱셈이 가능하다. ");
        System.out.println("스칼라 1 : "+stringScalar.toString());
        System.out.println("스칼라 2 : "+testScalar.toString());
        resultScalar=Scalar.multiplyTwoScalars(stringScalar,testScalar);
        Tensors.validateScalar(resultScalar,"28");



    }
}
