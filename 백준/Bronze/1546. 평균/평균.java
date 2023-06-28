import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n 에 과목 개수 선언
        int a = sc.nextInt();
        // int[] score 선언하기
        int[] score = new int[a];
        // for (score[] 길이 만큼 반복 {
        for (int i = 0; i < score.length; i++) {
            score[i] = sc.nextInt();
        }
        // score[] 에 점수 저장
        // }
        int sum = 0;
        int high = 0;
        // for (score 길이만큼 반복 {
        for (int i = 0; i < score.length; i++) {
            sum += score[i];
            if (score[i] > high) {
                high = score[i];
            }
        }
        System.out.println(sum * 100.0 / high / score.length);
    }
}