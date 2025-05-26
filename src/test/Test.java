package test;
import java.math.BigDecimal;

import tensor.*;

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
        Scalar[][] arrayData = {{stringScalar, stringScalar}, {stringScalar, stringScalar}};
        Tensors.printMatrix(createMatrixByArray(arrayData));
        System.out.println();

        //10
        System.out.println("10. 단위 행렬을 생성할 수 있다.");
        Tensors.printMatrix(createUnitMatrix(3));
        System.out.println();

        Matrix testMatrix = createMatrixByArray(new Scalar[][]{{stringScalar, stringScalar}, {stringScalar, stringScalar}});
        System.out.println("테스트용 행렬");
        Tensors.printMatrix(testMatrix);
        System.out.println();

        // 11
        System.out.println("11v. 특정 위치의 요소를 지정조회할 수 있다.");
        int index = 2; // 0-based index (즉, 3번째 요소)
        Scalar indexValue = stringVector.get(index);
        System.out.println("벡터의 " + (index + 1) + "번째 요소는 " + indexValue.getValue());
        System.out.println();

        System.out.println("11m. 행렬의 특정 위치의 요소를 지정/조회할 수 있다.");
        System.out.println("testMatrix.get(0,0) 값: " + testMatrix.get(0, 0).toString());
        Scalar newElementSet = createScalarByString("99");
        System.out.println("testMatrix의 (0,0) 위치에 스칼라 값 99을 지정.");
        testMatrix.set(0, 0, newElementSet);
        System.out.println("지정 후 testMatrix:");
        Tensors.printMatrix(testMatrix);
        System.out.println("지정 후 testMatrix.get(0,0) 값 : " + testMatrix.get(0, 0).toString());
        System.out.println();


        System.out.println("12.스칼라 값을 지정/조회할 수 있다");
        System.out.println("스칼라 값을 5로 지정합니다.");
        stringScalar.setValue("5");
        System.out.println("지정 후 조회한 스칼라 값 : " + stringScalar.toString());
        System.out.println();

        System.out.println("13v. 크기 정보를 조회할 수 있다");
        System.out.println("03 에서 생성한 벡터의 크기 정보(차원)을 조회합니다");
        System.out.println("03 에서 생성한 벡터의 차원은 " + stringVector.size());
        System.out.println();

        // 13
        System.out.println("13m. 행렬의 크기 정보를 조회할 수 있다.");
        System.out.println("(2x2 행렬)의 행 개수 : " + testMatrix.getRowCount());
        System.out.println("(2x2 행렬)의 열 개수 : " + testMatrix.getColumnCount());
        System.out.println();

        // 14
        System.out.println("14s.스칼라 객체를 콘솔에 출력할 수 있다.");
        System.out.println("출력 스칼라 값 : " + stringScalar.toString());
        System.out.println();

        System.out.println("14v. 벡터를 객체 형태로 콘솔에 출력할 수 있다.");
        System.out.println("1차원 배열 모양 벡터: " + stringVector.toString());
        System.out.println();

        System.out.println("14m. 행렬 객체를 콘솔에 출력할 수 있다.");
        System.out.println("출력 행렬:");
        Tensors.printMatrix(testMatrix);
        System.out.println();

        System.out.println("15s. 스칼라 객체의 동등성 판단을 할 수 있다.");
        System.out.println("비교 스칼라 1 : " + stringScalar.toString());
        System.out.println("비교 스칼라 2 : " + randomScalar.toString());
        System.out.println(stringScalar.equals(randomScalar) ? "두 객체는 동등합니다!" : "두 객체는 동등하지 않습니다.");
        System.out.println();

        System.out.println("15v. 객체의 동등성 판단을 할 수 있다.");
        System.out.println(stringVector + "와 " + randomVector + "을 비교합니다.");
        if (stringVector.equals(randomVector)) {
            System.out.println("두 벡터는 동등합니다.");
        } else {
            System.out.println("두 벡터는 동등하지 않습니다.");
        }
        System.out.println();
        System.out.println("15m. 행렬 객체의 동등성 판단을 할 수 있다.");
        Matrix equalMatrix = createMatrixByArray(new Scalar[][]{{stringScalar, stringScalar}, {stringScalar, stringScalar}}); // testMatrix와 동일
        Matrix falseMatrix = createMatrixByArray(new Scalar[][]{{randomScalar, stringScalar}, {stringScalar, stringScalar}});

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



        System.out.println("16. 스칼라의 경우 값의 대소비교를 할 수 있다.");
        Scalar testScalar = createScalarByString("2");
        System.out.println("기존 스칼라 : "+stringScalar);
        System.out.println("입력 스칼라 : "+testScalar);
        switch(stringScalar.compareTo(testScalar)){
            case -1 -> System.out.println("기존 스칼라가 입력 스칼라보다 작습니다.");
            case 0 -> System.out.println("두 스칼라가 동일합니다.");
            case 1 -> System.out.println("기존 스칼라가 입력 스칼라보다 큽니다.");
        }
        System.out.println();
        System.out.println("17s. 스칼라 객체 복제를 할 수 있다.");
        System.out.println("기존 스칼라 객체 : "+stringScalar);
        testScalar = stringScalar.clone();
        System.out.println("복제된 스칼라 객체 : "+testScalar);
        System.out.println();
        System.out.println("17v. 벡터 객체 복제를 할 수 있다.");
        Vector oneVector=createVectorByString(8,"1");
        System.out.println("기존 벡터 객체 : "+oneVector);
        Vector cloneVector = oneVector.clone();
        System.out.println("복제된 벡터 객체 : "+cloneVector);
        System.out.println();
        System.out.println("17m. 행렬 객체 복제를 할 수 있다.");
        Matrix oneMatrix=createUnitMatrix(1);
        System.out.println("기존 행렬 객체 : "+oneMatrix);
        Matrix twoMatrix = oneMatrix.clone();
        System.out.println("복제된 행렬 객체 : "+twoMatrix);
        System.out.println();


        System.out.println("18. 스칼라는 다른 스칼라와 덧셈이 가능하다.");
        System.out.println("기존 스칼라 : " + stringScalar.toString());
        System.out.println("더한 스칼라 : " + testScalar.toString());
        stringScalar.plusScalar(testScalar);
        Tensors.validateScalar(stringScalar, "10");
        System.out.println();

        System.out.println("19. 스칼라는 다른 스칼라와 곱셈이 가능하다.");
        System.out.println("기존 스칼라 : " + stringScalar.toString());
        System.out.println("곱한 스칼라 : " + testScalar.toString());
        stringScalar.multiplyScalar(testScalar);
        Tensors.validateScalar(stringScalar, "50");

        System.out.println("20. 벡터는 다른 벡터와 덧셈이 가능하다.(길이가 같을 때)");
        Vector addVector = stringVector.add(cloneVector);
        System.out.println("03 벡터와 17 벡터의 합은 "+ addVector.toString() + " 입니다.");
        System.out.println();

        System.out.println("21. 벡터는 다른 스칼라와 곱셈이 가능하다 (모든 요소에 곱)");
        Vector multiplyVector = stringVector.multiply(stringScalar);
        System.out.println(stringVector + "벡터에 " + stringScalar + " 을 곱한 벡터는 " + multiplyVector.toString());
        System.out.println();

        //22,23연산
        Matrix matrixOps = createMatrixByArray(new Scalar[][]{{stringScalar, randomScalar}, {stringScalar, randomScalar}});

        // 22
        System.out.println("22. 행렬은 다른 행렬과 덧셈이 가능하다.");
        System.out.println("기존 행렬 :");
        Tensors.printMatrix(testMatrix);
        System.out.println("덧셈 행렬 :");
        Tensors.printMatrix(matrixOps);
        System.out.println("덧셈 후 testMatrix :");
        Matrix test2Matrix = createMatrixByArray(new Scalar[][]{{randomScalar, stringScalar}, {stringScalar, randomScalar}});
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

        System.out.println("24. 전달받은 두 스칼라의 덧셈이 가능하다. ");

        System.out.println("스칼라 1 : " + stringScalar.toString());
        System.out.println("스칼라 2 : " + testScalar.toString());
        Scalar resultScalar = Scalar.plusTwoScalars(stringScalar, testScalar);
        Tensors.validateScalar(resultScalar, "55");

        System.out.println("25. 전달받은 두 스칼라의 곱셈이 가능하다. ");
        System.out.println("스칼라 1 : " + stringScalar.toString());
        System.out.println("스칼라 2 : " + testScalar.toString());
        resultScalar = Scalar.multiplyTwoScalars(stringScalar, testScalar);
        Tensors.validateScalar(resultScalar, "250");

        System.out.println("26. 전달받은 두 벡터의 덧셈이 가능하다.(길이가 같을 때)");
        Vector highAddVector = Vector.addTwoVector(stringVector, cloneVector);
        System.out.println("03 벡터와 17 벡터의 합은 " + highAddVector.toString() + " 입니다.");
        System.out.println();

        System.out.println("27. 전달받은 스칼라와 벡터의 곱셈이 가능하다.(벡터의 모든 요소에 스칼라를 곱한다)");
        Vector highMultiplyVector = Vector.multiplyScalar(stringVector, stringScalar);
        System.out.println("03 벡터와 01 스칼라의 곱은 " + highMultiplyVector.toString() + " 입니다.");

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

        System.out.println("30. n-차원 벡터 객체는 자신으로부터 nx1 행렬을 생성하여 반환할 수 있다.");
        Matrix VectorToColumnMatrix = stringVector.toColumnMatrix();
        System.out.println("벡터를 nx1으로 변형한 행렬은 " + VectorToColumnMatrix + "입니다.");
        System.out.println();

        System.out.println("31. n-차원 벡터 객체는 자신으로부터 1xn 행렬을 생성하여 반환할 수 있다.");
        Matrix VectorToRowMatrix = stringVector.toRowMatrix();
        System.out.println("벡터를 nx1으로 변형한 행렬은 " + VectorToRowMatrix + "입니다.");
        System.out.println();
        Vector vectorForMatrixConv = createVectorByString(3, "7");
        System.out.println("30. 벡터는 자신으로부터 nx1 행렬을 생성하여 반환할 수 있다.");
        Matrix matrixColVector = vectorForMatrixConv.toColumnMatrix();
        System.out.println("  -> " + vectorForMatrixConv + " -> nx1 행렬:"); Tensors.printMatrix(matrixColVector);
        System.out.println();

        System.out.println("31. 벡터는 자신으로부터 1xn 행렬을 생성하여 반환할 수 있다.");
        Matrix matrixRowVector = vectorForMatrixConv.toRowMatrix();
        System.out.println("  -> " + vectorForMatrixConv + " -> 1xn 행렬:"); Tensors.printMatrix(matrixRowVector);
        System.out.println();


// 테스트용 생성
        Scalar s0 = createScalarByString("0");
        Scalar s1 = createScalarByString("1");
        Scalar s2 = createScalarByString("2");
        Scalar s3 = createScalarByString("3");
        Scalar s5 = createScalarByString("5");

        Matrix squareMatrix = createMatrixByArray(new Scalar[][]{{s1, s2}, {s0, s5}});
        Matrix nonSquareMatrix = createMatrixByCSV("1,0\n0,1\n0,0");
        Matrix upperTriMatrix = createMatrixByArray(new Scalar[][]{{s1, s2, s5}, {s0, s1, s2}, {s0, s0, s1}});
        Matrix lowerTriMatrix = createMatrixByArray(new Scalar[][]{{s1, s0, s0}, {s2, s1, s0}, {s5, s2, s1}});
        Matrix identityTestMatrix = createUnitMatrix(3);
        Matrix zeroTestMatrix = createMatrixByTypeNum(new BigDecimal("0"), 2, 2);

        System.out.println("40. 정사각 행렬 판별");
        System.out.println("  -> squareMatrix (2x2)는 정사각 행렬인가? " + squareMatrix.isSquare());
        System.out.println("  -> nonSquareMatrix (3x2)는 정사각 행렬인가? " + nonSquareMatrix.isSquare());
        System.out.println();

        System.out.println("41. 상삼각 행렬 판별");
        System.out.println("  -> upperTriMatrix는 상삼각 행렬인가? " + upperTriMatrix.isUpperTriangular());
        System.out.println("  -> lowerTriMatrix는 상삼각 행렬인가? " + lowerTriMatrix.isUpperTriangular());
        System.out.println("  -> squareMatrix는 상삼각 행렬인가? " + squareMatrix.isUpperTriangular());
        System.out.println();

        System.out.println("42. 하삼각 행렬 판별");
        System.out.println("  -> lowerTriMatrix는 하삼각 행렬인가? " + lowerTriMatrix.isLowerTriangular());
        System.out.println("  -> upperTriMatrix는 하삼각 행렬인가? " + upperTriMatrix.isLowerTriangular());
        System.out.println("  -> squareMatrix는 하삼각 행렬인가? " + squareMatrix.isLowerTriangular());
        System.out.println();

        System.out.println("43. 단위 행렬 판별");
        System.out.println("  -> identityTestMatrix는 단위 행렬인가? " + identityTestMatrix.isIdentity());
        System.out.println("  -> squareMatrix는 단위 행렬인가? " + squareMatrix.isIdentity());
        System.out.println();

        System.out.println("44. 영 행렬 판별");
        System.out.println("  -> zeroTestMatrix는 영 행렬인가? " + zeroTestMatrix.isZero());
        System.out.println("  -> identityTestMatrix는 영 행렬인가? " + identityTestMatrix.isZero());
        System.out.println();

        Matrix matrixForOps = createMatrixByCSV("11,12,13\n14,15,16\n17,18,19");
        System.out.println("--- 다음 연산을 위한 원본 행렬 (matrixForOps):");
        Tensors.printMatrix(matrixForOps);
        System.out.println();

        System.out.println("45. 행 교환");
        Matrix matrixa = matrixForOps.clone();
        System.out.println("  -> 교환 전 (0행과 2행 교환):"); Tensors.printMatrix(matrixa);
        matrixa.swapRows(0, 2);
        System.out.println("  -> 교환 후 결과:"); Tensors.printMatrix(matrixa);
        System.out.println();

        System.out.println("46. 열 교환");
        Matrix matrixb = matrixForOps.clone();
        System.out.println("  -> 교환 전 (0열과 1열 교환):"); Tensors.printMatrix(matrixb);
        matrixb.swapColumns(0, 1);
        System.out.println("  -> 교환 후 결과:"); Tensors.printMatrix(matrixb);
        System.out.println();

        System.out.println("47. 특정 행에 스칼라 곱");
        Matrix matrixc = matrixForOps.clone();
        System.out.println("  -> 연산 전 (1행에 스칼라 \"" + s2 + "\" 곱):"); Tensors.printMatrix(matrixc);
        matrixc.scaleRow(1, s2);
        System.out.println("  -> 연산 후 결과:"); Tensors.printMatrix(matrixc);
        System.out.println();

        System.out.println("48. 특정 열에 스칼라 곱");
        Matrix matrixd = matrixForOps.clone();
        System.out.println("  -> 연산 전 (2열에 스칼라 \"" + s3 + "\" 곱):"); Tensors.printMatrix(matrixd);
        matrixd.scaleColumn(2, s3);
        System.out.println("  -> 연산 후 결과:"); Tensors.printMatrix(matrixd);
        System.out.println();

        System.out.println("49. 특정 행에 다른 행의 상수배를 더하기");
        Matrix matrixe = matrixForOps.clone();
        System.out.println("  -> 연산 전 (2행 += 0행 * \"" + s2 + "\"):"); Tensors.printMatrix(matrixe);
        matrixe.addRowMultiple(2, 0, s2);
        System.out.println("  -> 연산 후 결과:"); Tensors.printMatrix(matrixe);
        System.out.println();

        System.out.println("50. 특정 열에 다른 열의 상수배를 더하기");
        Matrix matrixf = matrixForOps.clone();
        System.out.println("  -> 연산 전 (0열 += 1열 * \"" + s3 + "\"):"); Tensors.printMatrix(matrixf);
        matrixf.addColumnMultiple(0, 1, s3);
        System.out.println("  -> 연산 후 결과:"); Tensors.printMatrix(matrixf);
        System.out.println();


    }






}