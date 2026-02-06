class Solution {
    public char findTheDifference(String s, String t) {
        int value=0;
        int[] count=new int[26];
        char[] s1=s.toCharArray();
        char[] t1=t.toCharArray();
        for(int i=0;i<t1.length;i++){
            count[t1[i]-'a']--;
        }
        for(int i=0;i<s1.length;i++){
            count[s1[i]-'a']++;
        }
        for(int i=0;i<t1.length;i++){
            if(count[t1[i]-'a']==-1){
                value=i;
            }
        }
        return t1[value];
    }
}