class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < schedules.length; i++) {
            int cnt = 0;
            int schedule = calcM(schedules[i]);
            
            for (int j = 0; j < 7; j++) {
                int day = (startday + j) % 7;
                if (day != 0 && day != 6 && timelogs[i][j] <= schedule) {
                    cnt++;
                }
            }
            if (cnt == 5) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private int calcM(int time) {
        int hour = time / 100;
        int minute = time % 100;
        
        minute += 10;
        if (minute >= 60) {
            hour++;
            minute %= 60;
        }
        
        return hour * 100 + minute;
    }
}