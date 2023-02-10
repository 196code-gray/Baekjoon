import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet <Integer> hashmap = new HashSet<>();
        int max = nums.length / 2;
        
        for (int num : nums) {
            hashmap.add(num);
        }
        if (hashmap.size() > max) {
            return max;
        }
        else return hashmap.size();
    }
}