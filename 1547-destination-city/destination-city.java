class Solution {
    public String destCity(List<List<String>> paths) {
        //create hashset
        Set<String> set=new HashSet<>();

        //add starting city to hashset
        for(List<String> path:paths){
            set.add(path.get(0));
        } 

        //check if destination city is already in hashset
        for(List<String> path:paths){
            if(!set.contains(path.get(1))){
                return path.get(1);
            }
        }
        return null;
    }
}