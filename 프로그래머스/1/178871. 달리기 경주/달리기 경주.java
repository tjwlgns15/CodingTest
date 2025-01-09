import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (String call : callings) {
            int rank = map.get(call);
            if (rank > 0) {
                String pre = players[map.get(call) - 1];
                players[rank - 1] = call;
                players[rank] = pre;

                map.put(call, rank - 1);
                map.put(pre, rank);
            }
        }
        
        
        
        return players;
    }
}