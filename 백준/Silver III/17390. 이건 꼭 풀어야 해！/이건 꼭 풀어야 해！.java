import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	
    	//수열 A의 길이 N, 질문 개수 Q 입력
    	st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int Q = Integer.parseInt(st.nextToken());
    	
    	//수열A를 의미하는 배열 선언 및 값 입력 
    	int[] A = new int[N+1];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=1 ; i<=N ; i++) {
    		A[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	//배열 비내림차순(오름차순) 정렬
    	Arrays.sort(A);
    	
    	//0번 인덱스부터 순서대로 해당인덱스까지의 누적합을 저장할 배열 선언
    	int[] dp = new int[N+1];
    	
    	//누적합 저장(0번 인덱스는 항상 0이다)
    	int sum = 0;
    	for(int i=1 ; i<=N ; i++) {
    		sum += A[i];
    		
    		dp[i] = sum;
    	}
    	
    	//테스트케이스 개수만큼 진행
    	while(Q-->0) {
    		//구간 시작, 끝 부분 입력
    		st = new StringTokenizer(br.readLine());
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		
    		//구간합 = (끝부분까지의 누적합) - (시작부분-1) 
    		
    		//결과 저장
    		sb.append(dp[end] - dp[start-1]).append("\n");
    	}
    	
    	//결과 출력
    	System.out.print(sb.toString());
    }
}	
