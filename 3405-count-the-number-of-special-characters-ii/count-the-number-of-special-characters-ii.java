class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lower = new int[26];
        int[] upper = new int[26];

        // Store last occurrence of lowercase
        // and first occurrence of uppercase
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {
                lower[ch - 'a'] = i + 1;
            } else {
                if (upper[ch - 'A'] == 0) {
                    upper[ch - 'A'] = i + 1;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (lower[i] > 0 && upper[i] > 0 &&
                    lower[i] < upper[i]) {
                count++;
            }
        }

        return count;
    }
}