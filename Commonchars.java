import java.util.ArrayList;
import java.util.List;

class Commonchars {
    public List<String> commonChars(String[] words) {
        int[] minCount = new int[26];
        // Initialize with the counts from the first word
        for (char c : words[0].toCharArray()) {
            minCount[c - 'a']++;
        }
        
        // For each subsequent word, take the minimum count per character
        for (int i = 1; i < words.length; i++) {
            int[] count = new int[26];
            for (char c : words[i].toCharArray()) {
                count[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                minCount[j] = Math.min(minCount[j], count[j]);
            }
        }
        
        // Build the result list
        List<String> result = new ArrayList<>();
        for (int j = 0; j < 26; j++) {
            for (int k = 0; k < minCount[j]; k++) {
                result.add(String.valueOf((char) ('a' + j)));
            }
        }
        
        return result;
    }
}