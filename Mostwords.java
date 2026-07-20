class Mostwords {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;

        for (String sentence : sentences) {
            // Since there are no leading/trailing spaces,
            // word count = number of spaces + 1
            int count = 1;
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ') {
                    count++;
                }
            }
            maxWords = Math.max(maxWords, count);
        }

        return maxWords;
    }
}