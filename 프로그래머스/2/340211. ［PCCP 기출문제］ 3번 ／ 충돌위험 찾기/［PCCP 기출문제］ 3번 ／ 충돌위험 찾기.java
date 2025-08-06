import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {

        List<List<int[]>> paths = new ArrayList<>();

        for (int[] route : routes) {
            List<int[]> path = new ArrayList<>();

            int[] currentPosition = points[route[0] - 1].clone();
            path.add(currentPosition.clone());

            for (int i = 1; i < route.length; i++) {
                int[] target = points[route[i] - 1];

                while (currentPosition[0] != target[0]) {
                    if (currentPosition[0] < target[0]) {
                        currentPosition[0]++;
                    } else {
                        currentPosition[0]--;
                    }
                    path.add(currentPosition.clone());
                }

                while (currentPosition[1] != target[1]) {
                    if (currentPosition[1] < target[1]) {
                        currentPosition[1]++;
                    } else {
                        currentPosition[1]--;
                    }
                    path.add(currentPosition.clone());
                }
            }
            paths.add(path);
        }

        int answer = 0;
        int maxCount = paths.stream()
                .mapToInt(List::size)
                .max()
                .orElse(0);

        for (int time = 0; time < maxCount; time++) {
            Map<String, Integer> positionCount = new HashMap<>();

            for (List<int[]> path : paths) {
                if (time < path.size()) {
                    int[] pos = path.get(time);
                    String posKey = pos[0] + "," + pos[1];
                    positionCount.put(posKey, positionCount.getOrDefault(posKey, 0) + 1);
                }
            }

            for (int count : positionCount.values()) {
                if (count >= 2) {
                    answer++;
                }
            }
        }

        return answer;
    }
}