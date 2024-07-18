class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            int count = countDivisors(i);
            
            if (count > limit) {
                answer += power;
            } else {
                answer += count;
            }
        }
        return answer;
    }
    
    public static int countDivisors(int n) {
        int sqrt = (int) Math.sqrt(n);
        int count = 0;

        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
}