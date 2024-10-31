class Solution {
    public int solution(int n) {
        int answer = countPrimes(n);
        
        return answer;
    }
    
    public static int countPrimes(int n) {
        int count = 0;
        
        if (n < 2) {
            return 0;
        }
        
        boolean[] isPrimes = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrimes[i] = true;
        }
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrimes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
        
        for (int i = 2; i <= n; i++) {
            if (isPrimes[i]) {
                count++;
            }
        }
        
        return count;
    }
}