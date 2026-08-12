class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int result=0;
        Set<Character> set=new HashSet<>();
        for(char i:jewels.toCharArray()){
            set.add(i);
        }
        for(char i:stones.toCharArray()){
            if(set.contains(i)){
                result++;
            }
        }
        return result;
    }
}