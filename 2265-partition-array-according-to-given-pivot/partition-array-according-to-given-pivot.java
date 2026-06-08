class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int r = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                res[r++] = nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == pivot) {
                res[r++] = nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > pivot) {
                res[r++] = nums[i];
            }
        }
        return res;
    }
}