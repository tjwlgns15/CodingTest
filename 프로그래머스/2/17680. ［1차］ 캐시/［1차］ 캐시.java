import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        Map<String, String> cache = new LinkedHashMap<>(cacheSize, 0.75f, true);
        for (String city : cities) {
            String lowCity = city.toLowerCase();
            
            if (cache.containsKey(lowCity)) {
                answer++;
            } else {
                answer += 5;
                
                if (cache.size() >= cacheSize) {
                    String oldKey = cache.keySet().iterator().next(); // 첫번 째 요소
                    cache.remove(oldKey);
                }
            }
            cache.put(lowCity, lowCity);
        }
        
        return answer;
    }
}