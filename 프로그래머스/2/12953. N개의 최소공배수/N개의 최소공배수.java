class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            answer = lcm(answer, arr[i + 1]);
        }
        return answer;
    }
    
    public int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;            
        }
        
        return a;        
    }
    
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}