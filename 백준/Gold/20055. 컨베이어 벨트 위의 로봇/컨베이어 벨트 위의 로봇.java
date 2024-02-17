import java.util.*;
import java.io.*;

public class Main {
    static int[][] belt;
    static boolean[] robot;
    static int n, k, step, zero;    // 단계, 내구도 0 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        belt = new int[2][n + 1];
        robot = new boolean[n + 1]; // 로봇이 현재 있는가?
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<= n; i++) belt[0][i] = Integer.parseInt(st.nextToken());
        for (int i = n; i > 0; i--) belt[1][i] = Integer.parseInt(st.nextToken());

        move();
        System.out.println(step);
    }
    static void move(){
        while (zero < k){
            zero=0;
            step++;
            round();
            for (int i = n -1; i > 0; i--){
                if (robot[i]){ // 현재 로봇이 있다면
                    // 다음 위치에 로봇이 없고 내구도가 0이 아니면서 다음위치가 내리는 위치가 아닐 경우
                    if(!robot[i + 1] && belt[0][i + 1] > 0 && i + 1 != n){
                        robot[i] = false;
                        belt[0][i + 1]--; robot[i + 1] = true;
                    }
                    else if (i + 1 == n && belt[0][n] > 0){    // 다음 위치가 내리는 위치면서 내구도가 0이 아닐 경우
                        robot[i] = false;
                        belt[0][n]--;
                    }
                }
            }
            if (belt[0][1] > 0){   // 현재 로봇을 올릴 수 잇는 경우
                belt[0][1]--;
                robot[1] = true;
            }
            for (int i = 1; i <= n; i++){
                if(belt[0][i]==0)zero++;
                if(belt[1][i]==0)zero++;
            }
        }
    }
    static void round(){
        int num= belt[0][n];
        if (robot[n]) robot[n] = false; // 마지막 위치에 로봇이 있을 경우 로봇 내림

        for (int i = n; i > 0; i--){
            if (robot[i]) {
                if (i + 1 == n) robot[i] = false;
                else {
                    robot[i + 1] = true;
                    robot[i] = false;
                }
            }
            if (i == 1) belt[0][1] = belt[1][1];
            else belt[0][i] = belt[0][i -1];
        }
        for (int i = 1; i <= n; i++){
            if (i == n) belt[1][i] = num;
            else belt[1][i] = belt[1][i + 1];
        }
    }
}