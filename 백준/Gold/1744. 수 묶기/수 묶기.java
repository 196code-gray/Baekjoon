import java.util.*;

    public class Main {
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minus = new PriorityQueue<>();
            int one = 0;
            int zero = 0;

            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                if (a > 1) {
                    plus.add(a);
                } else if (a < 0) {
                    minus.add(a);
                } else if (a == 1) {
                    one++;
                } else zero++;
            }
            int result = 0;

            while (plus.size() > 1) {
                int num = plus.remove();
                int num2 = plus.remove();
                result += num * num2;
            }
            if (!plus.isEmpty()) {
                result += plus.remove();
            }
            while (minus.size() > 1) {
                int num = minus.remove();
                int num2 = minus.remove();
                result += num * num2;
            }
            if (!minus.isEmpty()) {
                if (zero > 0) {
                    result += minus.remove() * 0;
                } else {
                    result += minus.remove();
                }
            }
            result += one;

            System.out.println(result);
        }
    }