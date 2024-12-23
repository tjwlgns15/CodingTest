import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static class Data {
        private int code;
        private int date;
        private int maximum;
        private int remain;

        public Data(int[] data) {
            this.code = data[0];
            this.date = data[1];
            this.maximum = data[2];
            this.remain = data[3];
        }

        public int getField(String field) {
            if ("code".equals(field)) return code;
            if ("date".equals(field)) return date;
            if ("maximum".equals(field)) return maximum;
            if ("remain".equals(field)) return remain;
            throw new IllegalArgumentException("Invalid field: " + field);
        }

        public int[] toArray() {
            return new int[]{code, date, maximum, remain};
        }
    }

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 데이터를 Data 객체 리스트로 변환, 필터링 및 정렬
        List<Data> list = Arrays.stream(data)
                .map(Data::new)
                .filter(d -> d.getField(ext) < val_ext)
                .sorted(Comparator.comparingInt(d -> d.getField(sort_by)))
                .collect(Collectors.toList());

        // 결과 배열로 변환
        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).toArray();
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] data = {
            {1, 20231201, 100, 50},
            {2, 20231202, 80, 30},
            {3, 20231203, 120, 60},
            {4, 20231204, 90, 20}
        };

        String ext = "maximum";
        int val_ext = 100;
        String sort_by = "remain";

        int[][] result = solution.solution(data, ext, val_ext, sort_by);

        // 결과 출력
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
