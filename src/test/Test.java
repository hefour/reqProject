package test;
import java.math.BigDecimal;
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
        System.out.println("지정 후 조회한 스칼라 값 : " + stringScalar.toString());
        System.out.println();

        System.out.println("14.스칼라 객체를 콘솔에 출력할 수 있다.");
        System.out.println("출력 스칼라 값 : " + stringScalar.toString());
        System.out.println();

        System.out.println("15. 스칼라 객체의 동등성 판단을 할 수 있다.");
        System.out.println("비교 스칼라 1 : " + stringScalar.toString());
        System.out.println("비교 스칼라 2 : " + randomScalar.toString());
        System.out.println(stringScalar.equals(randomScalar) ? "일치!" : "불일치..");

       /* System.out.println("18. 스칼라는 다른 스칼라와 덧셈이 가능하다.");
        Scalar testScalar = createScalarByString("2");
        System.out.println("기존 스칼라 : " + stringScalar.toString());
        System.out.println("더한 스칼라 : " + testScalar.toString());
        stringScalar.plusScalar(testScalar);
        Tensors.validateScalar(stringScalar, ("7"));
        System.out.println();

        System.out.println("19. 스칼라는 다른 스칼라와 곱셈이 가능하다.");
        System.out.println("기존 스칼라 : " + stringScalar.toString());
        System.out.println("곱한 스칼라 : " + testScalar.toString());
        stringScalar.multiplyScalar(testScalar);
        Tensors.validateScalar(stringScalar, "14");

        System.out.println("24. 전달받은 두 스칼라의 덧셈이 가능하다. ");

        System.out.println("스칼라 1 : " + stringScalar.toString());
        System.out.println("스칼라 2 : " + testScalar.toString());
        Scalar resultScalar = Scalar.plusTwoScalars(stringScalar, testScalar);
        Tensors.validateScalar(resultScalar, "16");

        System.out.println("25. 전달받은 두 스칼라의 곱셈이 가능하다. ");
        System.out.println("스칼라 1 : " + stringScalar.toString());
        System.out.println("스칼라 2 : " + testScalar.toString());
        resultScalar = Scalar.multiplyTwoScalars(stringScalar, testScalar);
        Tensors.validateScalar(resultScalar, "28");*/

        System.out.println("메트릭스 테스트");
        System.out.println(" ");

        // 06
        System.out.println("06. 지정된 하나의 값을 모든 요소의 값으로 하는 mxn 행렬을 생성할 수 있다.");
        Tensors.printMatrix(createMatrixByTypeNum(new BigDecimal("1"), 2, 3));
        System.out.println();

        // 07
        System.out.println("07. i 이상 j 미만의 무작위 값을 요소로 하는 mxn 행렬을 생성할 수 있다.");
        Tensors.printMatrix(createMatrixRandom(1, 2, 3, 2));
        System.out.println();

        // 08
        System.out.println("08. csv파일로부터 mxn 행렬을 생성할 수 있다.");
        String csvFile = "1,2,3\n4,5,6";
        Tensors.printMatrix(createMatrixByCSV(csvFile));
        System.out.println();

        // 09
        System.out.println("09. 2차원 배열로부터 mxn 행렬을 생성할 수 있다.");
        int[][] arrayData = {{1, 0}, {0, 1}};
        Tensors.printMatrix(createMatrixByArray(arrayData));
        System.out.println();

        //10
        System.out.println("10. 단위 행렬을 생성할 수 있다.");
        Tensors.printMatrix(createUnitMatrix(3));
        System.out.println();


        Matrix testMatrix = createMatrixByArray(new int[][]{{1, 2}, {3, 4}});
        System.out.println("테스트용 행렬");
        Tensors.printMatrix(testMatrix);
        System.out.println();

        // 11
        System.out.println("11. 행렬의 특정 위치의 요소를 지정/조회할 수 있다.");
        System.out.println("testMatrix.get(0,0) 값: " + testMatrix.get(0, 0).toString());
        Scalar newElementSet = createScalarByString("99");
        System.out.println("testMatrix의 (0,0) 위치에 스칼라 값 99을 지정.");
        testMatrix.set(0, 0, newElementSet);
        System.out.println("지정 후 testMatrix:");
        Tensors.printMatrix(testMatrix);
        System.out.println("지정 후 testMatrix.get(0,0) 값 : " + testMatrix.get(0, 0).toString());
        System.out.println();

        // 13
        System.out.println("13. 행렬의 크기 정보를 조회할 수 있다.");
        System.out.println("(2x2 행렬)의 행 개수 : " + testMatrix.getRowCount());
        System.out.println("(2x2 행렬)의 열 개수 : " + testMatrix.getColumnCount());
        System.out.println();

        // 14
        System.out.println("14. 행렬 객체를 콘솔에 출력할 수 있다.");
        System.out.println("출력 행렬:");
        Tensors.printMatrix(testMatrix);
        System.out.println();

        // 15
        System.out.println("15. 행렬 객체의 동등성 판단을 할 수 있다.");
        Matrix equalMatrix = createMatrixByArray(new int[][]{{99, 2}, {3, 4}}); // testMatrix와 동일
        Matrix falseMatrix = createMatrixByArray(new int[][]{{1, 0}, {0, 1}});

        System.out.println("비교 행렬 1 (testMatrix):");
        Tensors.printMatrix(testMatrix);
        System.out.println("비교 행렬 2 (equalMatrix):");
        Tensors.printMatrix(equalMatrix);
        System.out.println(testMatrix.equals(equalMatrix) ? "일치" : "불일치");

        System.out.println("비교 행렬 1 (testMatrix):");
        Tensors.printMatrix(testMatrix);
        System.out.println("비교 행렬 2 (falseMatrix):");
        Tensors.printMatrix(falseMatrix);
        System.out.println(testMatrix.equals(falseMatrix) ? "일치" : "불일치");
        System.out.println();

       //22,23연산
        Matrix matrixOps = createMatrixByArray(new int[][]{{1, 1}, {1, 1}});

        // 22
        System.out.println("22. 행렬은 다른 행렬과 덧셈이 가능하다.");
        System.out.println("기존 행렬 :");
        Tensors.printMatrix(testMatrix);
        System.out.println("덧셈 행렬 :");
        Tensors.printMatrix(matrixOps);
        System.out.println("덧셈 후 testMatrix :");
        Matrix test2Matrix = createMatrixByArray(new int[][]{{100, 3}, {4, 5}});
        Tensors.printMatrix(test2Matrix);
        System.out.println();

        // 23
        System.out.println("23. 행렬은 다른 행렬과 곱셈이 가능하다.");
        System.out.println("기존 행렬 :");
        Tensors.printMatrix(testMatrix);
        System.out.println("곱할 행렬 :");
        Tensors.printMatrix(matrixOps);
        System.out.println("곱셈 후 행렬 :");
        Tensors.printMatrix(testMatrix);
        System.out.println();


        // 28
        System.out.println("28. 전달받은 두 행렬의 덧셈이 가능하다.");
        System.out.println("호출 결과 (null 더미 객체):");
        Tensors.printMatrix(Tensors.add(testMatrix, matrixOps));
        System.out.println();

        // 29
        System.out.println("29. 전달받은 두 행렬의 곱셈이 가능하다.");
        System.out.println("호출 결과 (null 더미 객체):");
        Tensors.printMatrix(Tensors.multiply(testMatrix, matrixOps));
        System.out.println();
    }






}