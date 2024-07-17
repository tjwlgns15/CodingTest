import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> hof = new PriorityQueue<>();
        int[] answer = new int[score.length];
        
        for (int i = 0; i < score.length; i++) {
            hof.offer(score[i]);
            
            if (hof.size() > k) {
                hof.poll();
            }
            
            answer[i] = hof.peek();
        }
        
        
        return answer;
    }
}