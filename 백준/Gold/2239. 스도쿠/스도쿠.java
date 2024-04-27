import java.io.*;
import java.util.*;

public class Main {
    static int[][] sudoku;
    static boolean[][] row, clo, square; // 행, 열, 사각형
    public static void main(String[] args) throws Exception {
        sudoku = new int[9][9]; row = new boolean[9][9];
        clo = new boolean[9][9]; square = new boolean[9][9];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++){
            String[] s = br.readLine().split("");
            for (int j = 0; j < 9; j++){
                sudoku[i][j] = s[j].charAt(0) - '0';
                if (sudoku[i][j] != 0){ // 미리 숫자가 있는 경우
                    row[i][sudoku[i][j] -1] = true;
                    clo[j][sudoku[i][j] -1] = true;
                    square[(i/3) * 3 + (j /3)][sudoku[i][j] -1] = true;
                }
            }
        }
        DFS(0);
    }
    static void DFS(int depth){
        if (depth == 81){ // 모든 수를 다 채웠을 경우
            for (int i = 0; i < 9;i++){
                for (int j= 0; j < 9;j++){
                    System.out.print(sudoku[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        int x = depth / 9;
        int y = depth % 9;

        if (sudoku[x][y] == 0){
            for (int i = 0; i < 9; i++){
                if (row[x][i] || clo[y][i] || square[(x / 3) * 3 + (y/3)][i]) continue;
                row[x][i]= true;
                clo[y][i] = true;
                square[(x / 3) * 3 + (y / 3)][i] = true;
                sudoku[x][y] = i + 1;
                DFS(depth+1);
                row[x][i] = false;
                clo[y][i] = false;
                square[(x/3)*3 + (y /3)][i] = false;
                sudoku[x][y] = 0;
            }
        } else DFS(depth + 1);
    }
}