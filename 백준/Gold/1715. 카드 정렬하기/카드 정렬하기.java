import java.util.*;

    public class Main {
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            PriorityQueue<Integer> q = new PriorityQueue<>();
            
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                q.add(a);
            }
            int count = 0;
            
            while (q.size() != 1) {
                int a = q.remove();
                int b = q.remove();
                count += a + b;
                q.add(a + b);
            }
            System.out.println(count);
        }
    }