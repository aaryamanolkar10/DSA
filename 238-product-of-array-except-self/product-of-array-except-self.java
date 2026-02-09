class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        ans[0] = 1;

        // left product
        for(int i = 1; i < n; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        int right = 1;

        // right product
        for(int i = n-1; i >= 0; i--){
            ans[i] = ans[i] * right;
            right *= nums[i];
        }

        return ans;
    }
}
