class Solution {
    boolean solution(String s) {
        boolean answer = true;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        String str1 = s.replaceAll("[^PpYy]","");
        int pCount = str1.replaceAll("[Yy]","").length();
        int yCount = str1.replaceAll("[Pp]","").length();
        if (!(pCount == yCount)) {
            answer = false;
        }

        return answer;
    }
}