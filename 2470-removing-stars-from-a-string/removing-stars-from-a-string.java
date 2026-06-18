class Solution {
    public String removeStars(String s) {
        Stack stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        int x = stack.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x; i++) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}