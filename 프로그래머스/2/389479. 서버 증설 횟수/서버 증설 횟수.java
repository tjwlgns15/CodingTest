import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int totalServers = 0;          // 총 증설된 서버 수
        int maxCapacity = m;           // 현재 처리 가능한 최대 인원
        Queue<int[]> serverQueue = new LinkedList<>();  // [서버 수, 남은 시간]
        
        for (int i = 0; i < players.length; i++) {
            // 현재 필요한 서버 계산
            if (players[i] >= m) {
                int neededServers = players[i] / m;  // 현재 시간에 필요한 총 서버 수
                
                // 현재 활성화된 서버 확인
                int queueSize = serverQueue.size();
                int activeServers = 0;
                
                // 큐에 있는 모든 서버 정보 확인
                for (int j = 0; j < queueSize; j++) {
                    int[] server = serverQueue.poll();
                    activeServers += server[0];  // 활성 서버 수 누적
                    serverQueue.add(server);     // 다시 큐에 넣기
                }
                
                // 추가 필요 서버 계산
                int additionalServers = neededServers - activeServers;
                
                // 서버 증설이 필요하면
                if (additionalServers > 0) {
                    serverQueue.add(new int[]{additionalServers, k});  // [서버 수, 남은 시간]
                    totalServers += additionalServers;
                    maxCapacity += additionalServers * m;  // 처리 가능 인원 증가
                }
            }
            
            // 서버 시간 관리
            int queueSize = serverQueue.size();
            for (int j = 0; j < queueSize; j++) {
                int[] server = serverQueue.poll();
                server[1]--;  // 남은 시간 감소
                
                // 시간이 남아있으면 다시 큐에 넣기
                if (server[1] > 0) {
                    serverQueue.add(server);
                } else {
                    maxCapacity -= server[0] * m;  // 처리 가능 인원 감소
                }
            }
        }
        
        return totalServers;
    }
}