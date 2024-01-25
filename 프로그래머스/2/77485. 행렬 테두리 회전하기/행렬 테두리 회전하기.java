import java.util.*;
class Solution {
    static int[][] num;
    static int min = 1;
    public int[] solution(int rows, int columns, int[][] queries) {
        num = new int[rows + 1][columns + 1];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                num[i][j] = ((i) * columns + j+1);
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++){
            int x1 = queries[i][0]- 1;
            int y1 = queries[i][1]- 1;
            int x2 = queries[i][2]- 1;
            int y2 = queries[i][3]- 1;

            ans[i] = turnArr(x1, y1, x2, y2);
        }

        return ans;
    }
    static int turnArr(int x1, int y1, int x2, int y2){
        int last = num[x1][y1]; min = last;

        for (int i = x1; i < x2; i++){
            num[i][y1] = num[i + 1][y1];
            if (min > num[i][y1]) min = num[i][y1];
        }
        for (int i = y1; i < y2; i++){
            num[x2][i] = num[x2][i + 1];
            if (min > num[x2][i]) min = num[x2][i];
        }
        for (int i = x2; i > x1; i--){
            num[i][y2] = num[i -1][y2];
            if (min > num[i][y2]) min = num[i][y2];
        }
        for (int i = y2; i > y1 +1; i--){
            num[x1][i] = num[x1][i -1];
            if (min > num[x1][i]) min = num[x1][i];
        }
        num[x1][y1 + 1] = last;
        return min;
    }
}