import java.util.*;
// Greedy = 최대한 이득을 볼 수 있는 방법을 생각.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 정수 K 입력
        int K = scanner.nextInt();
        // K에 따른 스택 생성
        Stack<Integer> stack = new Stack<>();
        // 입력 받기
        for (int i = 0; i < K; i++) {
            int num = scanner.nextInt();
            if (num == 0 && stack.size() != 0) {
                stack.pop();
            }
            else stack.push(num);
        }
        int result = 0;
        int len = stack.size();
        if (stack.size() == 0) System.out.println(0);

        else {
            for (int i = 0; i < len; i++) {
                result += stack.peek();
                stack.pop();
            }
            System.out.println(result);
        }
    }
}