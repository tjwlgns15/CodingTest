import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Set<String> set = new HashSet<String>();
        int x = 0;
        int y = 0;

        for (char c : dirs.toCharArray()) {
            int x2 = x;
            int y2 = y;

            switch (c) {
                case 'U':
                    x2++;
                    break;
                case 'D':
                    x2--;
                    break;
                case 'R':
                    y2++;
                    break;
                case 'L':
                    y2--;
                    break;
            }

            if (x2 < -5 || x2 > 5 || y2 < -5 || y2 > 5) continue;

            String path = x + "," + y + "," + x2 + "," + y2;
            String reverse = x2 + "," + y2 + "," + x + "," + y;

            if (!set.contains(path) && !set.contains(reverse)) {
                set.add(path);
                set.add(reverse);
            }

            x = x2;
            y = y2;
        }
        
        return set.size() / 2;
    }

}