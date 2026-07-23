class Findwords {
    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        
        // Map each letter to its row index (0, 1, or 2)
        int[] rowOf = new int[26];
        for (int r = 0; r < rows.length; r++) {
            for (char c : rows[r].toCharArray()) {
                rowOf[c - 'a'] = r;
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            String lower = word.toLowerCase();
            int row = rowOf[lower.charAt(0) - 'a'];
            boolean sameRow = true;
            
            for (char c : lower.toCharArray()) {
                if (rowOf[c - 'a'] != row) {
                    sameRow = false;
                    break;
                }
            }
            
            if (sameRow) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[0]);
    }
}