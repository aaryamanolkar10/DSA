class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res=new ArrayList<>();
        HashSet<Integer> hash=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(hash.contains(nums[i])){
                res.add(nums[i]);
            }
            hash.add(nums[i]);
        }
        return res;
    }
}