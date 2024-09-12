
public class StackUtility {
	static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	
	public static String operate(MyStack s1, MyStack s2) throws Exception {
		MyStack s3 = new StackArray();
		String decoded = "";
		
		while(s1.size()>=2) {
			int num1 = s1.top();
			s1.pop();
			int num2 = s1.top();
			s1.pop();
			int operator = s2.top();
			s2.pop();
			if(operator < 0) {
				s3.push(num1 - num2);
			}
			else if(operator >=0) {
				s3.push(num1 + num2);
			}
		}
		
		while(!s3.isEmpty()) {
			decoded += alphabets.charAt(s3.top());
			s3.pop();
		}
		return decoded;


		
		
	}
}
