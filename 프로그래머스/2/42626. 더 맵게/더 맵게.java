import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i : scoville) {
            heap.offer(i);
        }

        while (heap.size() >= 2 && heap.peek() < K) {
            int first = heap.poll();
            int second = heap.poll();
            int mix = first + second * 2;

            heap.offer(mix);
            answer++;
        }

        return heap.peek() >= K ? answer : -1;
    }
}
