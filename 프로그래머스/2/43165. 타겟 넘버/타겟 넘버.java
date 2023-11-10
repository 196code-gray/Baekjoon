class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0, 0, numbers, target);
        return answer;
    }
    private void dfs(int sum, int index, int[] nums, int target) {
        // 종료 시점 : 현재 수가 타겟과 같으면서 인덱스가 numbers 길이와 같을 때
        if (sum == target && index == nums.length) {
            answer++;
            return;
        }
        if (index >= nums.length) {
            return;
        }
        dfs(sum + nums[index], index+1, nums, target);
        dfs(sum - nums[index], index+1, nums, target);
    }
}