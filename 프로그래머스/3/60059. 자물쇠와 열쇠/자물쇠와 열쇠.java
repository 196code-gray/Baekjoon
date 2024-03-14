import java.util.*;

class Solution {
     public boolean solution(int[][] key, int[][] lock) {
        // 90도씩 회전한 열쇠 기록
        int[][][] keyTurn = new int[4][key.length][key.length];
        keyTurn[0] = key; // 정상 열쇠
        keyTurn[1] = Turn(key); // 한번 회전 (90)
        keyTurn[2] = Turn(keyTurn[1]); // 두번 회전 (180)
        keyTurn[3] = Turn(keyTurn[2]);  // 세번 회전(280)
        int empty = 0; // 좌물쇠의 빈 홈 개수

        for (int idx = 0; idx < lock.length; idx++) {
            for (int inner = 0; inner < lock.length; inner++) {
                if (lock[idx][inner] == 0) empty++;
            }
        }
        if (empty == 0) return true;
        for (int right = 1 - key.length; right < lock.length; right++) {
            for (int down = 1 - key.length; down < lock.length; down++) {
                for (int turnCount = 0; turnCount < 4; turnCount++) {
                    if (open(keyTurn[turnCount], lock, right, down, empty)) return true;
                }
            }
        }
        return false;
    }

    static int[][] Turn(int[][] arr) {
        int[][] tarr = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(tarr[i], 1);
        }
        for (int i = 0; i < arr.length; i++) { // 열
            for (int j = 0; j < arr.length; j++) { // 행
                tarr[i][j] = arr[(arr.length - 1) - j][i];
            }
        }
        return tarr;
    }

    static boolean open(int[][] key, int[][] lock, int right, int down, int empty) {
        for (int idx = 0; idx < key.length; idx++) {
            if (idx + down >= lock.length || idx + down < 0) continue;
            for (int inner = 0; inner < key.length; inner++) {
                if (inner + right >= lock.length || inner + right < 0) continue;
                // 열쇠와 좌물쇠 모두 빈 홈이거나 돌기일 경우
                if (key[idx][inner] == lock[idx + down][inner + right]) return false;
                // 좌물쇠가 빈 홈인지 확인
                if (lock[idx + down][inner + right] == 0) empty--;
            }
        }
        if (empty == 0) return true;
        return false;
    }
}