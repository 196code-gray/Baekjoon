    import java.io.*;
    import java.util.*;

    public class Main {
        static int[] tree = new int[10001];
        public static void main(String args[]) throws IOException {
            Scanner br = new Scanner(System.in);
            int index = 0;
            while(br.hasNext()) {
                tree[index] = br.nextInt();
                index++;
            }
            postOrder(0, index -1);
        }

        private static void postOrder(int start, int end) {
            if (start > end) return;

            int m = start + 1;
            while(tree[start] > tree[m] && m <= end) m++;

            postOrder(start + 1, m -1);
            postOrder(m, end);
            System.out.println(tree[start]);
        }
    }
