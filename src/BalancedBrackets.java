import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.HashMap;
import java.util.Stack;

public class BalancedBrackets {
    static HashMap<Character, Character> bMap;

    static {
        bMap = new HashMap<>();
        bMap.put('(', ')');
        bMap.put('[', ']');
        bMap.put('{', '}');
    }
    public static String isBalanced(String str) {
        if ((str.length() % 2) != 0) {
            return "NO";
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if(bMap.containsKey(ch)) {
                stack.push(ch);
            } else if(stack.isEmpty() || ch != bMap.get(stack.pop())) {
                return "NO";
            }
        }

        return stack.isEmpty()? "YES": "NO";
    }

    public static void main(String args[]){
        String s = "{{[]}}";
        System.out.println(isBalanced(s));
    }
}
