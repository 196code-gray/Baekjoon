import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Integer[] arr = Arrays.stream(B).boxed().sorted(Collections.reverseOrder()).toArray(Integer[]::new);
        // Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * arr[i];
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}