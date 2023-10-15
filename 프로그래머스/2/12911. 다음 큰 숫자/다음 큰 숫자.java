class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = Integer.toBinaryString(n);
        int count = 0;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1') count++;
        }
        for (int i = n + 1; i < 1_000_000; i++) {
            String temp = Integer.toBinaryString(i);
            int temp_cnt = 0;
            for(int j = 0; j < temp.length(); j++) {
                if(temp.charAt(j) == '1') temp_cnt++;
            }
            if(temp_cnt == count) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}