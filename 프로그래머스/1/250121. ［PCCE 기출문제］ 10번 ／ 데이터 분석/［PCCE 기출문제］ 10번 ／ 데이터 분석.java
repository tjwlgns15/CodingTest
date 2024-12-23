import java.util.*;

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
            switch (field) {
                case "code":
                    return this.code;
                case "date":
                    return this.date;
                case "maximum":
                    return this.maximum;
                case "remain":
                    return this.remain;
                default:
                    return -1;
            }
        }

        public int[] toArray() {
            return new int[]{code, date, maximum, remain};
        }
    }
    
    
    private List<Data> filterData(List<Data> list, String ext, int val_ext) {
        List<Data> filterData = new ArrayList<Data>();
        
        for (Data data : list) {
            if (data.getField(ext) < val_ext) {
                filterData.add(data);
            }
        }
        return filterData;
    }

    
    private void sortData(List<Data> list, String sort_by) {
        list.sort(Comparator.comparingInt(data -> data.getField(sort_by)));
    }
    
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Data> list = new ArrayList<>();
        
        for(int[] d : data) {
            list.add(new Data(d));
        }
        
        list = filterData(list, ext, val_ext);        
        sortData(list, sort_by);
        
        int[][] answer = new int[list.size()][4];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).toArray();
        }
        
        return answer;
    }
}