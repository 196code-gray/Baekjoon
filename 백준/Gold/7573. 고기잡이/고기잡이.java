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

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            fish.add(new Pair(y,x));
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                catchFish(i,j);
            }
        }

        System.out.println(res);
    }
    static void catchFish(int fish1, int fish2){
        int y = fish.get(fish1).y;
        int x = fish.get(fish2).x;

        // 그물 범위 설정
        int v = 1;
        int h = (l - 2*v)/2;

        while(h>0){
            int cnt = 0;

            for(int i=0;i<M;i++){
                if(
                    // 두 물고기 중 한 물고기를 기준으로 그물 길이만큼의 x 길이 내에 물고기가 존재하는지 확인
                        x <= fish.get(i).x && fish.get(i).x <= x + h &&
                                // 두 물고기 중 한 물고기를 기준으로 그물 길이만큼의 y 길이 내에 물고기가 존재하는지 확인
                                y <= fish.get(i).y && fish.get(i).y <= y + v
                )
                    cnt++;
            }
            if(res < cnt) res = cnt;

            v++;
            h = (l - 2*v)/2;
        }
    }
}