package NeetCode150.Stack;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i <s.length(); i++){
            char si = s.charAt(i);
            if(si == '(' || si == '[' || si == '{'){
                stack.push(si);
            } else if(stack.isEmpty()){
                // faulty closing
                return false;
            } else {
                // match last opening bracket with current closing bracket
                String combination = "";
                combination += stack.pop();
                combination += si;
                boolean isCombinationValid = combination.equals("()") || combination.equals("[]") || combination.equals("{}");
                if(!isCombinationValid){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
