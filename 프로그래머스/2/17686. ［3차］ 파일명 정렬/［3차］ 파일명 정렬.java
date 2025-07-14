import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<File> list = new ArrayList<>();

        for (String s : files) {
            list.add(parseFile(s));
        }

        list.sort((a, b) -> {
            int compare = a.getHead().toLowerCase()
                    .compareTo(b.getHead().toLowerCase());
            if (compare != 0) {
                return compare;
            } else {
                return Integer.compare(a.getNumber(), b.getNumber());
            }
        });

        for (int i = 0; i < list.size(); i++) {
            String originalName = list.get(i).originalName;
            answer[i] = originalName;
        }

        return answer;
    }

    private File parseFile(String fileName) {
        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();
        int i = 0;

        // HEAD
        while (i < fileName.length() && !Character.isDigit(fileName.charAt(i))) {
            head.append(fileName.charAt(i++));
        }

        // NUMBER
        while (i < fileName.length() && Character.isDigit(fileName.charAt(i)) && number.length() < 5) {
            number.append(fileName.charAt(i++));
        }

        // TAIL
        String tail = fileName.substring(i);

        return new File(fileName, head.toString(), Integer.parseInt(number.toString()), tail);
    }


    public static class File {
        String originalName;
        String head;
        int number;
        String tail;

        public File(String original, String head, int number, String tail) {
            this.originalName = original;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        public String getHead() {
            return head;
        }

        public int getNumber() {
            return number;
        }
    }
}