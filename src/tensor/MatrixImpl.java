package tensor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MatrixImpl implements Matrix {
    private int rows;
    private int cols;
    private List<BigDecimal> matrixList = new ArrayList<>();      //행렬 자료구조 => ArrayList



    // 06. 지정된 하나의 값을 모든 요소의 값으로 하는 m x n 행렬 생성
    MatrixImpl(BigDecimal typeNum, int m, int n) {
        this.rows = m;
        this.cols = n;
        for  (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixList.add(typeNum);
            }
        }
    }

    // 07. i 이상 j 미만의 무작위 값을 요소로 하는 m x n 행렬 생성
    MatrixImpl(int i,int j,int m, int n) {
        this.rows = m;
        this.cols = n;
        for (int rowsLimit = 0; rowsLimit < rows; rowsLimit++) {
            for (int colsLimit = 0; colsLimit < cols; colsLimit++) {
                ScalarImpl tempt = new ScalarImpl(i,j);
                matrixList.add(tempt.getScalar());
            }
        }
    }

    // 08. csv파일로부터 m x n 행렬 생성
    MatrixImpl(String csvData) {
        String[] rowStrings = csvData.strip().split("\\n");

        this.rows = rowStrings.length;
        this.cols = rowStrings[0].split(",").length;

        for (String row : rowStrings) {
            System.out.println(row);
            String[] colString = row.strip().split(",");
            for (String numStr : colString) {
                System.out.println(numStr.strip());
                BigDecimal csvNum = BigDecimal.valueOf(Double.parseDouble(numStr.strip()));
                System.out.println(csvNum);
                matrixList.add(csvNum);
            }
            System.out.println("매트릭스 체크" + matrixList);
        }
    }

    // 09. 2차원 배열로부터 m x n 행렬 생성
    MatrixImpl(int[][] typeArr){
        this.rows = typeArr.length;
        this.cols = typeArr[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrixList.add(BigDecimal.valueOf(typeArr[row][col]));
            }
        }
    }

    // 10. 단위 행렬 생성
    MatrixImpl(int n){
        this.rows = n;
        this.cols = n;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == col) {
                    matrixList.add(BigDecimal.valueOf(1));
                }
                else {
                    matrixList.add(BigDecimal.valueOf(0));
                }
            }
        }
    }

    //출력용 메서드
    public void printMatrixList() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int index = row * cols + col;
                System.out.print(matrixList.get(index) + "  ");
            }
            System.out.println();
        }
    }
}