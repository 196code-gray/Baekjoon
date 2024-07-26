import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] dura;
    static int[] weight;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        InputReader in = new InputReader(System.in);
        N = in.readInt();
        dura = new int[N];
        weight = new int[N];

        for(int i=0; i<N; i++) {
            dura[i] = in.readInt(); // 계란의 내구도
            weight[i] = in.readInt(); // 계란의 무게
        }

        bt(0, 0); // 0번째 계란부터 시작 , 이 땐 깨진 계란 0개

        System.out.println(max);
    }

    static void bt(int idx, int cnt) {
        if(idx == N) {
            max = Math.max(max, cnt);
            return;
        }
        if(dura[idx] <= 0 || cnt == N-1) {
            bt(idx + 1, cnt);
            return;
        }
        int nCnt = cnt;
        for(int i=0; i<N; i++) {
            if(i == idx) continue;
            if(dura[i] <= 0) continue;
            hitEgg(idx, i);
            if(dura[idx] <= 0) {
                cnt++;
            }
            if(dura[i] <= 0) {
                cnt++;
            }
            bt(idx + 1, cnt);
            recoveryEgg(idx, i);
            cnt = nCnt;
        }
    }

    static void hitEgg(int handEgg, int targetEgg) {
        dura[targetEgg] -= weight[handEgg];
        dura[handEgg] -= weight[targetEgg];
    }
    static void recoveryEgg(int handEgg, int targetEgg) {
        dura[targetEgg] += weight[handEgg];
        dura[handEgg] += weight[targetEgg];
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