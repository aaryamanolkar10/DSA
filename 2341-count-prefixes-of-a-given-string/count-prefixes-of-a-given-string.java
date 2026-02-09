class Solution {
    public int countPrefixes(String[] words, String s) {
        int count=0;
        for(int i=0;i<words.length;i++){
            String c=words[i];
            if(s.indexOf(c)==0){
                count++;

            }
        }
        return count;
        
    }
}