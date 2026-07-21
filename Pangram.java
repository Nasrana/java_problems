class Pangram {
    public boolean checkIfPangram(String sentence) {
        
        boolean[] letters = new boolean[26];
        
        // Mark each letter present
        for (int i = 0; i < sentence.length(); i++) {
            letters[sentence.charAt(i) - 'a'] = true;
        }
        
        // Check if every letter is present
        for (int i = 0; i < 26; i++) {
            if (letters[i] == false) {
                return false;
            }
        }
        
        return true;
    }
}