class Solution {
    public String solution(int[] food) {
        String answer = "";
        String str = "";
        for (int i = 1; i < food.length; i++) {
                int num = food[i] / 2;
                answer += String.valueOf(i).repeat(num);
                str = String.valueOf(i).repeat(num) + str;
        }
        return answer + "0" + str;
    }
}