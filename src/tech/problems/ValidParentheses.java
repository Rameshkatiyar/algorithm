package tech.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String args[]){
        String str = "()";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        // map.put('(', ')');
        map.put(')', '(');

        // map.put('{', '}');
        map.put('}', '{');

        // map.put('[', ']');
        map.put(']', '[');

        for(int i=0; i<=s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                stack.push(c);
            }
            else{
                char pop = stack.pop();
                if(map.get(c) == pop){
                    return true;
                }
            }
        }

        return stack.isEmpty();
    }
}
