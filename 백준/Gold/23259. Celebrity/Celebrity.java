import java.util.*;
import java.io.*;

    public class Main {
        static final int NMAX = 10;
        static int n, e, a, b;
        static int[][] Edge = new int[NMAX][NMAX], tEdge = new int[NMAX][NMAX];
        static int tmp, ret;
        static ArrayList<Integer> num = new ArrayList<>();
        static int[] check = new int[1 << NMAX];

        public static void main(String[] args) throws Exception {
            InputReader input = new InputReader(System.in);
            n = input.readInt();


            while (n --> 0) {
                for (int[] row : Edge) {
                    Arrays.fill(row, 0);
                }

                e = input.readInt();
                for (int i = 1; i <= e; i++) {
                    a = input.readInt() - 1;
                    b = input.readInt() - 1;

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


    private static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}