class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder binary = new StringBuilder();

        for (char c : s.toCharArray()) {
            String b = Integer.toBinaryString(c);

            // Add leading zeros to make it exactly 8 bits
            while (b.length() < 8) {
                b = "0" + b;
            }

            binary.append(b);
        }

        // Check if binary string is a palindrome
        int left = 0;
        int right = binary.length() - 1;

        while (left < right) {
            if (binary.charAt(left) != binary.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}