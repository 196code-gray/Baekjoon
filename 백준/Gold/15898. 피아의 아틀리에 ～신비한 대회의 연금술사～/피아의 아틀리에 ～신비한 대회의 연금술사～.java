import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
	public static int N, M, K = 0;
	public static int[][] gama;
	public static int[][] gamaColor;
	public static int[][][][] map;
	public static int[][][][] mapColor;
	public static boolean[] visited;
	public static int answer = 0;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	
    	map = new int[10][4][4][4];
    	mapColor = new int[10][4][4][4];
    	visited = new boolean[10];
    	for(int t=0;t<N;t++) {
    		int[][] storeMap = new int[4][4];
    		for(int i=0;i<4;i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j=0;j<4;j++) {
    				storeMap[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		map[t][0] = storeMap;
    		for(int rotate = 1; rotate<4; rotate++) {
				map[t][rotate] = rotate(map[t][rotate-1]);
    		}
    		
    		storeMap = new int[4][4];
    		for(int i=0;i<4;i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j=0;j<4;j++) {
    				storeMap[i][j] = st.nextToken().charAt(0) - 'A';
    			}
    		}
    		
    		mapColor[t][0] = storeMap;
    		for(int rotate = 1; rotate<4; rotate++) {
				mapColor[t][rotate] = rotate(mapColor[t][rotate-1]);
    		}
    		
    	}
    	
    	gama = new int[5][5];
    	gamaColor = new int[5][5];
    	simulate(0);
    	System.out.println(answer);
    }
    
    public static void simulate(int level) {
    	if(level == 3) {
    		answer = Math.max(answer, calculateScore());
    		return ;
    	}
    	
    	for(int i=0;i<N;i++) {
    		if(visited[i] == false) {
    			visited[i] = true;
    			
    			int[][] storeGama = new int[5][5];
    			int[][] storeGamaColor = new int[5][5];
    			for(int r=0;r<5;r++) {
    				for(int c=0;c<5;c++) {
    					storeGama[r][c] = gama[r][c];
    					storeGamaColor[r][c] = gamaColor[r][c];
    				}
    			}
    			
    			for(int r=0;r<2;r++) {
    				for(int c=0;c<2;c++) {
    					for(int rotate=0;rotate<4;rotate++) {
    						
    						coloring(i, r, c, rotate);
    						
    						simulate(level + 1);
    						
    						for(int k=0;k<5;k++) {
    		    				for(int h=0;h<5;h++) {
    		    					gama[k][h] = storeGama[k][h]; 
	    							gamaColor[k][h] = storeGamaColor[k][h];
    		    				}
    		    			}
    					}
    					
    				}
    			}
    			
    			visited[i] = false;
    		}
    	}
    	
    	
    }
    
//    R, B, G, Y, W는 재료의 순서에 따라서 값은 같아질 수 있지만, 색깔이 마지막에 저장되므로 순서가 중요하다.
    public static int calculateScore() {
    	int score = 0;
    	int R=0;
    	int B=0;
    	int G=0;
    	int Y=0;
    	for(int i=0;i<5;i++) {
    		for(int j=0;j<5;j++) {
    			int color = gamaColor[i][j];
    			int sum = gama[i][j];
    			if(color == 'R' - 'A') {
    				R += sum;
    			}else if(color == 'B' - 'A') {
    				B += sum;
    			}else if(color == 'G' - 'A') {
    				G += sum;
    			}else if(color == 'Y' - 'A') {
    				Y += sum;
    			}else if(color == 'W' - 'A') { //아무것도 더하지 않습니다.
    				
    			}
    		}
    	}
    	return R*7 + B*5 + G*3 + Y*2;
    }
    
    public static void coloring(int kindIndex, int startRow, int startCol, int rotateIndex) {
    	
		for(int k=0;k<4;k++) {
			for(int h=0;h<4;h++) {
				gama[startRow + k][startCol + h] += map[kindIndex][rotateIndex][k][h];
				
				if(gama[startRow + k][startCol + h] < 0) {
					gama[startRow + k][startCol + h] = 0;
				} else if(gama[startRow + k][startCol + h] > 9) {
					gama[startRow + k][startCol + h] = 9;
				}
				
				if(mapColor[kindIndex][rotateIndex][k][h] != 'W' - 'A') {
					gamaColor[startRow + k][startCol + h] = mapColor[kindIndex][rotateIndex][k][h];
				}
			}
		}
		
    }
    
    public static int[][] rotate(int[][] map) {
    	int[][] newMap = new int[4][4];
    	
    	for(int i=0;i<4;i++) {
    		for(int j=0;j<4;j++) {
    			newMap[j][3-i] = map[i][j];
    		}
    	}
    	return newMap;
    }
}