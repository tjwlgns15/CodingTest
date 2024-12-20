import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> map = new HashMap<>();
        int[] giveReceivePoint = new int[friends.length];
        int[][] count = new int[friends.length][friends.length];

        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }

        for (String gift : gifts) {
            String giver = gift.split(" ")[0];
            String receiver = gift.split(" ")[1];

            giveReceivePoint[map.get(giver)]++;
            giveReceivePoint[map.get(receiver)]--;

            count[map.get(giver)][map.get(receiver)]++;
        }

        boolean[][] check = new boolean[friends.length][friends.length];
        int[] result = new int[friends.length];

        for (int i = 0; i < friends.length; i++) {
            for (int j = i; j < friends.length; j++) {
                if (!check[i][j] && i != j) {
                    if (count[i][j] > count[j][i]) {
                        result[i]++;
                    } else if (count[i][j] < count[j][i]) {
                        result[j]++;
                    } else {
                        if (giveReceivePoint[i] > giveReceivePoint[j]) {
                            result[i]++;
                        } else if (giveReceivePoint[i] < giveReceivePoint[j]) {
                            result[j]++;
                        }
                    }
                }
            }
        }
        
        int max = result[0];
        
        for (int i = 1; i < result.length; i++) {
            if (result[i] > max) {
                max = result[i];
            }
        }

        return max;
    }
}