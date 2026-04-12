class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int out = 0;
        for(String i : tokens){
            if(isOpearator(i)){
                int op1 = Integer.parseInt(stack.pop());
                int op2 = Integer.parseInt(stack.pop());
                out = operation(op1, op2, i);
                stack.push(out+"");
            }else{
                stack.push(i);
            }
        }
        
        return Integer.parseInt(stack.pop());
    }
    public boolean isOpearator(String ch){
        if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) return true;
        
        return false;
    }
    
    public int operation(int op1, int op2, String operator){
        if(operator.equals("+")) {
            return op1 + op2;
        }else if(operator.equals("-")){
            return op2 - op1;
        }else if(operator.equals("*")){
            return op1 * op2;
        }else {
            return op2 / op1;
        }
    }
   
}
