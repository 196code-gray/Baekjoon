import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (num[j] > num[j+1]) {
                    int moment = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = moment;
                }
            }
        }
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }
}