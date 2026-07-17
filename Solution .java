class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;

        // Step 1: Skip any leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // If we've hit the end of the string, there's nothing to convert
        if (i == n) {
            return 0;
        }

        // Step 2: Check for an optional sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Read digits, building the number as we go.
        // We accumulate using a long so we can detect overflow
        // before it wraps around in a normal int.
        long result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            result = result * 10 + digit;

            // Step 4: Clamp early if we've already blown past the int range.
            // No point reading more digits once we're out of bounds -
            // the answer is already pinned to one of the extremes.
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) (sign * result);
    }
}