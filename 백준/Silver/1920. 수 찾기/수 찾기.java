import java.util.Scanner;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i< n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            boolean find = false;
            int target = sc.nextInt();
            int s = 0;
            int e = arr.length -1;
            while (s <= e) {
                int midi = (s + e) / 2;
                int midv = arr[midi];
                if (midv > target) {
                    e = midi - 1;
                } else if (midv < target) {
                    s = midi + 1;
                } else {
                     find = true;
                    break;
                }
            }
            if ( find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}