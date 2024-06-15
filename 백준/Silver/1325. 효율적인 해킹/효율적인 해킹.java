import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 완탐으로 풀면 시간초과난다.
 * 시간복잡도를 우선 계산하고 완탐으로 할건지, dfs, bfs로 할건지 선택하자.
 * 인접배열 형식으로 그래프를 표현하니 시간이 더 빠르다.
 * @author quadcore
 *
 */
public class Main{
	public static int n,m;
	public static boolean[][] map, visit;
	public static int output = 0;
	public static int max = 0;
	public static ArrayList<Integer> hap;
	public static boolean[] visited;
	public static void main(String[] args) throws Exception, IOException {
		//입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visit = new boolean[n][n];
		visited = new boolean[n];
		map = new boolean [n][n];
		hap = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			map[y][x] = true;
		}
		
		for (int i = 0; i < n; i++) {
			dfs(i);
			//여기서 모아야
			hap.add(output);
			if (max < output) {
				max = output;
			}
			output = 0;
			visit[i] = visited;
			visited = new boolean[n];
		}
//		System.out.println(hap);
		int sibal = hap.size();
		for (int i = 0; i < sibal; i++) {
			if (hap.get(i) == max) {
				System.out.print(i+1+" ");
			}
		}
	}
	
	public static void dfs(int x) {
		//방문했다는 표시 해주고.
		visited[x] = true;
		//가로로 보면서 해킹할 수 있는 컴퓨터를 보자.
		for (int i = 0; i < map.length; i++) {
			if (map[x][i] == false) continue;
			if (visited[i] == true) continue;
			if (hap.size() > i) {
				int tmp = 0;
				for (int j = 0; j < visit.length; j++) {
					if (visit[i][j] == true && visited[j] == false) {
						tmp = tmp + 1;
						visited[j] = true;
					}
				}
				output = output + tmp;
			} else {
				output = output + 1;
				dfs(i);
			}
		}
	}
}

