import java.util.*;

    public class Main {
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] s, int[] e) {
                    if (s[1] == e[1]) {
                        return s[0] - e[0];
                    } else return s[1] - e[1];
                }
            });
            int count = 0;
            int end = -1;
            for (int i = 0; i < n; i++) {
                if (arr[i][0] >= end) {
                    end = arr[i][1];
                    count++;
                }
            }
            System.out.println(count);
        }
    }