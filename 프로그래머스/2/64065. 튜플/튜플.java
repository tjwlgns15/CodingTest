import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        s = s.substring(2, s.length() - 2);
        String[] arr = s.split("},\\{");
        
        List<Set<Integer>> tupleList = new ArrayList<>();
        
        for (String str : arr) {
            Set<Integer> set = new HashSet<>();
            
            for (String element : str.split(",")) {
                set.add(Integer.parseInt(element));
            }
            tupleList.add(set);
        }
        tupleList.sort(Comparator.comparingInt(Set::size));
        
        List<Integer> result = new ArrayList<>();
        
        for (Set<Integer> set : tupleList) {
            for (int num : set) {
                if (!result.contains(num)) {
                    result.add(num);
                    break;
                }
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
        
    }
}