class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> ans = new ArrayList<>();

        // Mark numbers that are present
        boolean[] present = new boolean[upper - lower + 1];

        for (int num : nums) {
            if (num >= lower && num <= upper) {
                present[num - lower] = true;
            }
        }

        // Find missing ranges
        int i = 0;

        while (i < present.length) {

            if (present[i]) {
                i++;
                continue;
            }

            int start = i;

            // Find consecutive missing numbers
            while (i < present.length && !present[i]) {
                i++;
            }

            int end = i - 1;

            List<Integer> range = new ArrayList<>();
            range.add(start + lower);
            range.add(end + lower);

            ans.add(range);
        }

        return ans;
    }
}