import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {0,0,1,-1},dy={1,-1,0,0};
    static char[][] map;
    static Point start;
    static int w,h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        h = input[0];w=input[1];
        map = new char[h][w];

        LinkedList<Point> gList = new LinkedList<>();
        for(int i=0;i<h;i++){
            map[i] = br.readLine().toCharArray();

            for(int j=0;j<w;j++){
                if(map[i][j]=='S') start = new Point(j, i,0,0);
                else if(map[i][j]=='g') gList.add(new Point(j,i));
            }
        } 

        setNearby(gList);
        Point result = bfs(start);
        System.out.println(result.gCnt+" "+result.mCnt);
    }
    static void setNearby(LinkedList<Point> gList){

        for (Point point : gList) {
            for(int i=0;i<dx.length;i++){
                int nextX = point.x+dx[i];
                int nextY = point.y+dy[i];

                if(isRange(nextX,nextY) && map[nextY][nextX]=='.')
                    map[nextY][nextX]='m';
            }
        }
    }
    static Point bfs(Point start){
        Queue<Point> q = new PriorityQueue<>((o1, o2) ->
                o1.gCnt==o2.gCnt?o1.mCnt-o2.mCnt:o1.gCnt-o2.gCnt);
        boolean[][] visit = new boolean[h][w];

        q.add(start);
        visit[start.y][start.x]=true;
        while (!q.isEmpty()){

            Point cur = q.poll();

            if(map[cur.y][cur.x]=='F')
                return cur;

            for(int i=0;i<dx.length;i++){

                int nextX = cur.x+dx[i];
                int nextY = cur.y+dy[i];

                if(!isRange(nextX,nextY) || visit[nextY][nextX])
                    continue;

                switch (map[nextY][nextX]){
                    case 'g'->q.add(new Point(nextX, nextY, cur.gCnt + 1, cur.mCnt));
                    case 'm'->q.add(new Point(nextX, nextY, cur.gCnt, cur.mCnt + 1));
                    default -> q.add(new Point(nextX, nextY, cur.gCnt, cur.mCnt));
                }
                visit[nextY][nextX]=true;
            }
        }
        return null;
    }
    static boolean isRange(int x,int y){
        return x>=0&&y>=0&&y<h&&x<w;
    }
    static class Point{
        int x, y;
        int gCnt,mCnt;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Point(int x, int y, int gCnt, int mCnt) {
            this.x = x;
            this.y = y;
            this.gCnt = gCnt;
            this.mCnt = mCnt;
        }
    }
}