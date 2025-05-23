import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = getWords(str1);
        List<String> list2 = getWords(str2);

        if (list1.isEmpty() && list2.isEmpty()) return 65536;  // 둘 다 공집합

        Map<String, Integer> map1 = getCountMap(list1);
        Map<String, Integer> map2 = getCountMap(list2);

        int intersection = 0;
        int union = 0;

        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());

        for (String key : allKeys) {
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);

            intersection += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }

        double similarity = (double) intersection / union;
        return (int) (similarity * 65536);
    }

    private List<String> getWords(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String subs = str.substring(i, i + 2).toLowerCase();
            if (subs.matches("[a-z]{2}")) {
                list.add(subs);
            }
        }
        return list;
    }

    private Map<String, Integer> getCountMap(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map;
    }
}
