import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for (int i : lost) {
            lostSet.add(i);
        }

        for (Integer i : reserve) {
            if (lostSet.contains(i)) {
                lostSet.remove(i);
            } else {
                reserveSet.add(i);
            }
        }

        for (Integer i : reserveSet) {
            if (lostSet.contains(i - 1)) {
                lostSet.remove(i - 1);
            } else if (lostSet.contains(i + 1)) {
                lostSet.remove(i + 1);
            }
        }

        int answer = n - lostSet.size();

        return answer;
    }
}
