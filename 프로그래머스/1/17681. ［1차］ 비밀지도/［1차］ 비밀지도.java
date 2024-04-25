class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            int num = arr1[i] | arr2[i];            
            String result = Integer.toBinaryString(num); 
            String formattedString = String.format("%" + n + "s", result).replace(' ', '0');
            answer[i] = formattedString.replace('1', '#').replace('0', ' ');
        }
        
        return answer;
    }
}