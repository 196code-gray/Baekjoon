class Solution {
    public boolean solution(int x) {
        int num = 0;
        int n = x;
        while (n > 0) {
            num += n % 10;
            n /= 10;
        }

        return x % num == 0;
    }
}