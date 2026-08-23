class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result=new ArrayList<>();
        result.add(1);
        for(int i=1;i<=rowIndex;i++){
            List<Integer> currList=new ArrayList<>();
            currList.add(1);
            for(int j=1;j<result.size();j++){
                currList.add(result.get(j-1)+result.get(j));
            }
            currList.add(1);
            result=currList;
        }
        return result;
    }
}