import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {

    public boolean checkParenthesis(String s) {
        boolean isClosed = true;

        Map<Character, Character> parenthesisMap = new HashMap<>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};

        Stack<Character> parenthesisStack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            if(parenthesisMap.containsKey(s.charAt(i))) {
                parenthesisStack.push(s.charAt(i));
                isClosed = false;
            }
            else {
                if(parenthesisStack.size() > 0 && parenthesisMap.get(parenthesisStack.peek()).equals(s.charAt(i))) {
                    parenthesisStack.pop();
                    isClosed = true;
                }
                else {
                    return false;
                }
            }
        }

        return parenthesisStack.size() == 0 ? isClosed : false;

    }

    public static void main(String[] args) {
        ValidParanthesis validParanthesis = new ValidParanthesis();
//        String input = "()";
//        String input = "()[]";
//        String input = "(]";
//        String input = "{[]}";
        String input = "{[(]]}";
        boolean output = validParanthesis.checkParenthesis(input);
        System.out.println(output);
    }
}
