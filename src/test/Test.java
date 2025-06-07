package test;
import java.math.BigDecimal;
import tensor.*;

import static tensor.Factory.*;

public class Test {
    public static void main(String[] args) {
        // 01.값(String)을 지정하여 스칼라를 생성할 수 있다.
        System.out.println("01. String 값을 지정하여 스칼라를 생성할 수 있다");
        Scalar stringScalar = createScalarByString("1");  // 01.
        System.out.println("기댓 값 : 1");
        System.out.println("결과 값 : " + stringScalar);
        System.out.println(stringScalar.get().equals("1") ? "통과" : "실패");
        System.out.println();

        // 02. i이상 j미만의 무작위 값을 요소로 하는 스칼라를 생성할 수 있다
        System.out.println("02. i이상 j미만의 무작위 값을 요소로 하는 스칼라를 생성할 수 있다.");
        Scalar randomScalar = createScalarByRandom(1, 3);          // 02.
        System.out.println("기댓 값 : (1과 3 사이의 스칼라 값)");
        System.out.println("결과 값 : " + randomScalar);
        System.out.println(randomScalar.getBigDecimalValue().compareTo(new BigDecimal("1"))>=0 &&
                randomScalar.getBigDecimalValue().compareTo(new BigDecimal("3"))<0 ? "통과" : "실패");
        System.out.println();

        // 03. 지정한 하나의 값을 모든 요소에 순서대로 하는 n-차원 벡터를 생성할 수 있다.
        System.out.println("03. 지정한 하나의 값을 모든 요소의 값으로 하는 차원 벡터를 생성할 수 있다.");
        Vector stringVector = createVectorByString(2,"1");  // 03.
        System.out.println("기댓 값 : [1, 1]");
        System.out.println("결과 값 : " + stringVector);
        System.out.println(stringVector.toString().equals("[1, 1]") ? "통과" : "실패");
        System.out.println();

        // 04. i 이상 j 미만의 무작위 값을 요소로 하는 n-차원 벡터를 생성할 수 있다.
        System.out.println("04. i 이상 j 미만의 무작위 값을 요소로 하는 차원 벡터를 생성할 수 있다.");
        Vector randomVector = createVectorByRandom(3,1, 3);  // 04.
        boolean isValid=true;
        System.out.println("기댓 값 : (1과 3사이의 하나의 실수 값으로 이뤄진 3차원 벡터)");
        System.out.println("결과 값 : " + randomVector);
        for(int i=0; i<3; i++){
            if(randomVector.get(i).getBigDecimalValue().compareTo(new BigDecimal("1"))<0 ||
                    randomVector.get(i).getBigDecimalValue().compareTo(new BigDecimal("3"))>=0){
                System.out.println(i+"번째 요소가 조건을 만족하지 않습니다.");
                isValid=false;
                break;
            }
        }
        System.out.println(isValid ? "통과" : "실패");
        System.out.println();

        // 05.1차원 배열로부터 n-차원 벡터를 생성할 수 있다.
        System.out.println("05. 차원 배열로부터 차원 벡터를 생성할 수 있다.");
        BigDecimal[] arr = {
                new BigDecimal("1"),
                new BigDecimal("1"),
                new BigDecimal("3")
        };
        Vector arrVector = createVectorByArray(arr);
        System.out.println("기댓 값 : [1, 1, 3]");
        System.out.println("결과 값 : " + arrVector);
        System.out.println(arrVector.toString().equals("[1, 1, 3]") ? "통과" : "실패");
        System.out.println();

        // 06. 지정한 하나의 값을 모든 요소에 순서대로 하는 m×n 행렬을 생성할 수 있다.
        Matrix stringMatrix = createMatrixByTypeNum("1.2", 2, 2);
        System.out.println("06. 지정된 하나의 값을 모든 요소의 값으로 하는 mxn 행렬을 생성할 수 있다.");
        System.out.println("기댓 값 : ");
        System.out.println("[[1.2, 1.2],\n" +
                " [1.2, 1.2]]");
        System.out.println("결과 값 : ");
        System.out.println(stringMatrix.toString());
        System.out.println(stringMatrix.toString().equals("[[1.2, 1.2],\n" +
                " [1.2, 1.2]]") ? "통과" : "실패");
        System.out.println();

        // 07. i 이상 j 미만의 무작위 값을 요소로 하는 m×n 행렬을 생성할 수 있다.
        System.out.println("07. i 이상 j 미만의 무작위 값을 요소로 하는 mxn 행렬을 생성할 수 있다.");
        Matrix randomMatrix = createMatrixRandom(1,2, 2, 3);
        System.out.println("기댓 값 : ");
        System.out.println("(1, 2 사이의 임의의 실수 값으로 이루어진 2 x 3 행렬)");
        System.out.println("결과 값 : ");
        System.out.println(randomMatrix.toString());
        isValid=true;
        for(int i=0; i<2; i++) {
            for(int j=0; j<3; j++) {
            if (randomMatrix.get(i, j).getBigDecimalValue().compareTo(new BigDecimal("1")) < 0 ||
                    randomMatrix.get(i, j).getBigDecimalValue().compareTo(new BigDecimal("2")) >= 0) {
                System.out.println(i + "행 "+ j + "열 요소가 조건을 만족하지 않습니다.");
                isValid = false;
                break;
            }
            if (!isValid)
                break;
            }
        }
        System.out.println(isValid ? "통과" : "실패");
        System.out.println();

        // 08. csv 파일로부터 m×n 행렬을 생성할 수 있다.
        System.out.println("08. csv파일로부터 mxn 행렬을 생성할 수 있다.");
        String csvFile = "1,3,5\n1,3,5";
        Matrix csvMatrix = createMatrixByCSV(csvFile);
        System.out.println("기댓 값 : ");
        System.out.println("[[1, 3, 5],\n" +
                " [1, 3, 5]]");
        System.out.println("결과 값 : ");
        System.out.println(csvMatrix.toString());
        System.out.println(csvMatrix.toString().equals("[[1, 3, 5],\n" +
                " [1, 3, 5]]") ? "통과" : "실패");
        System.out.println();

        // 09. 2차원 배열로부터 m×n 행렬을 생성할 수 있다.
        System.out.println("09. 2차원 배열로부터 mxn 행렬을 생성할 수 있다.");
        Scalar[][] arrayData = {{stringScalar, stringScalar}, {stringScalar, stringScalar}};
        Matrix arrayMatrix = createMatrixByArray(arrayData);
        System.out.println("기댓 값 : ");
        System.out.println("[[1, 1],\n" +
                " [1, 1]]");
        System.out.println("결과 값 : ");
        System.out.println(arrayMatrix.toString());
        System.out.println(arrayMatrix.toString().equals("[[1, 1],\n" +
                " [1, 1]]") ? "통과" : "실패");
        System.out.println();

        // 10. 단위 행렬을 생성할 수 있다.
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

        // 11. 특정 위치의 요소를 지정/조회할 수 있다.
        System.out.println("11v. 특정 위치의 요소를 지정조회할 수 있다.");
        int index = 0; // 0-based index (즉, 1번째 요소)
        System.out.println("3번에서 만든 [1, 1] 벡터의 1번째 요소를 조회한다.");
        System.out.println("기댓 값 : 1");
        System.out.println("결과 값 : " + stringVector.get(index));
        System.out.println("1번 째 인덱스를 7로 변경한다.");
        stringVector.set(index, createScalarByString("7"));
        System.out.println("기댓 값 : [7, 1]");
        System.out.println("결과 값 : " + stringVector.toString());
        System.out.println(stringVector.toString().equals("[7, 1]") ? "통과" : "실패");
        System.out.println();

        System.out.println("11m. 행렬의 특정 위치의 요소를 지정/조회할 수 있다.");
        int rowIndex = 0;
        int columnIndex = 1;
        System.out.println("6번에서 만든 \n" + "[[1.2, 1.2],\n" +
                " [1.2, 1.2]] 행렬의 \n"+"1행 2열 요소를 지정, 조회한다.");
        System.out.println("기댓 값 : 1.2");
        System.out.println("결과 값 : " + stringMatrix.get(rowIndex, columnIndex));
        System.out.println("1행 2열 요소를 1로 변경한다.");
        stringMatrix.set(rowIndex, columnIndex, stringScalar);
        System.out.println("기댓 값 : ");
        System.out.println("[[1.2, 1],\n" +
                " [1.2, 1.2]]");
        System.out.println("결과 값 : ");
        System.out.println(stringMatrix.toString());
        System.out.println(stringMatrix.toString().equals("[[1.2, 1],\n" +
                " [1.2, 1.2]]") ? "통과" : "실패");
        System.out.println();

        // 12. 특정 위치의 요소를 지정/조회할 수 있다.
        System.out.println("12.스칼라 값을 지정/조회할 수 있다");
        System.out.println("1번 스칼라 값 1을 3으로 지정 조회합니다.");
        stringScalar.set("3");
        System.out.println("기댓 값 : 3 ");
        System.out.println("결과 값 : " + stringScalar.toString());
        System.out.println(stringScalar.get().equals("3") ? "통과" : "실패");
        System.out.println();

        // 13. 크기 정보를 조회할 수 있다
        System.out.println("13v. 크기 정보를 조회할 수 있다");
        System.out.println("11번에서 생성한 벡터의 크기 정보(차원)을 조회합니다");
        System.out.println("기댓 값 : 2");
        System.out.println("결과 값 : " + stringVector.getDimensionCount());
        System.out.println(stringVector.getDimensionCount()==2 ? "통과" : "실패");
        System.out.println();


        System.out.println("13m. 행렬의 크기 정보를 조회할 수 있다.");
        System.out.println("11번에서 지정한 행렬의 행 개수, 열 개수를 조회합니다");
        System.out.println("기댓 값 : 2, 3");
        System.out.println("결과 값 : " + csvMatrix.getRowCount() +", "+ csvMatrix.getColumnCount());
        System.out.println(csvMatrix.getRowCount() == 2 && csvMatrix.getColumnCount() == 3 ? "통과" : "실패");
        System.out.println();

        // 14. 값을 출력할 수 있다.
        System.out.println("14s.스칼라 객체를 콘솔에 출력할 수 있다.");
        System.out.println("12번에서 생성한 스칼라를 출력합니다");
        System.out.println("기댓 값 : 3 ");
        System.out.println("결과 값 : " + stringScalar.toString());
        System.out.println(stringScalar.get().equals("3") ? "통과" : "실패");
        System.out.println();

        System.out.println("14v. 벡터를 객체 형태로 콘솔에 출력할 수 있다.");
        System.out.println("11번 벡터를 출력합니다. ");
        System.out.println("기댓 값 : [7, 1]");
        System.out.println("결과 값 : " + stringVector.toString());
        System.out.println(stringVector.toString().equals("[7, 1]") ? "통과" : "실패");
        System.out.println();

        System.out.println("14m. 행렬 객체를 콘솔에 출력할 수 있다.");
        System.out.println("11번에서 지정한 행렬을 출력합니다.");
        System.out.println("기댓 값 : ");
        System.out.println("[[1, 3, 5],\n" +
                " [1, 3, 5]]");
        System.out.println("결과 값 : ");
        System.out.println(csvMatrix.toString());
        System.out.println(csvMatrix.toString().equals("[[1, 3, 5],\n" +
                " [1, 3, 5]]") ? "통과" : "실패");
        System.out.println();

        // 15. 객체의 동등성 판단을 할 수 있다.
        System.out.println("15s. 스칼라 객체의 동등성 판단을 할 수 있다.");
        System.out.println("비교 스칼라 1 : " + stringScalar.toString());
        Scalar compareScalar = createScalarByString("3");
        System.out.println("비교 스칼라 2 : " + compareScalar.toString());
        System.out.println(stringScalar.equals(compareScalar) ? "두 객체는 동등합니다!" : "두 객체는 동등하지 않습니다.");
        System.out.println("비교 스칼라 1 : " + stringScalar.toString());
        System.out.println("비교 스칼라 2 : " + randomScalar.toString());
        System.out.println(stringScalar.equals(randomScalar) ? "두 객체는 동등합니다!" : "두 객체는 동등하지 않습니다.");
        System.out.println(stringScalar.equals(compareScalar) && !stringScalar.equals(randomScalar) ? "통과" : "실패");
        System.out.println();

        System.out.println("15v. 객체의 동등성 판단을 할 수 있다.");
        Vector equalVector= createVectorByArray(new BigDecimal[]{new BigDecimal("7"),new BigDecimal("1")});
        System.out.println("비교 벡터 1 : " + equalVector.toString());
        System.out.println("비교 벡터 2 : " + stringVector.toString());
        System.out.println(stringVector.equals(equalVector) ? "두 객체는 동등합니다!" : "두 객체는 동등하지 않습니다.");
        System.out.println("비교 벡터 1 : " + stringVector.toString());
        System.out.println("비교 벡터 2 : " + randomVector.toString());
        System.out.println(stringVector.equals(randomVector) ? "두 객체는 동등합니다!" : "두 객체는 동등하지 않습니다.");
        System.out.println(stringVector.equals(equalVector) && !stringVector.equals(randomVector) ? "통과" : "실패");

        System.out.println();


        System.out.println("15m. 행렬 객체의 동등성 판단을 할 수 있다.");
        Scalar newScalar=createScalarByString("1.2");
        Matrix falseMatrix = createMatrixByArray(new Scalar[][]{{compareScalar, compareScalar}, {compareScalar, compareScalar}});
        Matrix equalMatrix = createMatrixByArray(new Scalar[][]{{newScalar, stringScalar}, {newScalar, newScalar}});

        System.out.println("비교 행렬 1 : " );
        System.out.println(stringMatrix.toString());
        System.out.println("비교 행렬 2 : ");
        System.out.println(equalMatrix.toString());
        System.out.println(stringMatrix.equals(equalMatrix) ? "두 객체는 동등합니다!" : "두 객체는 동등하지 않습니다.");
        System.out.println("비교 행렬 1 : " );
        System.out.println(stringMatrix.toString());
        System.out.println("비교 행렬 2 : ");
        System.out.println(falseMatrix.toString());
        System.out.println(stringMatrix.equals(falseMatrix) ? "두 객체는 동등합니다!" : "두 객체는 동등하지 않습니다.");
        System.out.println(stringMatrix.equals(equalMatrix) && !stringMatrix.equals(falseMatrix) ? "통과" : "실패");
        System.out.println();

        // 16.값의 대소비교를 할 수 있다.
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

        // 17. 객체 복제를 할 수 있다.
        System.out.println("17s. 스칼라 객체 복제를 할 수 있다.");
        System.out.println("기존 스칼라 객체 : "+stringScalar);
        Scalar cloneScalar = stringScalar.clone();
        System.out.println("복제된 스칼라 객체 : "+cloneScalar);
        System.out.println(cloneScalar.equals(stringScalar)? "통과" : "실패");
        System.out.println();

        System.out.println("17v. 벡터 객체 복제를 할 수 있다.");
        Vector threeVector=createVectorByString(4,"3");
        System.out.println("기존 벡터 객체 : "+threeVector);
        Vector cloneVector = threeVector.clone();
        System.out.println("복제된 벡터 객체 : "+cloneVector);
        System.out.println(cloneVector.equals(threeVector) ? "통과" : "실패");
        System.out.println();

        System.out.println("17m. 행렬 객체 복제를 할 수 있다.");
        Matrix cMatrix=createMatrixByTypeNum("2",2,2);
        System.out.println("기존 행렬 객체 : \n" +cMatrix);
        Matrix cloneMatrix = cMatrix.clone();
        System.out.println("복제된 행렬 객체 : \n" + cloneMatrix);
        System.out.println(cMatrix.equals(cloneMatrix) ? "통과" : "실패");
        System.out.println();

        // 18. 스칼라는 다른 스칼라와 덧셈이 가능하다.
        System.out.println("18. 스칼라는 다른 스칼라와 덧셈이 가능하다.");
        Scalar exScalar = createScalarByString("5");
        System.out.println("기존 스칼라 : " + exScalar.toString());
        System.out.println("더할 스칼라 : " + testScalar.toString());
        exScalar.add(testScalar);
        System.out.println("기댓 값 : 7 ");
        System.out.println("결과 값 : " + exScalar.toString());
        System.out.println(exScalar.toString().equals("7") ? "통과" : "실패");
        System.out.println();

        // 19. 스칼라는 다른 스칼라와 곱셈이 가능하다.
        System.out.println("19. 스칼라는 다른 스칼라와 곱셈이 가능하다.");
        System.out.println("기존 스칼라 : " + exScalar.toString());
        System.out.println("곱할 스칼라 : " + testScalar.toString());
        exScalar.multiply(testScalar);
        System.out.println("기댓 값 : 14");
        System.out.println("결과 값 : " + exScalar.toString());
        System.out.println(exScalar.toString().equals("14") ? "통과" : "실패");
        System.out.println();

        // 20. 벡터는 다른 벡터와 덧셈이 가능하다.
        System.out.println("20. 벡터는 다른 벡터와 덧셈이 가능하다.(길이가 같을 때)");
        Vector exVector = createVectorByString(4,"2");
        System.out.println("기존 벡터 : " + exVector.toString());
        System.out.println("더할 벡터 : " + cloneVector.toString());
        exVector.add(cloneVector);
        System.out.println("기댓 값 : [5, 5, 5, 5]");
        System.out.println("결과 값 : " + exVector.toString());
        System.out.println(exVector.toString().equals("[5, 5, 5, 5]") ? "통과" : "실패");
        System.out.println();

        // 21. 벡터는 다른 스칼라와 곱셈이 가능하다
        System.out.println("21. 벡터는 다른 스칼라와 곱셈이 가능하다 (모든 요소에 곱)");
        System.out.println("기존 벡터 : " + exVector.toString());
        System.out.println("곱할 스칼라 : " + testScalar.toString());
        exVector.multiply(testScalar);
        System.out.println("기댓 값 : [10, 10, 10, 10]");
        System.out.println("결과 값 : " + exVector.toString());
        System.out.println(exVector.toString().equals("[10, 10, 10, 10]") ? "통과" : "실패");
        System.out.println();

        // 22. 행렬은 다른 행렬과 덧셈이 가능하다
        System.out.println("22. 행렬은 다른 행렬과 덧셈이 가능하다.");
        Matrix exMatrix = createMatrixByTypeNum("3",2,2);
        System.out.println("기존 행렬 :");
        System.out.println(exMatrix.toString());
        System.out.println("덧셈 행렬 :");
        System.out.println(falseMatrix.toString());
        exMatrix.add(falseMatrix);
        System.out.println("기댓 값 : ");
        System.out.println("[[6, 6],\n" +
                " [6, 6]]");
        System.out.println("결과 값 : ");
        System.out.println(exMatrix.toString());
        System.out.println(exMatrix.toString().equals("[[6, 6],\n "+"[6, 6]]") ? "통과" : "실패");

        System.out.println();

        // 23. 행렬은 다른 행렬과 곱셈이 가능하다
        System.out.println("23. 행렬은 다른 행렬과 곱셈이 가능하다.");
        System.out.println("기존 행렬 :");
        System.out.println(exMatrix.toString());
        System.out.println("곱셈 행렬 :");
        System.out.println(falseMatrix.toString());
        exMatrix.multiply(falseMatrix);
        System.out.println("기댓 값 : ");
        System.out.println("[[36, 36],\n" +
                " [36, 36]]");
        System.out.println("결과 값 : ");
        System.out.println(exMatrix.toString());
        System.out.println(exMatrix.toString().equals("[[36, 36],\n "+"[36, 36]]") ? "통과" : "실패");
        System.out.println();

        // 24. 입력받은 두 스칼라의 덧셈이 가능하다
        System.out.println("24. 전달받은 두 스칼라의 덧셈이 가능하다. ");
        System.out.println("스칼라 1 : " + stringScalar.toString());
        System.out.println("스칼라 2 : " + testScalar.toString());
        Scalar resAddScalar = Tensors.addScalarByScalar(stringScalar, testScalar);
        System.out.println("기댓 값 : 5");
        System.out.println("결과 값 : " + resAddScalar.toString());
        System.out.println(resAddScalar.toString().equals("5") ? "통과" : "실패");
        System.out.println();

        // 25. 입력받은 두 스칼라의 곱셈이 가능하다.
        System.out.println("25. 전달받은 두 스칼라의 곱셈이 가능하다. ");
        System.out.println("스칼라 1 : " + stringScalar.toString());
        System.out.println("스칼라 2 : " + testScalar.toString());
        Scalar resMultiplyScalar = Tensors.multiplyScalarByScalar(stringScalar, testScalar);
        System.out.println("기댓 값 : 6 ");
        System.out.println("결과 값 : " + resMultiplyScalar.toString());
        System.out.println(resMultiplyScalar.toString().equals("6") ? "통과" : "실패");
        System.out.println();

        // 26. 입력받은 두 벡터의 덧셈이 가능하다.
        System.out.println("26. 전달받은 두 벡터의 덧셈이 가능하다.(길이가 같을 때)");
        System.out.println("벡터 1 : " + cloneVector.toString());
        System.out.println("벡터 2 : " + cloneVector.toString());
        System.out.println("기댓 값 : [6, 6, 6 ,6]");
        Vector resAddVector = Tensors.addVectorByVector(cloneVector, cloneVector);
        System.out.println("결과 값 : " + resAddVector.toString());
        System.out.println(resAddVector.toString().equals("[6, 6, 6, 6]") ? "통과" : "실패");
        System.out.println();

        // 27. 입력받은 스칼라와 벡터의 곱셈이 가능하다.
        System.out.println("27. 전달받은 스칼라와 벡터의 곱셈이 가능하다.(벡터의 모든 요소에 스칼라를 곱한다)");
        System.out.println("벡터 : " + stringVector.toString());
        System.out.println("스칼라 : " + stringScalar.toString());
        System.out.println("기댓 값 : [21, 3]");
        Vector resMultiplyVectorByScalar = Tensors.multiplyVectorByScalar(stringVector, stringScalar);
        System.out.println("결과 값 : " + resMultiplyVectorByScalar.toString());
        System.out.println(resMultiplyVectorByScalar.toString().equals("[21, 3]") ? "통과" : "실패");
        System.out.println();

        // 28. 입력받은 두 행렬의 덧셈이 가능하다.
        System.out.println("28. 전달받은 두 행렬의 덧셈이 가능하다.");
        Matrix test1Matrix = createMatrixByTypeNum("3",2, 2 );
        Matrix test2Matrix = createUnitMatrix(2);
        System.out.println("행렬 1 : \n" + test1Matrix.toString());
        System.out.println("행렬 2 : \n" + test2Matrix.toString());
        System.out.println("기댓 값 :\n[[4, 3],\n [3, 4]] ");
        Matrix resAddMatrix = Tensors.addMatrixByMatrix(test1Matrix, test2Matrix);
        System.out.println("결과 값 : ");
        System.out.println(resAddMatrix.toString());
        System.out.println(resAddMatrix.toString().equals("[[4, 3],\n "+"[3, 4]]") ? "통과" : "실패");
        System.out.println();

        // 29. 입력받은 두 행렬의 곱셈이 가능하다.
        System.out.println("29. 전달받은 두 행렬의 곱셈이 가능하다.");
        System.out.println("행렬 1 : \n" + test1Matrix.toString());
        System.out.println("행렬 2 : \n" + test2Matrix.toString());
        System.out.println("기댓 값 :\n[[3, 3],\n [3, 3]]");
        Matrix resMultiplyMatrix = Tensors.multiplyMatrixByMatrix(test1Matrix, test2Matrix);
        System.out.println("결과 값 : ");
        System.out.println(resMultiplyMatrix.toString());
        System.out.println(resMultiplyMatrix.toString().equals("[[3, 3],\n "+"[3, 3]]") ? "통과" : "실패");
        System.out.println();

        // 30. n-차원 벡터 객체는 자신으로부터 nx1 행렬을 생성하여 반환할 수 있다.
        System.out.println("30. n-차원 벡터 객체는 자신으로부터 nx1 행렬을 생성하여 반환할 수 있다.");
        System.out.println("반환할 벡터 : " + stringVector.toString());
        Matrix VectorToColumnMatrix = stringVector.toColumnMatrix();
        System.out.println("기댓 값 :\n[[7],\n [1]]");
        System.out.println("벡터를 nx1으로 변형한 행렬(결과 값) : ");
        System.out.println(VectorToColumnMatrix);
        System.out.println(VectorToColumnMatrix.toString().equals("[[7],\n "+"[1]]") ? "통과" : "실패");
        System.out.println();

        // 31. n-차원 벡터 객체는 자신으로부터 1xn 행렬을 생성하여 반환할 수 있다.
        System.out.println("31. n-차원 벡터 객체는 자신으로부터 1xn 행렬을 생성하여 반환할 수 있다.");
        System.out.println("반환할 벡터 : " + stringVector.toString());
        Matrix VectorToRowMatrix = stringVector.toRowMatrix();
        System.out.println("기댓 값 : [[7, 1]]");
        System.out.println("벡터를 nx1으로 변형한 행렬(결과 값) : " + VectorToRowMatrix);
        System.out.println(VectorToRowMatrix.toString().equals("[[7, 1]]") ? "통과" : "실패");
        System.out.println();

        Matrix tMatrix=createUnitMatrix(2);
        Matrix t2Matrix=createMatrixByTypeNum("2", 2, 2);
        Matrix t3Matrix=createUnitMatrix(3);

        // 32. 행렬은 다른 행렬과 가로로 합칠 수 있다.
        System.out.println("32. 행렬은 다른 행렬과 가로로 합쳐질 수 있다.");
        System.out.println("기존 행렬 : \n"+ tMatrix);
        System.out.println("추가할 행렬 : \n"+ t2Matrix);
        System.out.println("기댓 값 :\n[[1, 0, 2, 2],\n [0, 1, 2, 2]]");
        System.out.println("합쳐진 행렬(결과 값) : \n"+ tMatrix.widthPaste(t2Matrix));
        Matrix combined=tMatrix.widthPaste(t2Matrix);
        System.out.println(combined.toString().equals("[[1, 0, 2, 2],\n "+"[0, 1, 2, 2]]") ? "통과" : "실패");
        tMatrix=createUnitMatrix(2);
        System.out.println();

        System.out.println("32-1. 디폴트 static 메소드 호출");
        System.out.println("행렬 1 : \n"+ tMatrix);
        System.out.println("행렬 2 : \n"+ t2Matrix);
        System.out.println("기댓 값 :\n[[1, 0, 2, 2],\n [0, 1, 2, 2]]");
        Matrix widthMatrix = Tensors.combineToWidthMatrixByMatrix(tMatrix, t2Matrix);
        System.out.println("합쳐진 행렬(결과 값) : \n"+ widthMatrix);
        System.out.println(widthMatrix.toString().equals("[[1, 0, 2, 2],\n "+"[0, 1, 2, 2]]") ? "통과" : "실패");
        System.out.println();

        // 33. 행렬은 다른 행렬과 세로로 합칠 수 있다.
        System.out.println("33. 행렬은 다른 행렬과 세로로 합쳐질 수 있다.");
        System.out.println("기존 행렬 : \n"+ tMatrix);
        System.out.println("추가할 행렬 : \n"+ t2Matrix);
        System.out.println("기댓 값 :\n[[1, 0],\n [0, 1],\n [2, 2],\n [2, 2]]");
        System.out.println("합쳐진 행렬(결과 값) : \n" + tMatrix.heightPaste(t2Matrix));
        combined=tMatrix.heightPaste(t2Matrix);
        System.out.println(combined.toString().equals("[[1, 0],\n "+"[0, 1],\n "+"[2, 2],\n "+"[2, 2]]") ? "통과" : "실패");
        tMatrix=createUnitMatrix(2);
        System.out.println();

        System.out.println("33-1. 디폴트 static 메소드 호출");
        System.out.println("기존 행렬 : \n"+ tMatrix);
        System.out.println("추가할 행렬 : \n"+ t2Matrix);
        Matrix heightMatrix = Tensors.combineToHeightMatrixByMatrix(tMatrix, t2Matrix);
        System.out.println("기댓 값 : \n[[1, 0],\n [0, 1],\n [2, 2],\n [2, 2]]");
        System.out.println("합쳐진 행렬(결과 값) : \n" + heightMatrix);
        System.out.println(heightMatrix.toString().equals("[[1, 0],\n "+"[0, 1],\n "+"[2, 2],\n "+"[2, 2]]") ? "통과" : "실패");
        System.out.println();

        // 34. 행렬은 특정 행을 벡터 형태로 추출해 줄 수 있다.
        System.out.println("34. 행렬은 특정 행을 벡터 형태로 추출해 줄 수 있다.");
        System.out.println("기존 행렬 : \n"+ tMatrix);
        System.out.println("추출할 행 : 1");
        Vector rowV=tMatrix.rowVector(0);
        System.out.println("기댓 값 : [1, 0]");
        System.out.println("추출한 벡터(결과 값) : \n"+rowV);
        System.out.println(rowV.toString().equals("[1, 0]") ? "통과" : "실패");
        System.out.println();

        // 35. 행렬은 특정 열을 벡터 형태로 추출해 줄 수 있다.
        System.out.println("35. 행렬은 특정 열을 벡터 형태로 추출해 줄 수 있다");
        System.out.println("기존 행렬 : \n"+ tMatrix);
        System.out.println("추출할 열 : 1");
        Vector colV = tMatrix.colVector(1);
        System.out.println("기댓 값 : [0, 1]");
        System.out.println("추출한 벡터(결과 값) : \n"+ colV);
        System.out.println(colV.toString().equals("[0, 1]") ? "통과" : "실패");
        System.out.println();

        // 36. 행렬은 특정 범위의 부분 행렬을 추출해 줄 수 있다.
        System.out.println("36. 행렬은 시작 행과 끝 행 인덱스로 특정 범위의 부분 행렬을 추출해 줄 수 있다.");
        System.out.println("기존 행렬 : \n"+ t3Matrix);
        System.out.println("시작 행 인덱스 : 0 , 끝 행 인덱스 : 1");
        System.out.println("시작 열 인덱스 : 1 , 끝 열 인덱스 : 2");
        Matrix absMatrix=t3Matrix.getSubMatrix(0,1,1,2);
        System.out.println("기댓 값 : \n[[0, 0],\n [1,0]]");
        System.out.println("추출한 행렬(결과 값) : \n" + absMatrix);
        System.out.println(absMatrix.toString().equals("[[0,0],\n"+"[1, 0]]") ? "통과" : "실패");
        System.out.println();

        // 37. 행렬은 특정 범위의 부분 행렬을 추출해 줄 수 있다.
        System.out.println("37. 행렬은 지정 행 제외, 특정 범위의 부분 행렬을 추출해 줄 수 있다.");
        System.out.println("기존 행렬 : \n"+ t3Matrix);
        System.out.println("지정 행 : 0 , 지정 열 : 0");
        Matrix minorMatrix=t3Matrix.getMinor(0,0);
        System.out.println("기댓 값 : \n[[1, 0],\n [0, 1]]");
        System.out.println("추출한 행렬(결과 값) : \n"+ minorMatrix);
        System.out.println(minorMatrix.toString().equals("[[1,0],\n"+"[0, 1]]") ? "통과" : "실패");
        System.out.println();

        // 38. 행렬은 전치행렬을 새로 생성하여 반환할 수 있다.
        System.out.println("38. 행렬은 전치행렬을 구현해 줄 수 있다.");
        System.out.println("기존 행렬 : \n"+ equalMatrix);
        Matrix tpMatrix = equalMatrix.transpose();
        System.out.println("기댓 값 : \n[[1.2, 1.2],\n [3, 1.2]]");
        System.out.println("전치 행렬(결과 값) : \n"+ tpMatrix);
        System.out.println(tpMatrix.toString().equals("[[1.2, 1.2],\n"+"[3, 1.2]]") ? "통과" : "실패");
        System.out.println();

        // 39. 행렬은 대각 요소의 합을 구해줄 수 있다.
        System.out.println("39. 행렬은 대각 요소의 합을 구해줄 수 있다.");
        System.out.println("기존 행렬 : \n"+ t3Matrix);
        Scalar trace =t3Matrix.trace();
        System.out.println("기댓 값 : 3");
        System.out.println("대각 요소의 합(결과 값) : \n"+ trace);
        System.out.println(trace.toString().equals("3") ? "통과" : "실패");
        System.out.println();

        Scalar s0 = createScalarByString("0");
        Scalar s1 = createScalarByString("1");
        Scalar s2 = createScalarByString("2");
        Scalar s3 = createScalarByString("3");
        Scalar s4 = createScalarByString("4");
        Scalar s5 = createScalarByString("5");
        Matrix squareMatrix = createMatrixByArray(new Scalar[][]{{s1, s1}, {s0, s5}});
        Matrix nonSquareMatrix = createMatrixByTypeNum("2", 2, 3);
        Matrix lowerTriMatrix = createMatrixByArray(new Scalar[][]{{s3, s0, s0}, {s1, s5, s0}, {s5, s1, s3}});
        Matrix identityMatrix = createUnitMatrix(3);
        Matrix zeroMatrix = createMatrixByTypeNum("0", 3, 3);

        // 40. 정사각 행렬 판별
        System.out.println("40. 정사각 행렬 판별");
        System.out.println("  -> squareMatrix (2x2)는 정사각 행렬인가? " + squareMatrix.isSquare());
        System.out.println("  -> nonSquareMatrix (3x2)는 정사각 행렬인가? " + nonSquareMatrix.isSquare());
        System.out.println(squareMatrix.isSquare() && !nonSquareMatrix.isSquare() ? "통과" : "실패");
        System.out.println();

        // 41. 행렬은 자신이 상삼각행렬인지 여부를 판별할 수 있다.
        System.out.println("41. 상삼각 행렬 판별");
        System.out.println("  -> squareMatrix는 상삼각 행렬인가? " + squareMatrix.isUpperTriangular());
        System.out.println("  -> lowerTriMatrix는 상삼각 행렬인가? " + lowerTriMatrix.isUpperTriangular());
        System.out.println(squareMatrix.isUpperTriangular() && !lowerTriMatrix.isUpperTriangular() ? "통과" : "실패");
        System.out.println();

        // 42. 행렬은 자신이 하삼각행렬인지 여부를 판별할 수 있다.
        System.out.println("42. 하삼각 행렬 판별");
        System.out.println("  -> squareMatrix는 하삼각 행렬인가? " + squareMatrix.isLowerTriangular());
        System.out.println("  -> lowerTriMatrix는 하삼각 행렬인가? " + lowerTriMatrix.isLowerTriangular());
        System.out.println(lowerTriMatrix.isLowerTriangular() && !squareMatrix.isLowerTriangular() ? "통과" : "실패");
        System.out.println();

        // 43. 행렬은 자신이 단위행렬인지 여부를 판별할 수 있다.
        System.out.println("43. 단위 행렬 판별");
        System.out.println("  -> identityTestMatrix는 단위 행렬인가? " + identityMatrix.isIdentity());
        System.out.println("  -> squareMatrix는 단위 행렬인가? " + squareMatrix.isIdentity());
        System.out.println(identityMatrix.isIdentity() && !squareMatrix.isIdentity() ? "통과" : "실패");
        System.out.println();

        // 44. 행렬은 자신이 영행렬인지 여부를 판별할 수 있다.
        System.out.println("44. 영 행렬 판별");
        System.out.println("  -> zeroTestMatrix는 영 행렬인가? " + zeroMatrix.isZero());
        System.out.println("  -> identityTestMatrix는 영 행렬인가? " + identityMatrix.isZero());
        System.out.println(zeroMatrix.isZero() && !identityMatrix.isZero()  ? "통과" : "실패");
        System.out.println();

        // 45. 행렬은 특정 두 행의 위치를 맞교환할 수 있다.
        Matrix calmatrix = createMatrixByArray(new Scalar[][]{{s1, s2, s1}, {s2, s5, s2}, {s1, s2, s2}});
        System.out.println("45. 행 교환");
        Matrix aCalmatrix = calmatrix.clone();
        System.out.println("교환 전 (1행과 2행 교환): \n" + aCalmatrix);
        aCalmatrix.swapRows(0, 1);
        System.out.println("기댓 값 : \n[[2, 5, 2],\n [1, 2, 1],\n [1, 2, 2]");
        System.out.println("교환 후(결과 값): \n" + aCalmatrix);
        System.out.println(aCalmatrix.toString().equals("[[2, 5, 2],\n"+"[1, 2, 1],\n"+"[1, 2, 2]]") ? "통과" : "실패");
        System.out.println();

        // 46. 행렬은 특정 두 열의 위치를 맞교환할 수 있다.
        System.out.println("46. 열 교환");
        Matrix bCalmatrix = calmatrix.clone();
        System.out.println("교환 전 (2열과 3열 교환): \n" + bCalmatrix);
        bCalmatrix.swapColumns(1, 2);
        System.out.println("기댓 값 : \n[[1, 1, 2],\n [2, 2, 5],\n [1, 2, 2]]");
        System.out.println("교환 후 (결과 값) : \n" + bCalmatrix);
        System.out.println(bCalmatrix.toString().equals("[[1, 1, 2],\n"+"[2, 2, 5],\n"+"[1, 2, 2]]") ? "통과" : "실패");
        System.out.println();

        // 47. 행렬은 특정 행에 상수배를 할 수 있다.
        System.out.println("47. 특정 행에 스칼라 곱");
        Matrix cCalmatrix = calmatrix.clone();
        System.out.println("연산 전 (3행에 스칼라 \"" + s3 + "\" 곱): \n" + cCalmatrix);
        cCalmatrix.scaleRow(2, s3);
        System.out.println("기댓 값 : \n[[1, 2, 1],\n [2, 5, 2],\n [3, 6, 6]]");
        System.out.println("연산 후 (결과 값) : \n" + cCalmatrix);
        System.out.println(cCalmatrix.toString().equals("[[1, 2, 1],\n"+"[2, 5, 2],\n"+"[3, 6, 6]]") ? "통과" : "실패");
        System.out.println();

        // 48. 행렬은 특정 열에 상수배를 할 수 있다.
        System.out.println("48. 특정 열에 스칼라 곱");
        Matrix dCalmatrix = calmatrix.clone();
        System.out.println("연산 전 (1열에 스칼라 \"" + s2 + "\" 곱) : \n" + dCalmatrix);
        dCalmatrix.scaleColumn(0, s2);
        System.out.println("기댓 값 : \n[[2, 2, 1],\n [4, 5, 2],\n [2, 2, 2]]");
        System.out.println("연산 후 (결과 값) : \n" + dCalmatrix);
        System.out.println(dCalmatrix.toString().equals("[[2, 2, 1],\n"+"[4, 5, 2],\n"+"[2, 2, 2]]") ? "통과" : "실패");
        System.out.println();

        // 49. 행렬은 특정 행에 다른 행의 상수배를 더할 수 있다.
        System.out.println("49. 특정 행에 다른 행의 상수배를 더하기");
        Matrix eCalmatrix = calmatrix.clone();
        System.out.println("연산 전 (1행 += 3행 * \"" + s3 + "\") : \n" + eCalmatrix);
        eCalmatrix.addRowMultiple(0, 2, s3);
        System.out.println("기댓 값 : \n[[4, 8, 7],\n [2, 5, 2],\n [1, 2, 2]]");
        System.out.println("연산 후 (결과 값) : \n" + eCalmatrix);
        System.out.println(eCalmatrix.toString().equals("[[4, 8, 7],\n"+"[2, 5, 2],\n"+"[1, 2, 2]]") ? "통과" : "실패");
        System.out.println();

        // 50. 행렬은 특정 열에 다른 열의 상수배를 더할 수 있다.
        System.out.println("50. 특정 열에 다른 열의 상수배를 더하기");
        Matrix fCalmatrix = calmatrix.clone();
        System.out.println("연산 전 (1열 += 2열 * \"" + s2 + "\") : \n" + fCalmatrix);
        fCalmatrix.addColumnMultiple(0, 1, s2);
        System.out.println("기댓 값 : \n[[5, 12, 5],\n [2, 5, 2,],\n [1, 2, 2]]");
        System.out.println("연산 후 (결과 값) : \n" + fCalmatrix);
        System.out.println(fCalmatrix.toString().equals("[[5, 12, 5],\n"+"[2, 5, 2],\n"+"[1, 2, 2]]") ? "통과" : "실패");
        System.out.println();

        // 51. 행렬은 자신으로부터 RREF 행렬을 구해서 반환해 줄 수 있다.
        System.out.println("51. 행렬은 자신으로부터 RREF 행렬을 구해서 반환해 줄 수 있다");
        Matrix rrefMatrix = calmatrix.clone();
        System.out.println("연산 전 행렬: \n" + rrefMatrix);
        Matrix rref = rrefMatrix.getRREF();
        System.out.println("기댓 값 : \n[[1, 0, 0],\n [0, 1, 0],\n [0, 0, 1]]");
        System.out.println("연산 후 (결과 값) : \n" + rref);
        System.out.println(rref.toString().equals("[[1, 0, 0],\n"+"[0, 1, 0],\n"+"[0, 0, 1]]") ? "통과" : "실패");
        System.out.println();

        // 52. 행렬은 자신이 RREF 행렬인지 여부를 판별해 줄 수 있다
        System.out.println("52. 행렬은 자신이 RREF 행렬인지 여부를 판별해 줄 수 있다");
        System.out.println("유효한 행렬: \n" + rref);
        System.out.println("기댓 값 : true");
        System.out.println("판별 결과 : " + rref.isRREF());
        System.out.println("유효하지 않은 행렬: \n" + calmatrix);
        System.out.println("기댓 값 : false");
        System.out.println("판별 결과 : " + calmatrix.isRREF());
        System.out.println(rref.isRREF() && !calmatrix.isRREF() ? "통과" : "실패");
        System.out.println();

        // 53. 행렬은 자신의 행렬식을 구해줄 수 있다.
        System.out.println("53. 자신의 행렬식 구하기");
        System.out.println("입력 행렬: \n" + calmatrix);
        System.out.println("기댓 값 : 1");
        System.out.println("결과 값 : " + calmatrix.determinant());
        System.out.println(calmatrix.determinant().equals("1") ? "통과" : "실패");
        System.out.println();

        // 54. 행렬은 자신의 역행렬을 구해줄 수 있다.
        System.out.println("54. 자신의 역행렬 구하기");
        Matrix invMatrix = calmatrix.clone();
        System.out.println("입력 행렬: \n" + invMatrix);
        Matrix inverseMatrix = invMatrix.inverse();
        System.out.println("기댓 값 : \n[[6, -2, -1],\n [-2, 1, 0],\n [-1, 0, 1]]");
        System.out.println("연산 후 (결과 값) : \n" + inverseMatrix);
        System.out.println(inverseMatrix.toString().equals("[[6, -2, -1],\n"+"[-2, 1, 0],\n"+"[-1, 0, 1]]") ? "통과" : "실패");
        System.out.println();
    }
}
