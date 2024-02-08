import java.util.*;

class Solution {
    static int n;
    static int[][][] visited;
    static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int solution(int[][] board) {
        n = board.length;
        visited = new int[n][n][4]; // 같은 곳을 여러번 들릴 수 있기 때문에 현재 크기만큼 3차원 배열로 잡고, 행은 실제 행, 열은 방향(4가지)
        return bfs(board);
    }

    static int bfs(int[][] board) {
        Queue<Node> q = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        q.offer(new Node(0, 0, -1, 0)); // 시작 0,0, 방향 미정, 비용 0
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.x == n - 1 && now.y == n - 1) {    // 도착지점에 도착
                min = Math.min(min, now.pay);
                //continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = direction[i][0] + now.x;
                int ny = direction[i][1] + now.y;
            

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1) continue;

                int money = now.pay;
                if (now.dir == -1 || now.dir == i) {    // 현재 처음 들리는 경우이거나 같은 방향이라면 100원 추가
                    money += 100;
                } else money += 600;
                

                if (visited[nx][ny][i] == 0 || board[nx][ny] >= money) {   // 한번도 들리지 않았거나 현재 저장된 값보다 작을 경우
                    q.offer(new Node(nx, ny, i, money));
                    visited[nx][ny][i] = 1;
                    board[nx][ny] = money;
                    
                }
            }
        }
        return min;
    }

    static public class Node {
        int x, y, dir, pay;

        public Node(int x, int y, int dir, int pay) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.pay = pay;
        }
    }
}