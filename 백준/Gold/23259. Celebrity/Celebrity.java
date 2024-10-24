import java.util.*;

public class Main {

    static final int NMAX = 10;
    static int N, E, a, b;
    static int[][] Edge = new int[NMAX][NMAX], tEdge = new int[NMAX][NMAX];
    static int tmp, ret;
    static ArrayList<Integer> num = new ArrayList<>();
    static int[] check = new int[1 << NMAX];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        while (N-- > 0) {
            for (int[] row : Edge) {
                Arrays.fill(row, 0);
            }

            E = sc.nextInt();
            for (int i = 1; i <= E; i++) {
                a = sc.nextInt() - 1;
                b = sc.nextInt() - 1;

                Edge[a][b] = Edge[b][a] = 1;
            }

            num.clear();
            for (int i = 0; i < 5; i++) num.add(i);
            do {
                for (int[] row : tEdge) {
                    Arrays.fill(row, 0);
                }

                tmp = 0;
                for (int i = 0, t = 0; i < 5; i++) {
                    for (int j = i + 1; j < 5; j++, t++) {
                        tmp |= (Edge[num.get(i)][num.get(j)] << t);
                    }
                }

                if (check[tmp] > 0) {
                    check[tmp]++;
                    break;
                }

            } while (nextPermutation(num));

            if (check[tmp] == 0) check[tmp]++;
        }

        for (int i = 0; i < (1 << NMAX); i++) {
            if (check[i] == 1) ret++;
        }

        System.out.println(ret);
    }

    static boolean nextPermutation(ArrayList<Integer> array) {
        int i = array.size() - 1;
        while (i > 0 && array.get(i - 1) >= array.get(i)) i--;

        if (i <= 0) return false;

        int j = array.size() - 1;
        while (array.get(j) <= array.get(i - 1)) j--;

        Collections.swap(array, i - 1, j);
        Collections.reverse(array.subList(i, array.size()));
        return true;
    }
}