package strings;

public class LongestSubSubstring {
    public static void main(String[] args) {
        String s = "GeeksForGeeks";

        for (int i = 0; i < s.length(); i++) {
            // initialize all chars to false
            boolean[] visited = new boolean[256];

            for (int j = i; j < s.length(); j++) {
                if (visited[s.charAt(j)]) {
                    break;
                } else {

                }
            }
        }
    }
}
