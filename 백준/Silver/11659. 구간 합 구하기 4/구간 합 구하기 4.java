import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // int 수의 길이 변수 선언과 동시에 입력 받기
        int length = Integer.parseInt(st.nextToken());
        // int 합의 횟수 변수 선언과 동시에 입력 받기
        int sNum = Integer.parseInt(st.nextToken());
        // int[] arr 1차원 배열 선언
        long[] arr = new long[length + 1];
        st = new StringTokenizer(br.readLine());
        // for (수의 변수만큼 반복 ) {
        for (int i = 1; i <= length; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = arr[i-1] + a;
        }
        // 합 배열 생성 s[i] = s[i-1] + a[i]
        // }
        for (int a = 0; a < sNum; a++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(arr[j] - arr[i-1]);
        }
    }
}