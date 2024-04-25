import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        
        if (nums.length / 2 > set.size()) {
            return answer = set.size();
        } else {
            return answer = nums.length / 2;
        }
    }
}