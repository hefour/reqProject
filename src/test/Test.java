package test;
import java.math.BigDecimal;
import tensor.*;

import static tensor.Factory.*;

public class Test {
    public static void main(String[] args) {

        System.out.println("01. String 값을 지정하여 스칼라를 생성할 수 있다");
        Scalar stringScalar = createScalarByString("4");  // 01.
        System.out.println("기댓 값 : 4");
        System.out.println("결과 값 : " + stringScalar);
        System.out.println(stringScalar.get().equals("4") ? "통과" : "실패");
        System.out.println();

        System.out.println("02. i이상 j미만의 무작위 값을 요소로 하는 스칼라를 생성할 수 있다.");
        Scalar randomScalar = createScalarByRandom(1, 2);          // 02.
        System.out.println("기댓 값 : (1과 2 사이의 스칼라 값)");
        System.out.println("결과 값 : " + randomScalar);
        System.out.println("1, 2 사이의 실수 값이 출력되면 통과");
        System.out.println();

        System.out.println("03. 지정한 하나의 값을 모든 요소의 값으로 하는 차원 벡터를 생성할 수 있다.");
        Vector stringVector = createVectorByString(8,"3");  // 03.
        System.out.println("기댓 값 : [3, 3, 3, 3, 3, 3, 3, 3]");
        System.out.println("결과 값 : " + stringVector);
        System.out.println(stringVector.toString().equals("[3, 3, 3, 3, 3, 3, 3, 3]") ? "통과" : "실패");
        System.out.println();

        System.out.println("04. i 이상 j 미만의 무작위 값을 요소로 하는 차원 벡터를 생성할 수 있다.");
        Vector randomVector = createVectorByRandom(8,1, 2);  // 04.
        System.out.println("기댓 값 : (1과 2사이의 하나의 실수 값으로 이뤄진 8차원 벡터)");
        System.out.println("결과 값 : " + randomVector);
        System.out.println("기댓 값 조건 충족 시 통과");
        System.out.println();

        System.out.println("05. 차원 배열로부터 차원 벡터를 생성할 수 있다.");
        BigDecimal[] arr = {
                new BigDecimal("3"),
                new BigDecimal("5"),
                new BigDecimal("8")
        };
        Vector arrVector = createVectorByArray(arr);
        System.out.println("기댓 값 : [3, 5, 8]");
        System.out.println("결과 값 : " + arrVector);
        System.out.println(arrVector.toString().equals("[3, 5, 8]") ? "통과" : "실패");
        System.out.println();

        // 06
        Matrix stringMatrix = createMatrixByTypeNum("1", 2, 3);
        System.out.println("06. 지정된 하나의 값을 모든 요소의 값으로 하는 mxn 행렬을 생성할 수 있다.");
        System.out.println("기댓 값 : ");
        System.out.println("[[1, 1, 1],\n" +
                " [1, 1, 1]]");
        System.out.println("결과 값 : ");
        System.out.println(stringMatrix.toString());
        System.out.println(stringMatrix.toString().equals("[[1, 1, 1],\n" +
                " [1, 1, 1]]") ? "통과" : "실패");
        System.out.println();

        // 07
        System.out.println("07. i 이상 j 미만의 무작위 값을 요소로 하는 mxn 행렬을 생성할 수 있다.");
        Matrix randomMatrix = createMatrixRandom(1,2, 3, 3);
        System.out.println("기댓 값 : ");
        System.out.println("(1, 2 사이의 임의의 실수 값으로 이루어진 3 x 3 행렬)");
        System.out.println("결과 값 : ");
        System.out.println(randomMatrix.toString());
        System.out.println("기댓 값 조건 충족 시 통과");
        System.out.println();

        // 08
        System.out.println("08. csv파일로부터 mxn 행렬을 생성할 수 있다.");
        String csvFile = "1,2,3\n4,5,6";
        Matrix csvMatrix = createMatrixByCSV(csvFile);
        System.out.println("기댓 값 : ");
        System.out.println("[[1, 2, 3],\n" +
                " [4, 5, 6]]");
        System.out.println("결과 값 : ");
        System.out.println(csvMatrix.toString());
        System.out.println(csvMatrix.toString().equals("[[1, 2, 3],\n" +
                " [4, 5, 6]]") ? "통과" : "실패");
        System.out.println();

        // 09
        System.out.println("09. 2차원 배열로부터 mxn 행렬을 생성할 수 있다.");
        Scalar[][] arrayData = {{stringScalar, stringScalar}, {stringScalar, stringScalar}};
        Matrix arrayMatrix = createMatrixByArray(arrayData);
        System.out.println("기댓 값 : ");
        System.out.println("[[4, 4],\n" +
                " [4, 4]]");
        System.out.println("결과 값 : ");
        System.out.println(arrayMatrix.toString());
        System.out.println(arrayMatrix.toString().equals("[[4, 4],\n" +
                " [4, 4]]") ? "통과" : "실패");
        System.out.println();

        //10
        System.out.println("10. 단위 행렬을 생성할 수 있다.");
        Matrix unitMatrix = createUnitMatrix(3);
        System.out.println("기댓 값 : ");
        System.out.println(
                "[[1, 0, 0],\n" +
                " [0, 1, 0],\n" +
                " [0, 0, 1]]");
        System.out.println("결과 값 : ");
        System.out.println(unitMatrix.toString());
        System.out.println(unitMatrix.toString().equals(
                "[[1, 0, 0],\n" +
                " [0, 1, 0],\n" +
                " [0, 0, 1]]") ? "통과" : "실패" );
        System.out.println();

        // 11
        System.out.println("11v. 특정 위치의 요소를 지정조회할 수 있다.");
        int index = 2; // 0-based index (즉, 3번째 요소)
        System.out.println("3번에서 만든 [3, 3, 3, 3, 3, 3, 3, 3] 벡터의 3번째 요소를 지정, 조회한다.");
        System.out.println("기댓 값: 3");
        System.out.println("결과 값 : " + stringVector.get(index));
        System.out.println("3번 째 인덱스를 4로 변경한다.");
        stringVector.set(index, stringScalar);
        System.out.println("기댓 값 : [3, 3, 4, 3, 3, 3, 3, 3]");
        System.out.println("결과 값 : " + stringVector.toString());
        System.out.println(stringVector.toString().equals("[3, 3, 4, 3, 3, 3, 3, 3]") ? "통과" : "실패");
        System.out.println();

        System.out.println("11m. 행렬의 특정 위치의 요소를 지정/조회할 수 있다.");
        int rowIndex = 1;
        int columnIndex = 1;
        System.out.println("8번에서 만든 \n" + "[[1, 2, 3],\n" +
                " [4, 5, 6]] 행렬의 \n"+"2행 2열 요소를 지정, 조회한다.");
        System.out.println("기댓 값 : 5");
        System.out.println("결과 값 : " + csvMatrix.get(rowIndex, columnIndex));
        System.out.println("2행 2열 요소를 4로 변경한다.");
        csvMatrix.set(rowIndex, columnIndex, stringScalar);
        System.out.println("기댓 값 : ");
        System.out.println("[[1, 2, 3],\n" +
                " [4, 4, 6]]");
        System.out.println("결과 값 : ");
        System.out.println(csvMatrix.toString());
        System.out.println(csvMatrix.toString().equals("[[1, 2, 3],\n" +
                " [4, 4, 6]]") ? "통과" : "실패");
        System.out.println();

        System.out.println("12.스칼라 값을 지정/조회할 수 있다");
        System.out.println("1번 스칼라 값 4를 5로 지정 조회합니다.");
        stringScalar.set("5");
        System.out.println("기댓 값 : 5 ");
        System.out.println("결과 값: " + stringScalar.toString());
        System.out.println(stringScalar.get().equals("5") ? "통과" : "실패");
        System.out.println();

        System.out.println("13v. 크기 정보를 조회할 수 있다");
        System.out.println("11번에서 생성한 벡터의 크기 정보(차원)을 조회합니다");
        System.out.println("기댓 값 : 8");
        System.out.println("결과 값 : " + stringVector.getDimensionCount());
        System.out.println();

        // 13
        System.out.println("13m. 행렬의 크기 정보를 조회할 수 있다.");
        System.out.println("11번에서 지정한 행렬의 행 개수, 열 개수를 조회합니다");
        System.out.println("기댓 값 : 2, 3");
        System.out.println("결과 값 : " + csvMatrix.getRowCount() +", "+ csvMatrix.getColumnCount());
        System.out.println(csvMatrix.getRowCount() == 2 && csvMatrix.getColumnCount() == 3 ? "통과" : "실패");
        System.out.println();

        // 14
        System.out.println("14s.스칼라 객체를 콘솔에 출력할 수 있다.");
        System.out.println("12번에서 생성한 스칼라를 출력합니다");
        System.out.println("기댓 값 : 5 ");
        System.out.println("결과 값: " + stringScalar.toString());
        System.out.println(stringScalar.get().equals("5") ? "통과" : "실패");
        System.out.println();

        System.out.println("14v. 벡터를 객체 형태로 콘솔에 출력할 수 있다.");
        System.out.println("11번 벡터를 출력합니다. ");
        System.out.println("기댓 값 : [3, 3, 4, 3, 3, 3, 3, 3]");
        System.out.println("결과 값 : " + stringVector.toString());
        System.out.println(stringVector.toString().equals("[3, 3, 4, 3, 3, 3, 3, 3]") ? "통과" : "실패");
        System.out.println();

        System.out.println("14m. 행렬 객체를 콘솔에 출력할 수 있다.");
        System.out.println("11번에서 지정한 행렬을 출력합니다.");
        System.out.println("기댓 값 : ");
        System.out.println("[[1, 2, 3],\n" +
                " [4, 4, 6]]");
        System.out.println("결과 값 : ");
        System.out.println(csvMatrix.toString());
        System.out.println(csvMatrix.toString().equals("[[1, 2, 3],\n" +
                " [4, 4, 6]]") ? "통과" : "실패");
        System.out.println();

        System.out.println("15s. 스칼라 객체의 동등성 판단을 할 수 있다.");
        System.out.println("비교 스칼라 1 : " + stringScalar.toString());
        Scalar compareScalar = createScalarByString("1");
        System.out.println("비교 스칼라 2 : " + compareScalar.toString());
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
        Matrix equalMatrix = createMatrixByArray(new Scalar[][]{{compareScalar, compareScalar, compareScalar}, {compareScalar, compareScalar, compareScalar}}); // testMatrix와 동일
        Matrix falseMatrix = createMatrixByArray(new Scalar[][]{{compareScalar, stringScalar, compareScalar}, {compareScalar, compareScalar, compareScalar}});

        System.out.println("비교 행렬 1 : " );
        System.out.println(stringMatrix.toString());
        System.out.println("비교 행렬 2 : ");
        System.out.println(equalMatrix.toString());
        System.out.println(stringMatrix.equals(equalMatrix) ? "일치" : "불일치");
        System.out.println();

        System.out.println("비교 행렬 1 : " );
        System.out.println(stringMatrix.toString());
        System.out.println("비교 행렬 2 : ");
        System.out.println(falseMatrix.toString());
        System.out.println(stringMatrix.equals(falseMatrix) ? "일치" : "불일치");
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
        System.out.println(cloneVector.equals(oneVector) ? "통과" : "실패");
        System.out.println();

        System.out.println("17m. 행렬 객체 복제를 할 수 있다.");
        System.out.println("기존 행렬 객체 : " + csvMatrix);
        Matrix cloneMatrix = csvMatrix.clone();
        System.out.println("복제된 행렬 객체 : " + cloneMatrix);
        System.out.println(csvMatrix.equals(cloneMatrix) ? "통과" : "실패");
        System.out.println();


        System.out.println("18. 스칼라는 다른 스칼라와 덧셈이 가능하다.");
        Scalar addMultiplyScalar = createScalarByString("5");
        System.out.println("기존 스칼라 : " + addMultiplyScalar.toString());
        System.out.println("더할 스칼라 : " + testScalar.toString());
        addMultiplyScalar.add(testScalar);
        System.out.println("기댓 값 : 10 ");
        System.out.println("결과 값 : " + addMultiplyScalar.toString());
        System.out.println(addMultiplyScalar.toString().equals("10") ? "통과" : "실패");
        System.out.println();

        System.out.println("19. 스칼라는 다른 스칼라와 곱셈이 가능하다.");
        System.out.println("기존 스칼라 : " + addMultiplyScalar.toString());
        System.out.println("곱할 스칼라 : " + testScalar.toString());
        addMultiplyScalar.multiply(testScalar);
        System.out.println("기댓 값 : 50");
        System.out.println("결과 값 : " + addMultiplyScalar.toString());
        System.out.println(addMultiplyScalar.toString().equals("50") ? "통과" : "실패");
        System.out.println();


        System.out.println("20. 벡터는 다른 벡터와 덧셈이 가능하다.(길이가 같을 때)");
        Vector addMultiplyScalarVector = createVectorByString(8,"2");
        System.out.println("기존 벡터 : " + addMultiplyScalarVector.toString());
        System.out.println("더할 벡터 : " + cloneVector.toString());
        addMultiplyScalarVector.add(cloneVector);
        System.out.println("기댓 값 : [3, 3, 3, 3, 3, 3, 3, 3]");
        System.out.println("결과 값 : " + addMultiplyScalarVector.toString());
        System.out.println(addMultiplyScalarVector.toString().equals("[3, 3, 3, 3, 3, 3, 3, 3") ? "통과" : "실패");
        System.out.println();

        System.out.println("21. 벡터는 다른 스칼라와 곱셈이 가능하다 (모든 요소에 곱)");
        System.out.println("기존 벡터 : " + addMultiplyScalarVector.toString());
        System.out.println("곱할 스칼라 : " + testScalar.toString());
        addMultiplyScalarVector.multiply(testScalar);
        System.out.println("기댓 값 : [15, 15, 15, 15, 15, 15, 15, 15]");
        System.out.println("결과 값 : " + addMultiplyScalarVector.toString());
        System.out.println(addMultiplyScalarVector.toString().equals("[15, 15, 15, 15, 15, 15, 15, 15]") ? "통과" : "실패");
        System.out.println();

        //22,23연산

        // 22
        System.out.println("22. 행렬은 다른 행렬과 덧셈이 가능하다.");
        Matrix addMultiplyMatrix = createMatrixByCSV("1,2,3\n4,5,6");
        System.out.println("기존 행렬 :");
        System.out.println(addMultiplyMatrix.toString());
        System.out.println("덧셈 행렬 :");
        System.out.println(falseMatrix.toString());
        addMultiplyMatrix.add(falseMatrix);
        System.out.println("기댓 값 : ");
        System.out.println("[[2, 6, 2],\n" +
                " [2, 2, 2]]");
        System.out.println("결과 값 : ");
        System.out.println(addMultiplyMatrix.toString());
        System.out.println(addMultiplyMatrix.toString().equals("[[]]") ? "통과" : "실패");

        System.out.println();

        // 23
        System.out.println("23. 행렬은 다른 행렬과 곱셈이 가능하다.");
        System.out.println("기존 행렬 :");
        System.out.println(addMultiplyMatrix.toString());
        System.out.println("곱셈 행렬 :");
        System.out.println(falseMatrix.toString());
        addMultiplyMatrix.multiply(falseMatrix);
        System.out.println("기댓 값 : ");
        System.out.println("[[2, 6, 2],\n" +
                " [2, 2, 2]]");
        System.out.println("결과 값 : ");
        System.out.println(addMultiplyMatrix.toString());
        System.out.println(addMultiplyMatrix.toString().equals("[]") ? "통과" : "실패");

        System.out.println();

        System.out.println("24. 전달받은 두 스칼라의 덧셈이 가능하다. ");

        System.out.println("스칼라 1 : " + stringScalar.toString());
        System.out.println("스칼라 2 : " + testScalar.toString());
        Scalar resultAddScalar = Tensors.addScalarByScalar(stringScalar, testScalar);
        System.out.println("기댓 값 : 10");
        System.out.println("결과 값 : " + resultAddScalar.toString());
        System.out.println(resultAddScalar.toString().equals("10") ? "통과" : "실패");
        System.out.println();

        System.out.println("25. 전달받은 두 스칼라의 곱셈이 가능하다. ");
        System.out.println("스칼라 1 : " + stringScalar.toString());
        System.out.println("스칼라 2 : " + testScalar.toString());
        Scalar resultMultiplyScalar = Tensors.multiplyScalrByScalar(stringScalar, testScalar);
        System.out.println("기댓 값 : 25 ");
        System.out.println("결과 값 : " + resultMultiplyScalar.toString());
        System.out.println(resultMultiplyScalar.toString().equals("25") ? "통과" : "실패");
        System.out.println();

        System.out.println("26. 전달받은 두 벡터의 덧셈이 가능하다.(길이가 같을 때)");
        System.out.println("벡터 1 : " + stringVector.toString());
        System.out.println("벡터 2 : " + cloneVector.toString());
        System.out.println("기댓 값 : ");
        Vector resultAddVector = Tensors.addVectorByVector(stringVector, cloneVector);
        System.out.println("결과 값 : " + resultAddVector.toString());
        System.out.println();

        System.out.println("27. 전달받은 스칼라와 벡터의 곱셈이 가능하다.(벡터의 모든 요소에 스칼라를 곱한다)");
        System.out.println("벡터 1 : " + stringVector.toString());
        System.out.println("벡터 2 : " + stringVector.toString());
        System.out.println("기댓 값 : ");
        Vector resultMultiplyVectorByScalar = Tensors.multiplyVectorByScalar(stringVector, stringScalar);
        System.out.println("결과 값 : " + resultMultiplyVectorByScalar.toString());

        // 28
        System.out.println("28. 전달받은 두 행렬의 덧셈이 가능하다.");
        Matrix test1Matrix = createMatrixByCSV("2,3\n4,5");
        Matrix test2Matrix = createMatrixByCSV("1,2\n5,6");
        System.out.println("행렬 1 : " + test1Matrix.toString());
        System.out.println("행렬 2 : " + test2Matrix.toString());
        System.out.println("기댓 값 : ");
        Matrix resultAddMatrix = Tensors.addMatrixByMatrix(test1Matrix, test2Matrix);
        System.out.println("결과 값 : ");
        System.out.println(resultAddMatrix.toString());
        System.out.println();

        // 29
        System.out.println("29. 전달받은 두 행렬의 곱셈이 가능하다.");
        System.out.println("행렬 1 : " + test1Matrix.toString());
        System.out.println("행렬 2 : " + test2Matrix.toString());
        System.out.println("기댓 값 : ");
        Matrix resultMultiplyMatrix = Tensors.addMatrixByMatrix(test1Matrix, test2Matrix);
        System.out.println("결과 값 : ");
        System.out.println(resultMultiplyMatrix.toString());
        System.out.println();
/*
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

        //행렬 생성
        Matrix tMatrix=createUnitMatrix(3);
        Matrix t2Matrix=createUnitMatrix(3);
        Matrix t3Matrix=createUnitMatrix(3);
        System.out.println("32. 행렬은 다른 행렬과 가로로 합쳐질 수 있다.");
        System.out.println("기존 행렬 : \n"+ tMatrix);
        System.out.println("추가할 행렬 : \n"+ t2Matrix);
        System.out.println("합쳐진 행렬 : \n"+ tMatrix.widthPaste(t2Matrix));
        tMatrix=createUnitMatrix(3);
        System.out.println();
        System.out.println("32-1. 디폴트 static 메소드 호출");
        System.out.println("행렬 1 : \n"+ tMatrix);
        System.out.println("행렬 2 : \n"+ t2Matrix);
        Matrix resMatrix=Tensors.combineWidth(tMatrix, t2Matrix);
        System.out.println("합쳐진 행렬 : \n"+resMatrix);
        System.out.println();

        System.out.println("33. 행렬은 다른 행렬과 세로로 합쳐질 수 있다.");
        System.out.println("기존 행렬 : \n"+ t2Matrix);
        System.out.println("추가할 행렬 : \n"+ t3Matrix);
        System.out.println("합쳐진 행렬 : \n" + t2Matrix.heightPaste(t3Matrix));
        t2Matrix=createUnitMatrix(3);
        System.out.println();
        System.out.println("33-1. 디폴트 static 메소드 호출");
        System.out.println("행렬 1 : \n"+ t2Matrix);
        System.out.println("행렬 2 : \n"+ t3Matrix);
        resMatrix=Tensors.combineHeight(tMatrix, t2Matrix);
        System.out.println("합쳐진 행렬 : \n"+resMatrix);
        System.out.println();

        System.out.println("34. 행렬은 특정 행을 벡터 형태로 추출해 줄 수 있다.");
        System.out.println("기존 행렬 : \n"+ tMatrix);
        System.out.println("추출할 행 : 1");
        Vector resVec=tMatrix.rowVector(1);
        System.out.println("추출한 벡터 : \n"+resVec);
        System.out.println();

        System.out.println("35. 행렬은 특정 열을 벡터 형태로 추출해 줄 수 있다");
        System.out.println("기존 행렬 : \n"+ tMatrix);
        System.out.println("추출할 열 : 1");
        resVec=tMatrix.colVector(1);
        System.out.println("추출한 벡터 : \n"+resVec);
        System.out.println();

        System.out.println("36. 행렬은 특정 범위의 부분 행렬을 추출해 줄 수 있다.");
        System.out.println("기존 행렬 : \n"+ tMatrix);
        System.out.println("시작 행 인덱스 : 1 , 끝 행 인덱스 : 2");
        System.out.println("시작 열 인덱스 : 1 , 끝 열 인덱스 : 2");
        resMatrix=tMatrix.getSubMatrix(1,2,1,2);
        System.out.println("추출한 행렬 : \n"+resMatrix);
        System.out.println();

        System.out.println("37. 행렬은 특정 범위의 부분 행렬을 추출해 줄 수 있다.");
        System.out.println("기존 행렬 : \n"+ tMatrix);
        System.out.println("지정 행 : 1 , 지정 열 : 1");
        resMatrix=tMatrix.getMinor(1,1);
        System.out.println("추출한 행렬 : \n"+resMatrix);
        System.out.println();

        System.out.println("38. 행렬은 전치행렬을 구현해 줄 수 있다.");
        System.out.println("기존 행렬 : \n"+ tMatrix);
        resMatrix=tMatrix.transpose();
        System.out.println("전치 행렬 : \n"+ resMatrix);
        System.out.println();

        System.out.println("39. 행렬은 대각 요소의 합을 구해줄 수 있다.");
        System.out.println("기존 행렬 : \n"+ tMatrix);
        Scalar resScalar=tMatrix.trace();
        System.out.println("대각 요소의 합 : \n"+ resScalar);
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
        Matrix zeroTestMatrix = createMatrixByTypeNum("0", 2, 2);

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
*/

    }






}