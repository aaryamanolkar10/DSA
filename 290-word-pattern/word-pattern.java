class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        
        // Step 1: Length check
        if(pattern.length() != arr.length) return false;
        
        HashMap<Character, String> hm = new HashMap<>();
        
        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            
            if(hm.containsKey(ch)){
                // Check mismatch
                if(!hm.get(ch).equals(arr[i])){
                    return false;
                }
            } 
            else {
                // Check if value already mapped to another key
                if(hm.containsValue(arr[i])){
                    return false;
                }
                hm.put(ch, arr[i]);
            }
        }
        return true;
    }
}