import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0;
        Stack<Integer> trucks = new Stack<>();
        Queue<Integer> bridge = new LinkedList<>();

        for (int i = truck_weights.length - 1; i >= 0; i--) {
            trucks.push(truck_weights[i]);
        }

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while (!trucks.isEmpty() || totalWeight > 0) {
            answer++;
            totalWeight -= bridge.poll();

            if (!trucks.isEmpty()) {
                Integer nextTruck = trucks.peek();

                if (totalWeight + nextTruck > weight) {
                    bridge.offer(0);
                } else {
                    trucks.pop();
                    bridge.offer(nextTruck);
                    totalWeight += nextTruck;
                }
            }
        }

        return answer;
    }
}
