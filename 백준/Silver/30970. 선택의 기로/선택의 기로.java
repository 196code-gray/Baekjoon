import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return Integer.compare(b[0], a[0]);  // 품질이 높은 순서로 정렬
                } else {
                    return Integer.compare(a[1], b[1]);  // 가격이 낮은 순서로 정렬
                }
            }
        });
        int[] firstMethodResult = {arr[0][0], arr[0][1], arr[1][0], arr[1][1]};

        // 두 번째 방법에 따른 선택
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) {
                    return Integer.compare(a[1], b[1]);  // 가격이 낮은 순서로 정렬
                } else {
                    return Integer.compare(b[0], a[0]);  // 품질이 높은 순서로 정렬
                }
            }
        });
        int[] secondMethodResult = {arr[0][0], arr[0][1], arr[1][0], arr[1][1]};

        // 결과 출력
        System.out.println(Arrays.toString(firstMethodResult).replaceAll("[\\[\\],]", ""));
        System.out.println(Arrays.toString(secondMethodResult).replaceAll("[\\[\\],]", ""));
        }
    }