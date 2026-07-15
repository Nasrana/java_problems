class Palindrome {
    public boolean isPalindrome(int x) {
        // Negative numbers are never palindromes (the '-' sign breaks symmetry)
        // Also, numbers ending in 0 (except 0 itself) can't be palindromes,
        // since a palindrome can't start with 0
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reverted = 0;
        while (x > reverted) {
            reverted = reverted * 10 + x % 10;
            x /= 10;
        }

        // Even-length numbers: x == reverted
        // Odd-length numbers: reverted has one extra middle digit, so divide by 10 to drop it
        return x == reverted || x == reverted / 10;
    }
}