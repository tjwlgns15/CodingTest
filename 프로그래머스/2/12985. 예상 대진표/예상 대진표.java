class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int mul = (int) (Math.log(n) / Math.log(2));
        
        for (int i = 1; i <= mul; i++) {            
            if ((min % 2 != 0) && (max - min == 1)) {
                answer = i;
                
                return answer;
            }
            max = (max % 2 == 0) ? (max / 2) : (max / 2 + 1);
            min = (min % 2 == 0) ? (min / 2) : (min / 2 + 1);
        }
        
        return answer;
    }
}