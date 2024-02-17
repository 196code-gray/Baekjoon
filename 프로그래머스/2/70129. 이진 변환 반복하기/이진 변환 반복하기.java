class Solution {
    public int[] solution(String s) {
                int[] ans = new int[2];
        ans[1] += s.length() - s.replace("0","").length();
        int own = s.replace("0","").length();
        String a=Integer.toBinaryString(own);
        ans[0]++;
        while (!a.equals("1")){
            ans[1] += a.length() - a.replace("0","").length();
            own = a.replace("0","").length();
            a=Integer.toBinaryString(own);
            ans[0]++;
        }
        return ans;
    }
}