package test;

import tensor.*;

import java.math.BigDecimal;

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

        System.out.println("03. 지정한 하나의 값을 모든 요소의 값으로 하는 차원 벡터를 생성할 수 있다.");
        Vector stringVector = createVectorByString(8,"3");  // 01.
        Tensors.printVector(stringVector);
        System.out.println();

        System.out.println("04. i 이상 j 미만의 무작위 값을 요소로 하는 차원 벡터를 생성할 수 있다04.");
        Vector randomVector = createVectorByRandom(2,1, 2);  // 01.
        Tensors.printVector(randomVector);
        System.out.println();

        System.out.println("05. 차원 배열로부터 차원 벡터를 생성할 수 있다.");
        BigDecimal[] arr = {
                new BigDecimal("3"),
                new BigDecimal("5"),
                new BigDecimal("8")
        };
        Vector arrVector = createVectorByArray(arr);
        Tensors.printVector(arrVector);
        System.out.println();

        System.out.println("11v. 특정 위치의 요소를 지정조회할 수 있다.");
        int index = 2; // 0-based index (즉, 3번째 요소)
        Scalar indexValue = stringVector.get(index);
        System.out.println("벡터의 " + (index + 1) + "번째 요소는 " + indexValue.getValue());
        System.out.println();

        System.out.println("13v. 크기 정보를 조회할 수 있다");
        System.out.println("03 에서 생성한 벡터의 크기 정보(차원)을 조회합니다");
        System.out.println("03 에서 생성한 벡터의 차원은 " + stringVector.size());
        System.out.println();

        System.out.println("14v. 벡터를 객체 형태로 콘솔에 출력할 수 있다.");
        System.out.println("1차원 배열 모양 벡터: " + stringVector.toString());
        System.out.println();

        System.out.println("15v. 객체의 동등성 판단을 할 수 있다.");
        System.out.println(stringVector + "와 " + randomVector + "을 비교합니다.");
        if (stringVector.equals(randomVector)) {
            System.out.println("두 벡터는 동등합니다.");
        } else {
            System.out.println("두 벡터는 동등하지 않습니다.");
        }
        System.out.println();

        System.out.println("17v. 객체 복제를 할 수 있다");
        BigDecimal[] copyArr = new BigDecimal[stringVector.size()];
        for (int i = 0; i < stringVector.size(); i++) {
            copyArr[i] = new BigDecimal(stringVector.get(i).getValue());
        }
        VectorImpl cloneVector = new VectorImpl(copyArr);
        System.out.println("복사한 벡터는 " + cloneVector.toString() + "입니다.");
        System.out.println();

        System.out.println("20. 벡터는 다른 벡터와 덧셈이 가능하다.(길이가 같을 때)");
        Vector addVector = stringVector.add(cloneVector);
        System.out.println("03 벡터와 17 벡터의 합은 "+ addVector.toString() + " 입니다.");
        System.out.println();

        System.out.println("21. 벡터는 다른 스칼라와 곱셈이 가능하다 (모든 요소에 곱)");
        Vector multiplyVector = stringVector.multiply(stringScalar);
        System.out.println(stringVector + "벡터에 " + stringScalar + " 을 곱한 벡터는 " + multiplyVector.toString());
        System.out.println();

        System.out.println("26. 전달받은 두 벡터의 덧셈이 가능하다.(길이가 같을 때)");
        Vector highAddVector = Vector.addTwoVector(stringVector, cloneVector);
        System.out.println("03 벡터와 17 벡터의 합은 " + highAddVector.toString() + " 입니다.");
        System.out.println();

        System.out.println("27. 전달받은 스칼라와 벡터의 곱셈이 가능하다.(벡터의 모든 요소에 스칼라를 곱한다)");
        Vector highMultiplyVector = Vector.multiplyScalar(stringVector, stringScalar);
        System.out.println("03 벡터와 01 스칼라의 곱은 " + highMultiplyVector.toString() + " 입니다.");


        System.out.println("30. n-차원 벡터 객체는 자신으로부터 nx1 행렬을 생성하여 반환할 수 있다.");
        Matrix VectorToColumnMatrix = stringVector.toColumnMatrix();
        System.out.println("벡터를 nx1으로 변형한 행렬은 " + VectorToColumnMatrix + "입니다.");
        System.out.println();

        System.out.println("31. n-차원 벡터 객체는 자신으로부터 1xn 행렬을 생성하여 반환할 수 있다.");
        Matrix VectorToRowMatrix = stringVector.toRowMatrix();
        System.out.println("벡터를 nx1으로 변형한 행렬은 " + VectorToRowMatrix + "입니다.");
        System.out.println();
    }
}