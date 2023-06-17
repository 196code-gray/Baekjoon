import java.util.*;
class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        int answer = sides[0] + sides[1];
        return answer > sides[2] ? 1 : 2;
    }
}