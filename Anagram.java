import java.util.Arrays;

class Anagram {
    public boolean isAnagram(String s, String t) {

        // Check if both strings have the same length
        if (s.length() != t.length()) {
            return false;
        }

        // Convert strings to character arrays
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        // Sort the arrays
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        // Compare the sorted arrays
        return Arrays.equals(sArr, tArr);
    }
}