import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextInt();
        long[] arr = new long[10000001];

        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 2; i < Math.sqrt(arr.length); i++) {
            if (arr[i] == 0) continue;
            for (int j = i + i; j < arr.length; j = j + i) {
                arr[j] = 0;
            }
        }
        int i = (int) n;
        while (true) {
            if (arr[i] != 0) {
                long num = arr[i];
                if(is팰린드롬(num)) {
                    System.out.println(num);
                    break;
                }
            }
            i++;
        }
    }
    public static boolean is팰린드롬 (long arr) {
        char temp[] = String.valueOf(arr).toCharArray();
        int s = 0;
        int e = temp.length -1;
        while (s < e) {
            if (temp[s] != temp[e]) {
                return false;
            }
            s++; e--;
        }
        return true;
    }
}