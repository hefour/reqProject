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
/*
        System.out.println("03. 지정한 하나의 값을 모든 요소의 값으로 하는 차원 벡터를 생성할 수 있다.");
        Vector stringVector = createVectorByString(8,"3");  // 03.
        System.out.println("기댓 값 : [3, 3, 3, 3, 3, 3, 3, 3]");
        System.out.println("결과 값 : " + stringVector);
        System.out.println(stringVector.toString().equals("[3, 3, 3, 3, 3, 3, 3, 3]") ? "통과" : "실패");
        System.out.println();

        System.out.println("04. i 이상 j 미만의 무작위 값을 요소로 하는 차원 벡터를 생성할 수 있다.");
        Vector randomVector = createVectorByRandom(8,2, 3);  // 04.
        System.out.println("기댓 값 : (2과 3사이의 임의의 실수 값으로 이뤄진 8차원 벡터)");
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
        Matrix stringMatrix = createMatrixByTypeNum("2", 2, 3);
        System.out.println("06. 지정된 하나의 값을 모든 요소의 값으로 하는 mxn 행렬을 생성할 수 있다.");
        System.out.println("기댓 값 (2 x 3 행렬) : ");
        System.out.println("[[2, 2, 2],\n" +
                " [2, 2, 2]]");
        System.out.println("결과 값 : ");
        System.out.println(stringMatrix.toString());
        System.out.println(stringMatrix.toString().equals("[[2, 2, 2],\n" +
                " [2, 2, 2]]") ? "통과" : "실패");
        System.out.println();

        // 07
        System.out.println("07. i 이상 j 미만의 무작위 값을 요소로 하는 mxn 행렬을 생성할 수 있다.");
        Matrix randomMatrix = createMatrixRandom(2,3, 3, 3);
        System.out.println("기댓 값 : ");
        System.out.println("(2, 3 사이의 임의의 실수 값으로 이루어진 3 x 3 행렬)");
        System.out.println("결과 값 : ");
        System.out.println(randomMatrix.toString());
        System.out.println("기댓 값 조건 충족 시 통과");
        System.out.println();

        // 08
        System.out.println("08. csv파일로부터 mxn 행렬을 생성할 수 있다.");
        String csvFile = "1,4,3\n7,5,6";
        Matrix csvMatrix = createMatrixByCSV(csvFile);
        System.out.println("기댓 값 : ");
        System.out.println("[[1, 4, 3],\n" +
                " [7, 5, 6]]");
        System.out.println("결과 값 : ");
        System.out.println(csvMatrix.toString());
        System.out.println(csvMatrix.toString().equals("[[1, 4, 3],\n" +
                " [7, 5, 6]]") ? "통과" : "실패");
        System.out.println();

        // 09
        System.out.println("09. 2차원 배열로부터 mxn 행렬을 생성할 수 있다.");
        Scalar temp1Scalar = createScalarByString("2");
        Scalar[][] arrayData = {{temp1Scalar, temp1Scalar}, {temp1Scalar, temp1Scalar}};
        Matrix arrayMatrix = createMatrixByArray(arrayData);
        System.out.println("기댓 값 : ");
        System.out.println("[[2, 2],\n" +
                " [2, 2]]");
        System.out.println("결과 값 : ");
        System.out.println(arrayMatrix.toString());
        System.out.println(arrayMatrix.toString().equals("[[2, 2],\n" +
                " [2, 2]]") ? "통과" : "실패");
        System.out.println();

        //10
        System.out.println("10. 단위 행렬을 생성할 수 있다.");
        Matrix unitMatrix = createUnitMatrix(3);
        System.out.println("기댓 값 : ");
        System.out.println(
                "[[1, 0],\n" +
                " [0, 1],");
        System.out.println("결과 값 : ");
        System.out.println(unitMatrix.toString());
        System.out.println(unitMatrix.toString().equals(
                "[[1, 0],\n" +
                " [0, 1],") ? "통과" : "실패" );
        System.out.println();

        // 11
        System.out.println("11v. 특정 위치의 요소를 지정조회할 수 있다.");
        int index = 3; // 0-based index (즉, 4번째 요소)
        System.out.println("3번에서 만든 [3, 3, 3, 3, 3, 3, 3, 3] 벡터의 4번째 요소를 지정, 조회한다.");
        System.out.println("기댓 값: 3");
        System.out.println("결과 값 : " + stringVector.get(index));
        System.out.println("4번 째 인덱스를 4로 변경한다.");
        stringVector.set(index, stringScalar);
        System.out.println("기댓 값 : [3, 3, 3, 4, 3, 3, 3, 3]");
        System.out.println("결과 값 : " + stringVector.toString());
        System.out.println(stringVector.toString().equals("[3, 3, 3, 4, 3, 3, 3, 3]") ? "통과" : "실패");
        System.out.println();

        // 11
        System.out.println("11m. 행렬의 특정 위치의 요소를 지정/조회할 수 있다.");
        int rowIndex = 1;
        int columnIndex = 1;
        System.out.println("8번에서 만든 \n" + "[[1, 2, 3],\n" +
                " [4, 5, 6]] 행렬의 \n"+"2행 2열 요소를 지정, 조회한다.");
        System.out.println("기댓 값 : 5");
        System.out.println("결과 값 : " + csvMatrix.get(rowIndex, columnIndex));
        System.out.println("2행 2열 요소를 2로 변경한다.");
        csvMatrix.set(rowIndex, columnIndex, temp1Scalar);
        System.out.println("기댓 값 : ");
        System.out.println("[[1, 2, 3],\n" +
                " [4, 2, 6]]");
        System.out.println("결과 값 : ");
        System.out.println(csvMatrix.toString());
        System.out.println(csvMatrix.toString().equals("[[1, 2, 3],\n" +
                " [4, 2, 6]]") ? "통과" : "실패");
        System.out.println();

        // 12
        System.out.println("12.스칼라 값을 지정/조회할 수 있다");
        System.out.println("1번 스칼라 값 4를 5로 지정 조회합니다.");
        stringScalar.set("5");
        System.out.println("기댓 값 : 5 ");
        System.out.println("결과 값: " + stringScalar.toString());
        System.out.println(stringScalar.get().equals("5") ? "통과" : "실패");
        System.out.println();

        // 13
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

        // 14
        System.out.println("14v. 벡터를 객체 형태로 콘솔에 출력할 수 있다.");
        System.out.println("11번 벡터를 출력합니다. ");
        System.out.println("기댓 값 : [3, 3, 3, 4, 3, 3, 3, 3]");
        System.out.println("결과 값 : " + stringVector.toString());
        System.out.println(stringVector.toString().equals("[3, 3, 3, 4, 3, 3, 3, 3]") ? "통과" : "실패");
        System.out.println();

        // 14
        System.out.println("14m. 행렬 객체를 콘솔에 출력할 수 있다.");
        System.out.println("11번에서 지정한 행렬을 출력합니다.");
        System.out.println("기댓 값 : ");
        System.out.println("[[1, 1, 1],\n" +
                " [1, 1, 1]]");
        System.out.println("결과 값 : ");
        System.out.println(stringMatrix.toString());
        System.out.println(stringMatrix.toString().equals("[[1, 1, 1],\n" +
                " [1, 1, 1]]") ? "통과" : "실패");
        System.out.println();

        // 15
        System.out.println("15s. 스칼라 객체의 동등성 판단을 할 수 있다.");
        System.out.println("비교 스칼라 1 : " + stringScalar.toString());
        Scalar compareScalar = createScalarByString("5");
        System.out.println("비교 스칼라 2 : " + compareScalar.toString());
        System.out.println(stringScalar.equals(compareScalar) ? "두 객체는 동등합니다!" : "두 객체는 동등하지 않습니다.");
        System.out.println();

        // 15
        System.out.println("15v. 객체의 동등성 판단을 할 수 있다.");
        System.out.println(stringVector + "와 " + randomVector + "을 비교합니다.");
        if (stringVector.equals(randomVector)) {
            System.out.println("두 벡터는 동등합니다.");
        } else {
            System.out.println("두 벡터는 동등하지 않습니다.");
        }
        System.out.println();


        // 15
        System.out.println("15m. 행렬 객체의 동등성 판단을 할 수 있다.");
        Scalar equalScalar = createScalarByString("1");
        Matrix equalMatrix = createMatrixByArray(new Scalar[][]{{equalScalar, equalScalar, equalScalar}, {equalScalar, equalScalar, equalScalar}}); // testMatrix와 동일
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

        // 16
        System.out.println("16. 스칼라의 경우 값의 대소비교를 할 수 있다.");
        Scalar testScalar = createScalarByString("3");
        System.out.println("기존 스칼라 : "+stringScalar);
        System.out.println("입력 스칼라 : "+testScalar);
        switch(stringScalar.compareTo(testScalar)){
            case -1 -> System.out.println("기존 스칼라가 입력 스칼라보다 작습니다.");
            case 0 -> System.out.println("두 스칼라가 동일합니다.");
            case 1 -> System.out.println("기존 스칼라가 입력 스칼라보다 큽니다.");
        }
        System.out.println();

        // 17
        System.out.println("17s. 스칼라 객체 복제를 할 수 있다.");
        System.out.println("기존 스칼라 객체 : "+stringScalar);
        Scalar cloneScalar = stringScalar.clone();
        System.out.println("복제된 스칼라 객체 : "+cloneScalar);
        System.out.println(stringScalar.equals(cloneScalar) ? "통과" : "실패");
        System.out.println();

        // 17
        System.out.println("17v. 벡터 객체 복제를 할 수 있다.");
        Vector oneVector=createVectorByString(8,"1");
        System.out.println("기존 벡터 객체 : "+oneVector);
        Vector cloneVector = oneVector.clone();
        System.out.println("복제된 벡터 객체 : "+cloneVector);
        System.out.println(cloneVector.equals(oneVector) ? "통과" : "실패");
        System.out.println();

        // 17
        System.out.println("17m. 행렬 객체 복제를 할 수 있다.");
        System.out.println("기존 행렬 객체 : \n" + csvMatrix);
        Matrix cloneMatrix = csvMatrix.clone();
        System.out.println("복제된 행렬 객체 : \n" + cloneMatrix);
        System.out.println(csvMatrix.equals(cloneMatrix) ? "통과" : "실패");
        System.out.println();

        // 18
        System.out.println("18. 스칼라는 다른 스칼라와 덧셈이 가능하다.");
        Scalar addMultiplyScalar = createScalarByString("5");
        System.out.println("기존 스칼라 : " + addMultiplyScalar.toString());
        System.out.println("더할 스칼라 : " + testScalar.toString());
        addMultiplyScalar.add(testScalar);
        System.out.println("기댓 값 : 8 ");
        System.out.println("결과 값 : " + addMultiplyScalar.toString());
        System.out.println(addMultiplyScalar.toString().equals("8") ? "통과" : "실패");
        System.out.println();

        // 19
        System.out.println("19. 스칼라는 다른 스칼라와 곱셈이 가능하다.");
        System.out.println("기존 스칼라 : " + addMultiplyScalar.toString());
        System.out.println("곱할 스칼라 : " + testScalar.toString());
        addMultiplyScalar.multiply(testScalar);
        System.out.println("기댓 값 : 24");
        System.out.println("결과 값 : " + addMultiplyScalar.toString());
        System.out.println(addMultiplyScalar.toString().equals("24") ? "통과" : "실패");
        System.out.println();

        // 20
        System.out.println("20. 벡터는 다른 벡터와 덧셈이 가능하다.(길이가 같을 때)");
        Vector addMultiplyScalarVector = createVectorByString(8,"2");
        System.out.println("기존 벡터 : " + addMultiplyScalarVector.toString());
        System.out.println("더할 벡터 : " + cloneVector.toString());
        addMultiplyScalarVector.add(cloneVector);
        System.out.println("기댓 값 : [3, 3, 3, 3, 3, 3, 3, 3]");
        System.out.println("결과 값 : " + addMultiplyScalarVector.toString());
        System.out.println(addMultiplyScalarVector.toString().equals("[3, 3, 3, 3, 3, 3, 3, 3") ? "통과" : "실패");
        System.out.println();

        // 21
        System.out.println("21. 벡터는 다른 스칼라와 곱셈이 가능하다 (모든 요소에 곱)");
        System.out.println("기존 벡터 : " + addMultiplyScalarVector.toString());
        System.out.println("곱할 스칼라 : " + testScalar.toString());
        addMultiplyScalarVector.multiply(testScalar);
        System.out.println("기댓 값 : [6, 6, 6, 6, 6, 6, 6, 6]");
        System.out.println("결과 값 : " + addMultiplyScalarVector.toString());
        System.out.println(addMultiplyScalarVector.toString().equals("[6, 6, 6, 6, 6, 6, 6, 6]") ? "통과" : "실패");
        System.out.println();

        // 22
        System.out.println("22. 행렬은 다른 행렬과 덧셈이 가능하다.");
        Matrix addMultiplyMatrix = createMatrixByCSV("1,2,3\n4,5,6");
        System.out.println("기존 행렬 :");
        System.out.println(addMultiplyMatrix.toString());
        System.out.println("덧셈 행렬 :");
        System.out.println(falseMatrix.toString());
        addMultiplyMatrix.add(falseMatrix);
        System.out.println("기댓 값 : ");
        System.out.println("[[6, 7, 8],\n" + " [9, 10, 11]]");
        System.out.println("결과 값 : ");
        System.out.println(addMultiplyMatrix.toString());
        System.out.println(addMultiplyMatrix.toString().equals("[[6, 7, 8],\n" +
                " [9, 10, 11]]") ? "통과" : "실패");
        System.out.println();

        // 23
        System.out.println("23. 행렬은 다른 행렬과 곱셈이 가능하다.");
        Matrix multi1Matrix = createMatrixByCSV("1,2\n4,5\n2,2");
        Matrix multi2Matrix = createMatrixByCSV("2,2\n1,3");
        System.out.println("기존 행렬 :");
        System.out.println(multi1Matrix.toString());
        System.out.println("곱셈 행렬 :");
        System.out.println(multi2Matrix.toString());
        multi1Matrix.multiply(multi2Matrix);
        System.out.println("기댓 값 : ");
        System.out.println("[[4, 8],\n" +
                " [13, 23],\n" +
               " [6, 10]]" );
        System.out.println("결과 값 : ");
        System.out.println(multi1Matrix.toString());
        System.out.println(multi1Matrix.toString().equals("[[4, 8],\n" +
                " [13, 23],\n" +
                " [6, 10]]") ? "통과" : "실패");
        System.out.println();

        // 24
        System.out.println("24. 전달받은 두 스칼라의 덧셈이 가능하다(새로운 객체). ");
        System.out.println("스칼라 1 : " + stringScalar.toString());
        System.out.println("스칼라 2 : " + testScalar.toString());
        // 24번의 스칼라 + 스칼라 메서드
        Scalar resultAddScalar = Tensors.addScalarByScalar(stringScalar, testScalar);
        System.out.println("기댓 값 : 8");
        System.out.println("결과 값 : " + resultAddScalar.toString());
        System.out.println(resultAddScalar.toString().equals("8") ? "통과" : "실패");
        System.out.println();

        // 25
        System.out.println("25. 전달받은 두 스칼라의 곱셈이 가능하다(새로운 객체). ");
        System.out.println("스칼라 1 : " + stringScalar.toString());
        System.out.println("스칼라 2 : " + testScalar.toString());
        // 25번의 스칼라 x 스칼라 메서드
        Scalar resultMultiplyScalar = Tensors.multiplyScalarByScalar(stringScalar, testScalar);
        System.out.println("기댓 값 : 15 ");
        System.out.println("결과 값 : " + resultMultiplyScalar.toString());
        System.out.println(resultMultiplyScalar.toString().equals("15") ? "통과" : "실패");
        System.out.println();

        // 26
        System.out.println("26. 전달받은 두 벡터의 덧셈이 가능하다.(길이가 같을 때)");
        System.out.println("벡터 1 : " + stringVector.toString());
        System.out.println("벡터 2 : " + cloneVector.toString());
        System.out.println("기댓 값 : [4, 4, 4, 5, 4, 4, 4, 4]");
        // 26번의 벡터 + 벡터 메서드
        Vector resultAddVector = Tensors.addVectorByVector(stringVector, cloneVector);
        System.out.println("결과 값 : " + resultAddVector.toString());
        System.out.println(resultAddVector.toString().equals("[4, 4, 4, 5, 4, 4, 4, 4]") ? "통과" : "실패");
        System.out.println();

        //27
        System.out.println("27. 전달받은 스칼라와 벡터의 곱셈이 가능하다.(벡터의 모든 요소에 스칼라를 곱한다)");
        System.out.println("벡터 1 : " + stringVector.toString());
        System.out.println("스칼라 1 : " + stringScalar.toString());
        System.out.println("기댓 값 : [15, 15, 15, 15, 15, 15, 15, 15]");
        // 27번의 벡터 x 스칼라 메서드
        Vector resultMultiplyVectorByScalar = Tensors.multiplyVectorByScalar(stringVector, stringScalar);
        System.out.println("결과 값 : " + resultMultiplyVectorByScalar.toString());
        System.out.println(resultMultiplyVectorByScalar.toString().equals("[15, 15, 15, 15, 15, 15, 15, 15]") ? "통과" : "실패");
        System.out.println();

        // 28
        System.out.println("28. 전달받은 두 행렬의 덧셈이 가능하다.");
        Matrix test1Matrix = createMatrixByCSV("2,3\n7,5");
        Matrix test2Matrix = createMatrixByCSV("1,1\n3,6");
        System.out.println("행렬 1 : \n" + test1Matrix.toString());
        System.out.println("행렬 2 : \n" + test2Matrix.toString());
        System.out.println("기댓 값 :\n [[3, 4],\n" + " [10, 11]]");
        // 28번의 행렬 + 행렬 메서드
        Matrix resultAddMatrix = Tensors.addMatrixByMatrix(test1Matrix, test2Matrix);
        System.out.println("결과 값 : ");
        System.out.println(resultAddMatrix.toString());
        System.out.println(resultAddMatrix.toString().equals("[[3, 4],\n" + " [10, 11]]") ? "통과" : "실패");
        System.out.println();

        // 29
        System.out.println("29. 전달받은 두 행렬의 곱셈이 가능하다.");
        System.out.println("행렬 1 : \n" + test1Matrix.toString());
        System.out.println("행렬 2 : \n" + test2Matrix.toString());
        System.out.println("기댓 값 : [[11,20],\n" +
                " [22, 37]]");
        // 29번의 행렬 x 행렬 메서드
        Matrix resultMultiplyMatrix = Tensors.multiplyMatrixByMatrix(test1Matrix, test2Matrix);
        System.out.println("결과 값 : ");
        System.out.println(resultMultiplyMatrix.toString());
        System.out.println(resultMultiplyMatrix.toString().equals("[[11, 20],\n" +
                " [22, 37]]") ? "통과" : "실패");
        System.out.println();

        // 30
        System.out.println("30. n-차원 벡터 객체는 자신으로부터 nx1 행렬을 생성하여 반환할 수 있다.");
        System.out.println("반환할 벡터 : " + stringVector.toString());
        Matrix VectorToColumnMatrix = stringVector.toColumnMatrix();
        System.out.println("기댓 값 : \n [[3],\n" +
                " [3],\n" +
                " [3],\n" +
                " [4],\n" +
                " [3],\n" +
                " [3],\n" +
                " [3],\n" +
                " [3]]");
        System.out.println("벡터를 nx1으로 변형한 행렬(결과 값) : ");
        System.out.println(VectorToColumnMatrix);
        System.out.println(VectorToColumnMatrix.toString().equals("[[3],\n" +
                " [3],\n" +
                " [3],\n" +
                " [4],\n" +
                " [3],\n" +
                " [3],\n" +
                " [3],\n" +
                " [3]]") ? "통과" : "실패");
        System.out.println();

        // 31
        System.out.println("31. n-차원 벡터 객체는 자신으로부터 1xn 행렬을 생성하여 반환할 수 있다.");
        System.out.println("반환할 벡터 : " + stringVector.toString());
        Matrix VectorToRowMatrix = stringVector.toRowMatrix();
        System.out.println("기댓 값 : [[3, 3, 3, 4, 3, 3, 3, 3]]");
        System.out.println("벡터를 nx1으로 변형한 행렬(결과 값) : " + VectorToRowMatrix);
        System.out.println(VectorToRowMatrix.toString().equals("[[3, 3, 3, 4, 3, 3, 3, 3]]") ? "통과" : "실패");
        System.out.println();

        //행렬 생성
        Matrix tMatrix=createUnitMatrix(2);
        Matrix t2Matrix=createUnitMatrix(2);
        Matrix t3Matrix=createUnitMatrix(2);

        // 32
        System.out.println("32. 행렬은 다른 행렬과 가로로 합쳐질 수 있다.");
        System.out.println("기존 행렬 : \n"+ tMatrix);
        System.out.println("추가할 행렬 : \n"+ t2Matrix);
        System.out.println("기댓 값 :\n [[1, 0, 1, 0],\n" +
                " [0, 1, 0, 1]]");
        System.out.println("합쳐진 행렬(결과 값) : \n"+ tMatrix.widthPaste(t2Matrix));
        System.out.println(tMatrix.toString().equals("[[1, 0, 1, 0],\n" +
                " [0, 1, 0, 1]]") ? "통과" : "실패");
        tMatrix=createUnitMatrix(2); //다음 연산을 위해 초기화
        System.out.println();

        System.out.println("32-1. 디폴트 static 메소드 호출");
        System.out.println("행렬 1 : \n"+ tMatrix);
        System.out.println("행렬 2 : \n"+ t2Matrix);
        System.out.println("기댓 값 : [[1, 0, 1, 0],\n" +
                " [0, 1, 0, 1]]");
        // 32번의 행렬 결합 메서드 (가로)
        Matrix widthMatrix = Tensors.combineToWidthMatrixByMatrix(tMatrix, t2Matrix);
        System.out.println("합쳐진 행렬(결과 값) : \n"+ widthMatrix);
        System.out.println(widthMatrix.toString().equals("[[1, 0, 1, 0],\n" +
                " [0, 1, 0, 1]]") ? "통과" : "실패");
        System.out.println();

        // 33
        System.out.println("33. 행렬은 다른 행렬과 세로로 합쳐질 수 있다.");
        System.out.println("기존 행렬 : \n"+ tMatrix);
        System.out.println("추가할 행렬 : \n"+ t2Matrix);
        System.out.println("기댓 값 :\n[[1, 0],\n" +
                " [0, 1],\n" + " [1, 0],\n" + " [0, 1]]");
        System.out.println("합쳐진 행렬(결과 값) : \n" + t2Matrix.heightPaste(t3Matrix));
        System.out.println(t2Matrix.toString().equals("[[1, 0],\n" +
                " [0, 1],\n" +
                " [1, 0],\n" +
                " [0, 1]]") ? "통과" : "실패");
        t2Matrix=createUnitMatrix(2);   //다음 연산을 위해 초기화
        System.out.println();

        System.out.println("33-1. 디폴트 static 메소드 호출");
        System.out.println("기존 행렬 : \n"+ tMatrix);
        System.out.println("추가할 행렬 : \n"+ t2Matrix);
        // 33-1 두 행렬 결합 메서드 (세로)
        Matrix heightMatrix = Tensors.combineToHeightMatrixByMatrix(tMatrix, t2Matrix);
        System.out.println("기댓 값 : \n[[1, 0],\n" +
                " [0, 1],\n" +
                " [1, 0],\n" +
                " [0, 1]]");
        System.out.println("합쳐진 행렬(결과 값) : \n" + heightMatrix);
        System.out.println(heightMatrix.toString().equals("[[1, 0],\n" +
                " [0, 1],\n" +
                " [1, 0],\n" +
                " [0, 1]]") ? "통과" : "실패");
        System.out.println();

        Matrix test3Matrix = createMatrixByCSV("3,5\n2,3");

        // 34
        System.out.println("34. 행렬은 특정 행을 벡터 형태로 추출해 줄 수 있다.");
        System.out.println("기존 행렬 : \n"+ test3Matrix);
        System.out.println("추출할 행 : 1");
        Vector rowVec=test3Matrix.rowVector(1);
        System.out.println("기댓 값 : [3, 5]");
        System.out.println("추출한 벡터(결과 값) : \n"+rowVec);
        System.out.println(rowVec.toString().equals("[3, 5]") ? "통과" : "실패");
        System.out.println();

        // 35
        System.out.println("35. 행렬은 특정 열을 벡터 형태로 추출해 줄 수 있다");
        Matrix test4Matrix = createMatrixByCSV("3,5\n2,3");
        System.out.println("기존 행렬 : \n"+ test4Matrix);
        System.out.println("추출할 열 : 1");
        Vector colVec = test4Matrix.colVector(1);
        System.out.println("기댓 값 : [3, 2]");
        System.out.println("추출한 벡터(결과 값) : \n"+ colVec);
        System.out.println(colVec.toString().equals("[3, 2]") ? "통과" : "실패");
        System.out.println();

        // 36
        System.out.println("36. 행렬은 시작 행과 끝 행 인덱스로 특정 범위의 부분 행렬을 추출해 줄 수 있다.");
        Matrix test5Matrix = createMatrixByCSV(
                "3,7,1,0\n" +
                        "2,9,4,6\n" +
                        "5,8,0,3\n" +
                        "1,2,7,4"
        );
        System.out.println("기존 행렬 : \n"+ test5Matrix);
        System.out.println("시작 행 인덱스 : 1 , 끝 행 인덱스 : 2");
        System.out.println("시작 열 인덱스 : 2 , 끝 열 인덱스 : 3");
        Matrix absMatrix = test5Matrix.getSubMatrix(1,2,2,3);
        System.out.println("기댓 값 : \n[[7, 1]\n [9, 4]]");
        System.out.println("추출한 행렬(결과 값) : \n" + absMatrix);
        System.out.println(absMatrix.toString().equals("[[7, 1]\n [9, 4]]") ? "통과" : "실패");
        System.out.println();

        // 37
        System.out.println("37. 행렬은 지정 행 제외, 특정 범위의 부분 행렬을 추출해 줄 수 있다.");
        System.out.println("기존 행렬 : \n"+ test5Matrix);
        System.out.println("지정 행 : 3 , 지정 열 : 3");
        Matrix absOtherMatrix=test5Matrix.getMinor(1,1);
        System.out.println("기댓 값 : \n[[3, 7, 0],\n [2, 9, 6],\n [1, 2, 4]]");
        System.out.println("추출한 행렬(결과 값) : \n"+ absOtherMatrix);
        System.out.println(absOtherMatrix.toString().equals("[[3, 7, 0],\n [2, 9, 6],\n [1, 2, 4]]") ? "통과" : "실패");
        System.out.println();

        // 38
        System.out.println("38. 행렬은 전치행렬을 구현해 줄 수 있다.");
        System.out.println("기존 행렬 : \n"+ test5Matrix);
        Matrix transposedMatrix = tMatrix.transpose();
        System.out.println("기댓 값 : \n[[3, 7, 1, 0],\n" +
                "  [2, 9, 4, 6],\n" +
                "  [5, 8, 0, 3],\n" +
                "  [1, 2, 7, 4]]");
        System.out.println("전치 행렬(결과 값) : \n"+ transposedMatrix);
        System.out.println(transposedMatrix.toString().equals("[[3, 7, 1, 0],\n" +
                "  [2, 9, 4, 6],\n" +
                "  [5, 8, 0, 3],\n" +
                "  [1, 2, 7, 4]]") ? "통과" : "실패");
        System.out.println();

        // 39
        System.out.println("39. 행렬은 대각 요소의 합을 구해줄 수 있다.");
        System.out.println("기존 행렬 : \n"+ test5Matrix);
        Scalar oppositeScalar=test5Matrix.trace();
        System.out.println("기댓 값 : 16");
        System.out.println("대각 요소의 합(결과 값) : \n"+ oppositeScalar);
        System.out.println(oppositeScalar.toString().equals("16") ? "통과" : "실패");
        System.out.println();

// 테스트용 생성
        Scalar s0 = createScalarByString("0");
        Scalar s1 = createScalarByString("3");
        Scalar s2 = createScalarByString("5");
        Scalar s3 = createScalarByString("1");
        Scalar s5 = createScalarByString("4");
        Matrix squareMatrix = createMatrixByArray(new Scalar[][]{{s1, s2}, {s0, s5}});
        Matrix nonSquareMatrix = createMatrixByCSV("1,0\n0,1\n0,0");
        Matrix upperTriMatrix = createMatrixByArray(new Scalar[][]{{s1, s2, s5}, {s0, s1, s2}, {s0, s0, s1}});
        Matrix lowerTriMatrix = createMatrixByArray(new Scalar[][]{{s1, s0, s0}, {s2, s1, s0}, {s5, s2, s1}});
        Matrix identityTestMatrix = createUnitMatrix(3);
        Matrix zeroTestMatrix = createMatrixByTypeNum("0", 2, 2);

        // 40
        System.out.println("40. 정사각 행렬 판별");
        System.out.println(squareMatrix.toString());
        System.out.println("  -> squareMatrix (2x2)는 정사각 행렬인가? " + squareMatrix.isSquare());
        System.out.println(nonSquareMatrix.toString());
        System.out.println("  -> nonSquareMatrix (3x2)는 정사각 행렬인가? " + nonSquareMatrix.isSquare());
        System.out.println();

        // 41
        System.out.println("41. 상삼각 행렬 판별");
        System.out.println(upperTriMatrix.toString());
        System.out.println("  -> upperTriMatrix는 상삼각 행렬인가? " + upperTriMatrix.isUpperTriangular());
        System.out.println(lowerTriMatrix.toString());
        System.out.println("  -> lowerTriMatrix는 상삼각 행렬인가? " + lowerTriMatrix.isUpperTriangular());
        System.out.println(squareMatrix.toString());
        System.out.println("  -> squareMatrix는 상삼각 행렬인가? " + squareMatrix.isUpperTriangular());
        System.out.println();

        // 42
        System.out.println("42. 하삼각 행렬 판별");
        System.out.println(lowerTriMatrix.toString());
        System.out.println("  -> lowerTriMatrix는 하삼각 행렬인가? " + lowerTriMatrix.isLowerTriangular());
        System.out.println(upperTriMatrix.toString());
        System.out.println("  -> upperTriMatrix는 하삼각 행렬인가? " + upperTriMatrix.isLowerTriangular());
        System.out.println(squareMatrix.toString());
        System.out.println("  -> squareMatrix는 하삼각 행렬인가? " + squareMatrix.isLowerTriangular());
        System.out.println();

        // 43
        System.out.println("43. 단위 행렬 판별");
        System.out.println(identityTestMatrix.toString());
        System.out.println("  -> identityTestMatrix는 단위 행렬인가? " + identityTestMatrix.isIdentity());
        System.out.println(squareMatrix.toString());
        System.out.println("  -> squareMatrix는 단위 행렬인가? " + squareMatrix.isIdentity());
        System.out.println();

        // 44
        System.out.println("44. 영 행렬 판별");
        System.out.println(zeroTestMatrix.toString());
        System.out.println("  -> zeroTestMatrix는 영 행렬인가? " + zeroTestMatrix.isZero());
        System.out.println(identityTestMatrix.toString());
        System.out.println("  -> identityTestMatrix는 영 행렬인가? " + identityTestMatrix.isZero());
        System.out.println();

        Matrix matrixForOps = createMatrixByCSV("11,12,13\n14,15,16\n17,18,19");

        // 45
        System.out.println("45. 행 교환");
        Matrix aMatrixForOps = matrixForOps.clone();
        System.out.println("교환 전 (1행과 3행 교환): \n" + aMatrixForOps);
        aMatrixForOps.swapRows(0, 2);
        System.out.println("기댓 값 : \n[[17, 18, 19],\n" +
                " [14, 15, 16],\n" +
                " [11, 12, 13]]");
        System.out.println("교환 후(결과 값): \n" + aMatrixForOps);
        System.out.println(aMatrixForOps.toString().equals("[[17, 18, 19],\n" +
                " [14, 15, 16],\n" +
                " [11, 12, 13]]") ? "통과" : "실패");
        System.out.println();

        // 46
        System.out.println("46. 열 교환");
        Matrix bMatrixForOps = matrixForOps.clone();
        System.out.println("교환 전 (1열과 2열 교환): \n" + bMatrixForOps);
        bMatrixForOps.swapColumns(0, 1);
        System.out.println("기댓 값 : \n[[12, 11, 13],\n" +
                " [15, 14, 16],\n" +
                " [18, 17, 19]]");
        System.out.println("교환 후 (결과 값) : \n" + bMatrixForOps);
        System.out.println(bMatrixForOps.toString().equals("[[12, 11, 13],\n" +
                " [15, 14, 16],\n" +
                " [18, 17, 19]]") ? "통과" : "실패");
        System.out.println();

        // 47
        System.out.println("47. 특정 행에 스칼라 곱");
        Matrix cMatrixForOps = matrixForOps.clone();
        System.out.println("연산 전 (3행에 스칼라 \"" + s2 + "\" 곱): \n" + cMatrixForOps);
        cMatrixForOps.scaleRow(1, s2);
        System.out.println("기댓 값 : \n[[11, 12, 13],\n" +
                " [14, 15, 16],\n" +
                " [85, 90, 95]]");
        System.out.println("연산 후 (결과 값) : \n" + cMatrixForOps);
        System.out.println(cMatrixForOps.toString().equals("[[11, 12, 13],\n" +
                " [14, 15, 16],\n" +
                " [85, 90, 95]]") ? "통과" : "실패");
        System.out.println();

        // 48
        System.out.println("48. 특정 열에 스칼라 곱");
        Scalar reS3 = createScalarByString("3");
        Matrix dMatrixForOps = matrixForOps.clone();
        System.out.println("연산 전 (2열에 스칼라 \"" + reS3 + "\" 곱) : \n" + dMatrixForOps);
        dMatrixForOps.scaleColumn(2, reS3);
        System.out.println("기댓 값 : \n[[11, 36, 13],\n" +
                " [14, 45, 16],\n" +
                " [17, 54, 19]]");
        System.out.println("연산 후 (결과 값) : \n" + dMatrixForOps);
        System.out.println(dMatrixForOps.toString().equals("[[11, 36, 13],\n" +
                " [14, 45, 16],\n" +
                " [17, 54, 19]]") ? "통과" : "실패");
        System.out.println();

        // 49
        System.out.println("49. 특정 행에 다른 행의 상수배를 더하기");
        Matrix eMatrixForOps = matrixForOps.clone();
        Scalar reS2 = createScalarByString("2");
        System.out.println("연산 전 (1행 += 2행 * \"" + reS2 + "\") : \n" + eMatrixForOps);
        eMatrixForOps.addRowMultiple(0, 1, reS2);
        System.out.println("기댓 값 : \n[[39, 42, 45],\n" +
                " [14, 15, 16],\n" +
                " [17, 18, 19]]");
        System.out.println("연산 후 (결과 값) : \n" + eMatrixForOps);
        System.out.println(eMatrixForOps.toString().equals("[[39, 42, 45],\n" +
                " [14, 15, 16],\n" +
                " [17, 18, 19]]") ? "통과" : "실패");
        System.out.println();

        // 50
        System.out.println("50. 특정 열에 다른 열의 상수배를 더하기");
        Matrix fMatrixForOps = matrixForOps.clone();
        System.out.println("연산 전 (3열 += 1열 * \"" + reS3 + "\") : \n" + fMatrixForOps);
        fMatrixForOps.addColumnMultiple(0, 1, reS3);
        System.out.println("기댓 값 : \n[[11, 12, 46],\n" +
                " [14, 15, 58],\n" +
                " [17, 18, 70]]");
        System.out.println("연산 후 (결과 값) : \n" + fMatrixForOps);
        System.out.println(fMatrixForOps.toString().equals("[[11, 12, 46],\n" +
                " [14, 15, 58],\n" +
                " [17, 18, 70]]") ? "통과" : "실패");
        System.out.println();

        // 51
        System.out.println("51. 행렬을 RREF 형태로 변환하기");
        Matrix rrefMatrix = matrixForOps.clone();
        System.out.println("연산 전 행렬: \n" + rrefMatrix);
        Matrix resultRREF = rrefMatrix.getRREF();
        System.out.println("기댓 값 : \n[[1, 0, -1],\n" +
                " [0, 1, 2],\n" +
                " [0, 0, 0]]");
        System.out.println("연산 후 (결과 값) : \n" + resultRREF);
        System.out.println(resultRREF.toString().equals("[[1, 0, -1],\n" +
                " [0, 1, 2],\n" +
                " [0, 0, 0]]") ? "통과" : "실패");
        System.out.println();

        // 52
        System.out.println("52. RREF 행렬인지 여부 판별");
        System.out.println("유효한 행렬: \n" + resultRREF);
        System.out.println("기댓 값 : true");
        System.out.println("판별 결과 : " + resultRREF.isRREF());
        System.out.println( (resultRREF.isRREF()) ? "통과" : "실패");
        System.out.println();

        System.out.println("유효하지 않은 행렬: \n" + matrixForOps);
        System.out.println("기댓 값 : false");
        System.out.println("판별 결과 : " + matrixForOps.isRREF());
        System.out.println( !(resultRREF.isRREF()) ? "통과" : "실패");
        System.out.println();

        String invFile = "1,2\n5,6";
        Matrix invMatrix = createMatrixByCSV(invFile);

        // 53
        System.out.println("53. 자신의 행렬식 구하기");
        System.out.println("입력 행렬: \n" + invMatrix);
        System.out.println("기댓 값 : -4");  // 예: 직접 계산한 determinant 값
        System.out.println("결과 값 : " + invMatrix.determinant());
        System.out.println(invMatrix.determinant().equals("-4") ? "통과" : "실패");
        System.out.println();

        // 54
        System.out.println("54. 자신의 역행렬 구하기");
        System.out.println("입력 행렬: \n" + invMatrix);
        Matrix resultInverse = invMatrix.inverse();
        System.out.println("기댓 값 : \n[[-1.5, 0.5],\n" +
                " [1.25, -0.25]]"  );
        System.out.println("연산 후 (결과 값) : \n" + resultInverse);
        System.out.println(resultInverse.toString().equals("[[-1.5, 0.5],\n" +
                " [1.25, -0.25]]") ? "통과" : "실패");
        System.out.println();*/
    }
}
