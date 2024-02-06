import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] score = new int[11];
        for (int i = 1; i <= 10; i++){
            score[i] = score[i -1] + Integer.parseInt(br.readLine());
            if (score[i] >= 100){
                int a = score[i] - 100;
                int b = 100 - score[i -1];
                if (a <= b) {
                    System.out.println(score[i]);
                    return;
                }
                else {
                    System.out.println(score[i -1]);
                    return;
                }
            }
        }
        System.out.println(score[10]);
    }
}