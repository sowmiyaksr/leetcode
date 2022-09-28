import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesisOptimized {

    public boolean checkParenthesis(String s) {
        if(s.length() % 2 !=0)
            return false;

        Map<Character, Character> parenthesisMap = new HashMap<>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};

        char[] array = s.toCharArray();

        Stack<Character> parenthesisStack = new Stack<>();

        for(int i=0; i<array.length; i++) {
            if(parenthesisMap.containsKey(array[i])) {
                parenthesisStack.push(array[i]);
            }
            else if(parenthesisStack.isEmpty()) {
                return false;
            }
            else {
                if(parenthesisMap.get(parenthesisStack.peek()).equals(array[i])) {
                    parenthesisStack.pop();
                }
                else {
                    return false;
                }
            }
        }

        return parenthesisStack.isEmpty();

    }

    public static void main(String[] args) {
        ValidParanthesisOptimized validParanthesis = new ValidParanthesisOptimized();
//        String input = "()";
//        String input = "()[]";
//        String input = "(]";
//        String input = "{[]}";
//        String input = "{[(]]}";
        //String input = "{[()]}";
//        String input = "}[";
        String input = "([}}])";
        boolean output = validParanthesis.checkParenthesis(input);
        System.out.println(output);
    }
}
