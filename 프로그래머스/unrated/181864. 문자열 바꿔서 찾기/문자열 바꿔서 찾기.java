class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        myString = myString.replace("A", "C").replace("B", "A").replace("C", "B");        
        answer =  myString.contains(pat) ? 1 : 0;
        return answer;
    }
}