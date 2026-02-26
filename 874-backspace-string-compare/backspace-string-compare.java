import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        // process string s
        for(char c : s.toCharArray()){

            if(c == '#'){
                if(!stack1.isEmpty()){
                    stack1.pop();
                }
            }
            else{
                stack1.push(c);
            }
        }

        // process string t
        for(char c : t.toCharArray()){

            if(c == '#'){
                if(!stack2.isEmpty()){
                    stack2.pop();
                }
            }
            else{
                stack2.push(c);
            }
        }

        return stack1.equals(stack2);
    }
}