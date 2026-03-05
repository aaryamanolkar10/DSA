class Solution {
    class Node{
        char data;
        int freq;
        Node(char d,int f){
            data=d;
            freq=f;

        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Node> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(!stack.isEmpty() && stack.peek().data==c){
                Node rv=stack.pop();
                rv.freq+=1;
                stack.push(rv);

            }
            else{
                stack.push(new Node(c,1));
            }
            if(stack.peek().freq==k && !stack.isEmpty()){
                stack.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            Node rv=stack.pop();
            int freq=rv.freq;
            while(freq-->0){
                sb.append(rv.data);
            }
        }
        return sb.reverse().toString();
        
    }
}