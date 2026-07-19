class Isnumber {
    public boolean isNumber(String s) {
        int n = s.length();
        int i = 0;
        
        // optional sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }
        
        boolean digitsSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        
        while (i < n) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                digitsSeen = true;
                i++;
            } else if (c == '.') {
                // no more than one dot, and dot must come before 'e'
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
                i++;
            } else if (c == 'e' || c == 'E') {
                // must have seen digits before 'e', and only one 'e'
                if (eSeen || !digitsSeen) {
                    return false;
                }
                eSeen = true;
                digitsSeen = false; // reset: need digits after 'e' too
                i++;
                // optional sign after e
                if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                    i++;
                }
            } else {
                return false;
            }
        }
        
        return digitsSeen;
    }
}