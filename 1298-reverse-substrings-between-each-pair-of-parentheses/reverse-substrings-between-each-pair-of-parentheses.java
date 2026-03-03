class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            List<Character> temp=new ArrayList<>();
            if(ch==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    temp.add(stack.pop());
                }
                stack.pop();
                for(char c:temp){
                    stack.push(c);
                }
            
            }
            else{
                stack.push(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char c:stack){
            sb.append(c);
        }
        return sb.toString();
        
    }
}