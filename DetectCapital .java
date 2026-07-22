class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int capitals = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                capitals++;
            }
        }
        
        // 1. All uppercase ("USA")
        if (capitals == word.length()) return true;
        
        // 2. All lowercase ("leetcode")
        if (capitals == 0) return true;
        
        // 3. Only the first letter is uppercase ("Google")
        if (capitals == 1 && Character.isUpperCase(word.charAt(0))) return true;
        
        return false;
    }
}