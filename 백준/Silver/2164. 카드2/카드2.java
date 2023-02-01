import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // 카드 수량 받아옴
        int card = s.nextInt();
        //큐 생성
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= card; i++) {
            queue.add(i);
        }
        // 카드 하나 버리고 다음 카드 맨 뒤로 넘기기
        // 카드 번호가 나와야 함.

        while (queue.size() != 1) {
            queue.poll();
            queue.offer(queue.poll());
        }
        System.out.println(queue.peek());
    }
}