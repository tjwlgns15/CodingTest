import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> map = new HashMap<>(friends.length);
        int[] giveReceivePoint = new int[friends.length];
        int[][] count = new int[friends.length][friends.length];
        
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }
        
        for (String gift : gifts) {
            String[] giftInfo = gift.split(" ");
            int giver = map.get(giftInfo[0]);
            int receiver = map.get(giftInfo[1]);
            
            giveReceivePoint[giver]++;
            giveReceivePoint[receiver]--;
            count[giver][receiver]++;
        }
        
        int[] result = new int[friends.length];
        int max = 0;
        
        for (int i = 0; i < friends.length - 1; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                if (count[i][j] > count[j][i]) {
                    max = Math.max(max, ++result[i]);
                } else if (count[i][j] < count[j][i]) {
                    max = Math.max(max, ++result[j]);
                } else if (giveReceivePoint[i] > giveReceivePoint[j]) {
                    max = Math.max(max, ++result[i]);
                } else if (giveReceivePoint[i] < giveReceivePoint[j]) {
                    max = Math.max(max, ++result[j]);
                }
            }
        }
        
        return max;
    }
}