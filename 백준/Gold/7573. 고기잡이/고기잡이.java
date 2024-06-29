import java.util.*;
import java.io.*;

public class Main{
    static int N,l,M;
    static int res = 0;
    static ArrayList<Pair> fish = new ArrayList<>();

    static class Pair{
        int y, x;

        Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1,1 부터 시작
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            fish.add(new Pair(y,x));
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                // 물고기 중에 2개를 고름
                catchFish(i,j);
            }
        }

        System.out.println(res);
    }
    static void catchFish(int fish1, int fish2){
        // x,y값을 비교할 물고기 좌표 설정
        int y = fish.get(fish1).y;
        int x = fish.get(fish2).x;

        // 그물 범위 설정
        int v = 1;
        int h = (l - 2*v)/2;

        while(h>0){
            // 잡을 수 있는 물고기 수
            int cnt = 0;

            for(int i=0;i<M;i++){
                if(
                    // 두 물고기 중 한 물고기를 기준으로 그물 길이만큼의 x 길이 내에 물고기가 존재하는지 확인
                        x <= fish.get(i).x &&
                                fish.get(i).x <= x + h &&
                                // 두 물고기 중 한 물고기를 기준으로 그물 길이만큼의 y 길이 내에 물고기가 존재하는지 확인
                                y <= fish.get(i).y &&
                                fish.get(i).y <= y + v
                )
                    cnt++;
            }

            // 현재 물고기 수와 답과의 최대값 구하기
            if(res < cnt) res = cnt;

            // 다른 사이즈의 그물로 변환
            v++;
            h = (l - 2*v)/2;
        }
    }
}