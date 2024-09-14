
public class StackUtility {
	public static MyStack removeRange(MyStack s, int i, int j) throws Exception{
		MyStack tempStack = new StackArray(); 
        int currentIndex = 0; 

        while (!s.isEmpty()) {
            if (currentIndex < i || currentIndex > j) {                
                tempStack.push(s.top());
            }
            s.pop(); 
            currentIndex++; 
        }

        while (!tempStack.isEmpty()) {
            s.push(tempStack.top());
            tempStack.pop();
        }

        return s;
		
	}

}
