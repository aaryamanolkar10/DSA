class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> separatedDigits = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int n = nums[i];
            while (n != 0) {
                int digit = n % 10;
                separatedDigits.add(digit);
                n /= 10;
            }
        }
        int[] result = new int[separatedDigits.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = separatedDigits.get(separatedDigits.size() - 1 - i);
        }
        return result;
    }
}