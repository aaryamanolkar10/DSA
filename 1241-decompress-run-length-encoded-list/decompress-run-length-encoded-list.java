class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i+=2){
            int freq=nums[i],val=nums[i+1];
            while(freq-->0){
                list.add(val);
            }
        } 
        return list.stream().mapToInt(i->i).toArray();
    }
}