import java.io.*;
import java.util.*;

public class Main {
    static int[] nowArr;
    static int check;
    static int[] pwArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());   // 문자열 길이
        int p = Integer.parseInt(st.nextToken());    // 부분 문자열 길이
        char[] arr = new char[s];   // 문자열
        pwArr = new int[4];  // 최소 개수
        nowArr = new int[4]; // 현재 개수
        int count = 0;  // 최종 종류 수
        check = 0;  // 몇개가 해당되는 지 판별

        arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        // 최소 개수 입력 받기
        for (int i = 0; i < 4; i++) {
            pwArr[i] = Integer.parseInt(st.nextToken());
            if (pwArr[i] == 0) check++;
        }

        for (int i = 0; i < p; i++) {
            add(arr[i]);
        }
        if (check == 4) count++;

        // 슬라이딩 윈도우 시작
        for (int i = p; i < s; i++) {
            int j = i - p;
            add(arr[i]);
            remove(arr[j]);
            if (check == 4) count++;
        }
        System.out.println(count);

    }

    private static void remove(char c) {
        switch (c) {
            case 'A' :
                if (pwArr[0] == nowArr[0]) check--;
                nowArr[0]--;
                break;
            case 'C' :
                if (pwArr[1] == nowArr[1]) check--;
                nowArr[1]--;
                break;
            case 'G' :
                if (pwArr[2] == nowArr[2]) check--;
                nowArr[2]--;
                break;
            case 'T' :
                if (pwArr[3] == nowArr[3]) check--;
                nowArr[3]--;
                break;
        }
    }

    private static void add(char arr) {
        switch (arr) {
            case 'A' :
                nowArr[0]++;
                if (pwArr[0] == nowArr[0]) check++;
                break;
            case 'C' :
                nowArr[1]++;
                if (pwArr[1] == nowArr[1]) check++;
                break;
            case 'G' :
                nowArr[2]++;
                if (pwArr[2] == nowArr[2]) check++;
                break;
            case 'T' :
                nowArr[3]++;
                if (pwArr[3] == nowArr[3]) check++;
                break;
        }

        }
    }