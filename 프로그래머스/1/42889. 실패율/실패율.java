import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Integer> stageCount = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            stageCount.put(i, 0);
        }

        for (int stage : stages) {
            if (stage <= N) {
                stageCount.put(stage, stageCount.get(stage) + 1);
            }
        }

        List<double[]> failRates = new ArrayList<>();
        int playersLeft = stages.length;

        for (int i = 1; i <= N; i++) {
            int count = stageCount.get(i);
            double failureRate = playersLeft == 0 ? 0 : (double) count / playersLeft;
            failRates.add(new double[] {i, failureRate});
            playersLeft -= count;
        }

        failRates.sort(
            (a, b) -> Double.compare(b[1], a[1]) == 0 ? Double.compare(a[0], b[0]) : Double.compare(b[1], a[1]));

        for (int i = 0; i < N; i++) {
            answer[i] = (int) failRates.get(i)[0];
        }

        return answer;
    }
}
