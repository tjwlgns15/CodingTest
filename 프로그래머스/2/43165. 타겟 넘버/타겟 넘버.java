class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);
        return answer;
    }

    private int dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            return target == sum ? 1 : 0;
        }

        int add = dfs(numbers, target, index + 1, sum + numbers[index]);
        int sub = dfs(numbers, target, index + 1, sum - numbers[index]);
        
        return add + sub;
    }
}