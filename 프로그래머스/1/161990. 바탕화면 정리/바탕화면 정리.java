class Solution {
    public int[] solution(String[] wallpaper) {
        int luy = wallpaper.length;
        int lux = wallpaper[0].length();
        int rdy = 0;
        int rdx = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    luy = Math.min(luy, i);
                    rdy = Math.max(rdy, i);

                    lux = Math.min(lux, j);
                    rdx = Math.max(rdx, j);
                }
            }
        }

        return new int[]{luy, lux, rdy + 1, rdx + 1};
    }
}