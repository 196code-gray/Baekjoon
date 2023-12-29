import java.io.*;
import java.util.*;

public class Main {
    static int[] arr1, arr2, result;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String e = br.readLine();
        int a1 = 1, a2 = 0, ans = 0;

        arr1 = new int[n];
        arr2  = new int[n];
        result = new int[n];
        for (int i = 0; i < n; i++){
            arr1[i] = s.charAt(i) - '0';
            arr2[i] = s.charAt(i) - '0';
            result[i] = e.charAt(i) - '0';
        }
        arr1[0] = (arr1[0] == 1) ? 0 : 1;
        arr1[1] = (arr1[1] == 1) ? 0 : 1;

        for (int i = 1; i < n; i++){
            if (result[i -1] != arr1[i -1]) {
                arr1[i] = (arr1[i] == 1) ? 0 : 1;
                arr1[i -1] = (arr1[i -1] == 1) ? 0 : 1;
                a1++;
                if (i != n -1) arr1[i + 1] = (arr1[i + 1] == 1) ? 0 : 1;
            }
            if (result[i -1] != arr2[i -1]){
                arr2[i] = (arr2[i] == 1) ? 0 : 1;
                arr2[i -1] = (arr2[i -1] == 1) ? 0 : 1;
                a2++;
                if (i != n -1) arr2[i + 1] = (arr2[i + 1] == 1) ? 0 : 1;
            }
        }
        if (arr1[n -1] != result[n -1]) a1 = Integer.MAX_VALUE;
        if (arr2[n -1] != result[n -1]) a2 = Integer.MAX_VALUE;

        System.out.println((a1 == Integer.MAX_VALUE && a2 == Integer.MAX_VALUE) ? -1 : Math.min(a1, a2));
    }
}