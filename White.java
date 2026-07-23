class White {
    public boolean squareIsWhite(String coordinates) {
        // Get column number (1-8) using ASCII subtraction
        int col = coordinates.charAt(0) - 'a' + 1;
        
        // Get row number (1-8) using ASCII subtraction
        int row = coordinates.charAt(1) - '0';
        
        // If the sum of row and column is odd, the square is white (true)
        // If it is even, the square is black (false)
        return (col + row) % 2 != 0;
    }
}