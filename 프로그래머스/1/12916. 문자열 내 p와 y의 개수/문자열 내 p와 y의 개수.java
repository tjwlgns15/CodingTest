class Solution {
    boolean solution(String s) {
        boolean answer = true;        
        String str1 = s.toLowerCase();
//         int pCount = str1.replaceAll("[Yy]","").length();
//         int yCount = str1.replaceAll("[Pp]","").length();
//         if (!(pCount == yCount)) {
//             answer = false;
//         }
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == 'p') {
                count++;
            } else if (str1.charAt(i) == 'y') {
                count--;
            }
        }
        if (count != 0) {
            answer = false;
        }
        
        return answer;
    }
}