class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int len = toInt(video_len);
        int now = toInt(pos);
        int start = toInt(op_start);
        int end = toInt(op_end);
        
        if (isInOpening(now, start, end)) {
            now = end;
        }
        
        for (String command : commands) {
            if (command.equals("next")) {
                now = next(now, len);
            } else {
                now = prev(now);
            }
            
            if (isInOpening(now, start, end)) {
                now = end;
            }
        }
        String answer = toTime(now);
        
        return answer;
    }
    
    private int toInt(String s) {
        String[] time = s.split(":");
        int minutes = Integer.parseInt(time[0]);
        int seconds = Integer.parseInt(time[1]);
        return minutes * 60 + seconds;
    }

    private String toTime(int i) {
        return String.format("%02d:%02d", i / 60, i % 60);
    }
    
    private int next(int i, int len) {
        return Math.min(i + 10, len);
    }

    private int prev(int i) {
        return Math.max(i - 10, 0);
    }
    
    private boolean isInOpening(int now, int start, int end) {
        return start <= now && now <= end;
    }
}