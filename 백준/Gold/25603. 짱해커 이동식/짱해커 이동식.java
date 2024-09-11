import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  
        int k = sc.nextInt(); 
        int res = Integer.MIN_VALUE;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        TreeMap<Integer, Integer> ms = new TreeMap<>();

        for (int i = 0; i < k; i++) {
            ms.put(arr[i], ms.getOrDefault(arr[i], 0) + 1);
        }

        res = Math.max(res, ms.firstKey());

        for (int i = k; i < n; i++) {
            int left = arr[i - k];
            int right = arr[i];

            if (ms.get(left) == 1) {
                ms.remove(left);
            } else {
                ms.put(left, ms.get(left) - 1);
            }

            ms.put(right, ms.getOrDefault(right, 0) + 1);

            res = Math.max(res, ms.firstKey());
        }

        System.out.println(res);
    }
}