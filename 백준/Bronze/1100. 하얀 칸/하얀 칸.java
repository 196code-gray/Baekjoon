import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] board = new String[8][8];
        for (int i = 0; i < 8; i++){
            board[i] = br.readLine().split("");
        }
        int count = 0;
        for (int i = 0;i < 8; i++){
            int j;
            if (i % 2 == 0) j = 0;
            else j = 1;
            for (; j < 8; j+= 2){
                if (board[i][j].equals("F")) count++;
            }
        }
        System.out.println(count);
    }
}