import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // N(행) M(열)
        Integer[][] intarr = new Integer[9][9];

        for(int i = 0; i < intarr.length; i++) {
            for (int j = 0; j < intarr[i].length; j++) {
                intarr[i][j] = scanner.nextInt();
            }
        }
        // 제일 큰 값 찾기
        // 제일 큰 값을 저장 할 변수 생성 후 2차원 배열 하나 더 만들어서 자리만 저장
        int high = 0;
        int s = 0;
        int f = 0;

        for(int i = 0; i < intarr.length; i++) {
            for (int j = 0; j < intarr[i].length; j++) {
                if (intarr[i][j] > high) {
                    high = intarr[i][j];
                    s = i;
                    f = j;
                }
            }
        }
        System.out.println(high);

        System.out.println((s + 1) + " " + (f + 1));
    }
}
