class Solution {
    public int findWaviness(int num) {
        String s = String.valueOf(num);
        int score = 0;
        int l = s.length();
        for (int i = 1; i < l - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1) && s.charAt(i) > s.charAt(i - 1)) {
                score++;
            } else if (s.charAt(i) < s.charAt(i + 1) && s.charAt(i) < s.charAt(i - 1)) {
                score++;
            } else {
                continue;
            }
        }
        return score;

    }

    public int totalWaviness(int num1, int num2) {

        int score = 0;

        for (int num = num1; num <= num2; num++) {
            score += findWaviness(num);
        }
        return score;

    }
}