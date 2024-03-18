import java.io.*;
import java.util.*;

public class Main {
    static int[] moveRow = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] moveCol = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int n, m, k;
    static int[][] origin;			// 겨울마다 추가될 양분
    static int[][] land;			// 현 양분
    static ArrayList<Tree> trees = new ArrayList<>();		// 나무 리스트
    static Deque<Integer> dead = new LinkedList<>();	// 죽은 나무
    public static void main(String[] args) throws IOException {
        // 입력정보 받고 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); k =Integer.parseInt(st.nextToken());
        origin = new int[n][n];
        land = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(land[i], 5); // 처음 양분 5로 시작
            for (int j = 0; j < n;j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) -1;
            int y = Integer.parseInt(st.nextToken()) -1;
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x,y, age));
        }

        // 처음에 주어진 나무들을 어린나이 순으로 정렬
        Collections.sort(trees, (t1, t2) -> t1.age - t2.age);

        while (k --> 0) {
            spring();
            summer();
            fall();
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    land[i][j] += origin[i][j];
                }
            }
        }
        System.out.println(trees.size());
    }
    /*
    제일 어린 나무부터 자신의 나이만큼 양분++ & 나이 +1
    양분 부족 나무 죽음
     */
    public static void spring() {
        for (int i = 0; i < trees.size(); i++) {
            Tree tree = trees.get(i);
            if (land[tree.row][tree.col] < tree.age) {
                dead.add(i);
                continue;
            }
            land[tree.row][tree.col] -= tree.age;
            tree.age++;
        }
    }
    /*
    땅 양분 += 봄에 죽은 나무 나이 / 2
     */
    public static void summer() {
        while (!dead.isEmpty()) {
            int deadTreeIndex = dead.pollLast();
            Tree deadTree = trees.get(deadTreeIndex);
            int food = deadTree.age / 2;
            land[deadTree.row][deadTree.col] += food;
            deadTree.dead = true;
        }
    }
    /*
    나이가 5의 배수인 나무 8방향 나이 1 나무 생성
     */
    public static void fall() {
        ArrayList<Tree> newTrees = new ArrayList<>();
        
        for (int p = 0; p < trees.size(); p++) {
            Tree tree = trees.get(p);
            
            if (tree.dead) continue;
            
            if (tree.age % 5 == 0) {  // 살아있는 나무의 나이가 5의 배수
                for (int i = 0; i < 8; i++) {
                    int nr = tree.row + moveRow[i];
                    int nc = tree.col + moveCol[i];
                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                    newTrees.add(new Tree(nr, nc, 1));
                }
            }
        }
        // 새로 생성된 나무들이 저장된 리스트에 기존의 살아있는 나무들 추가
        for (Tree tree : trees) {
            if (!tree.dead) newTrees.add(tree);
        }
        trees = newTrees;  // 기존 나무 추가
    }
    static class Tree {
        int row, col, age;
        boolean dead;

        public Tree(int row, int col, int age) {
            this.row = row;
            this.col = col;
            this.age = age;
        }
    }
}