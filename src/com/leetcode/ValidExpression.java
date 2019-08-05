import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidExpression {

	public static void main(String[] args) {
		

		String input = "[1 + 2  + ( 3 + 2)]]";
		
		Map<Character, Character> map = new HashMap<>();
		Stack<Character> st = new Stack<>();
		
		st.push('$');
		
		map.put('{','}');
		map.put('[',']');
		map.put('(',')');
		
		boolean flag = true;
		for(int i=0;i<input.length();i++){
			
			if(map.containsKey(input.charAt(i))){
				st.push(input.charAt(i));
			}
			if(input.charAt(i) == '}' || input.charAt(i) == ']' || input.charAt(i) == ')'){
				
				if(map.get(st.pop()) == input.charAt(i)){
					continue;
				}
				else{
					flag = false;
					break;
				}
			}
			
		}
		
		if(!st.isEmpty()){
			flag = false;
		}
		
		System.out.println(flag);
		
		

	}

}
