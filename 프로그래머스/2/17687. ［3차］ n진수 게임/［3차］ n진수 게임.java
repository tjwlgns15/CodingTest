class Solution {
    public String solution(int n, int t, int m, int p) {

        Calculator calculator = new Calculator(n, t, m, p);
        return calculator.start();
    }


    private static class Calculator {
        private int  n;
        private int t;
        private int m;
        private int p;
        private String convertedNumber;


        public Calculator(int n, int t, int m, int p) {
            this.n = n;
            this.t = t;
            this.m = m;
            this.p = p;

            StringBuilder builder = new StringBuilder();

            int number = 0;
            while (builder.length() < t * m) {
                builder.append(convertBase(number++, n));
            }

            this.convertedNumber = builder.toString().toUpperCase();
        }

        public static String convertBase(int number, int base) {
            if (base < Character.MIN_RADIX || base > Character.MAX_RADIX) {
                throw new IllegalArgumentException("지원하지 않는 진수입니다: " + base);
            }
            return Integer.toString(number, base);
        }

        public String start() {
            StringBuilder builder = new StringBuilder();

            for (int i = p - 1; builder.length() < t; i += m) {
                builder.append(this.convertedNumber.charAt(i));
            }

            return builder.toString();
        }
    }
}