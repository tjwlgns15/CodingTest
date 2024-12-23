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
        List<Data> list = Arrays.stream(data)
                .map(Data::new)
                .filter(d -> d.getField(ext) < val_ext)
                .sorted(Comparator.comparingInt(d -> d.getField(sort_by)))
                .collect(Collectors.toList());

        int[][] answer = new int[list.size()][4];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).toArray();
        }

        return answer;
    }
}
