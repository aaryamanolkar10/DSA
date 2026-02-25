class Solution {
    public int calPoints(String[] operations) {
        int total=0;
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<operations.length;i++){
            String num=operations[i];

            if(num.equals("+")){
                int val1=stack.pop();
                int val2=stack.pop();
                int newK=val1+val2;
                stack.push(val2);
                stack.push(val1);
                stack.push(newK);

            }
            else if(num.equals("D")){
                stack.push(2*stack.peek());

            }
            else if(num.equals("C")){
                stack.pop();

            }
            else{
                stack.push(Integer.parseInt(num));
            }
            
        }
        while(!stack.isEmpty()){
            total+=stack.pop();
        }
        return total;
        
    }
}