import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Set<Character> skillSet = new HashSet<>();

        for (char c : skill.toCharArray()) {
            skillSet.add(c);
        }

        for (String skillTree : skill_trees) {
            StringBuilder builder = new StringBuilder();

            for (char c : skillTree.toCharArray()) {
                if (skillSet.contains(c)) {
                    builder.append(c);
                }
            }

            if (skill.startsWith(builder.toString())) {
                answer++;
            }
        }
        
        return answer;
    }
}