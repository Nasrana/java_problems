class Divide {
    public int divide(int dividend, int divisor) {
        // Handle the one case that overflows: MIN_VALUE / -1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Figure out the sign of the result up front
        boolean isNegative = (dividend < 0) != (divisor < 0);

        // Work with positive longs so we don't have to worry about
        // overflow when negating Integer.MIN_VALUE
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        long quotient = 0;

        // Repeatedly subtract the largest possible multiple of the divisor
        // (found via doubling/bit-shifting) until nothing is left
        while (absDividend >= absDivisor) {
            long chunk = absDivisor;
            long multiple = 1;

            // Double the divisor as long as it still fits into what's left
            while (absDividend >= (chunk << 1)) {
                chunk <<= 1;
                multiple <<= 1;
            }

            absDividend -= chunk;
            quotient += multiple;
        }

        return isNegative ? (int) -quotient : (int) quotient;
    }   // <-- closes the method
}       // <-- closes the class