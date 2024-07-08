import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class DescendOrder implements Comparator<Long>{
		@Override
		public int compare(Long o1, Long o2) {
			if(o1<o2) return 1;
			else if(o1>o2) return -1;
			return 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()); //상품 수
		int m=Integer.parseInt(st.nextToken()); //고객 수
		//상품의 만족도가 높은 순 poll 되는 pq
		PriorityQueue<Long> productsPq = new PriorityQueue<>(new DescendOrder());
		//고객 지불 비용이 낮을 수록 poll 되는 pq
		PriorityQueue<Long> clientsPq = new PriorityQueue<>();
		//상품 만족도 입력
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			productsPq.add(Long.parseLong(st.nextToken()));
		}
		//고객 지불 비용 입력
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			clientsPq.add(Long.parseLong(st.nextToken()));
		}
		
		long answer = 0;
		//두 pq중 하나라도 빌때 까지 반복
		while(!clientsPq.isEmpty()&&!productsPq.isEmpty()) {
			long product = productsPq.poll();
			long client = clientsPq.poll();
			//상품 만족도가 고객 지불 비용 보다 못하면 stop
			//(다음 상품 만족도는 더 낮아지고, 다음 고객 비용은 높아짐)
			if(product<client) {
				break;
			}
            //만족도의 합
			answer+=(product-client);
		}
		//출력
		System.out.println(answer);
		
		br.close();
	}
}