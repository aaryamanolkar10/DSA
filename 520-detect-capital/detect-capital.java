class Solution {
    public boolean detectCapitalUse(String word) {
        int caps=0,low=0,first=0;
        for(char ch:word.toCharArray()){
            if(ch>=65 && ch<=90){
                caps++;
                if(first==0){
                    first++;
                }
            }else{
                low++;
                if(first==0){
                    first=2;
                }
            }

            
        }
        if(caps==0 || low==0 ||first==1 && caps==1){
            return true;
        }
        return false;
    }
}