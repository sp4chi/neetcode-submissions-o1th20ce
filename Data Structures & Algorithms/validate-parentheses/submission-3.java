class Solution {
    public boolean isValid(String s) {
         char[] input = s.toCharArray();
        
        if(input.length %2 != 0) return false;
        
        Stack<Character> stack = new Stack<>();
        
        for(char i : input){
            if( i == '(' || i == '{' || i == '['){
                stack.push(i);
            }else {
                if(stack.isEmpty()){
                    return false;
                }else if(!stack.isEmpty() ){
                    
                    char peek = stack.pop();
                    
                    if(peek == '(' && i != ')') return false;
                    else if(peek == '{' && i != '}') return false;
                    else if(peek == '[' && i != ']') return false;
                }
            }
        }
         
        
        return stack.isEmpty();
    }
}
