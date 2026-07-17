class Parantheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // opening bracket: push it, we'll need to match it later
                stack.push(c);
            } else {
                // closing bracket: the top of the stack must be its pair
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // if anything's left unmatched, it's invalid
        return stack.isEmpty();
    }
}