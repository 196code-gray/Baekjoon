import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 치킨의 갯수
        int L = Integer.parseInt(st.nextToken()); // 지레의 길이
        st = new StringTokenizer(br.readLine());
        double[] x = new double[N]; // 치킨의 위치 배열
        for (int i = 0; i < N; i++){
            x[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        double[] w = new double[N]; // 치킨의 무게 배열
        for (int i = 0; i < N; i++){
            w[i] = Integer.parseInt(st.nextToken());
        }
        double ans = 0; // 정답
        for (int i = 0; i < w.length; i++){
            ans += w[i] * x[i]; // 치킨의 위치 * 치킨의 무게
        }
        double div = 0; // 나누는 값
        for (int i = 0; i < w.length; i++){
            div += w[i]; // 치킨의 무게
        }
        ans = ans / div; //나누는 값을 나눠줌
        System.out.println(ans); // 정답 출력
    }
}