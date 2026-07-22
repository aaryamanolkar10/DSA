class Solution {
    public int longestConsecutive(int[] nums) {

        // Store all numbers in a HashSet for O(1) lookups
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Iterate through each unique number
        for (int num : set) {

            // Only start counting if this is the beginning of a sequence
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int currentLength = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                longest = Math.max(longest, currentLength);
            }
        }

        return longest;
    }
}