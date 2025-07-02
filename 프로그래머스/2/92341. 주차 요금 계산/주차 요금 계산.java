import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Recode> carMap = new HashMap<>();

        for (String record : records) {
            String[] parts = record.split(" ");
            LocalTime time = LocalTime.parse(parts[0]);
            String carNumber = parts[1];
            String action = parts[2];

            Recode recode = carMap.getOrDefault(carNumber, new Recode(carNumber));

            if ("IN".equals(action)) {
                recode.enter(time);
            } else {
                recode.exit(time);
            }

            carMap.put(carNumber, recode);
        }

        List<String> carNumbers = new ArrayList<>(carMap.keySet());
        Collections.sort(carNumbers);

        int[] answer = new int[carNumbers.size()];
        for (int i = 0; i < carNumbers.size(); i++) {
            Recode recode = carMap.get(carNumbers.get(i));
            recode.calculate(fees[0], fees[1], fees[2], fees[3]);
            answer[i] = recode.getFee();
        }

        return answer;
    }

    private static class Recode {
        private final String carNumber;
        private LocalTime enterTime;
        private int totalMinutes;
        private int fee;
        private boolean isIn;

        public Recode(String carNumber) {
            this.carNumber = carNumber;
            this.totalMinutes = 0;
            this.isIn = false;
        }

        public void enter(LocalTime enterTime) {
            this.enterTime = enterTime;
            this.isIn = true;
        }

        public void exit(LocalTime exitTime) {
            if (isIn && enterTime != null) {
                Duration duration = Duration.between(enterTime, exitTime);
                totalMinutes += duration.toMinutes();
            }
            this.isIn = false;
        }

        public void calculate(int defaultMinutes, int defaultFee, int unitMinutes, int unitFee) {
            if (isIn) {
                exit(LocalTime.of(23, 59));
            }

            if (totalMinutes <= defaultMinutes) {
                this.fee = defaultFee;
            } else {
                double extraTime = (double)(totalMinutes - defaultMinutes) / unitMinutes;
                this.fee = defaultFee + (int)Math.ceil(extraTime) * unitFee;
            }
        }

        public int getFee() {
            return fee;
        }
    }
}
