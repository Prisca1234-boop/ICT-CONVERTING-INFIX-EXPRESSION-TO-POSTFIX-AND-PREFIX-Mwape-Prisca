Import java.util.Stack; 
 
Public class InfixConversion { 
 
    // Function to check precedence 
    Static int precedence(char ch) { 
        Switch (ch) { 
            Case ‘+’: 
            Case ‘-‘: 
                Return 1; 
 
            Case ‘*’: 
            Case ‘/’: 
                Return 2; 
 
            Case ‘^’: 
                Return 3; 
        } 
        Return -1; 
    } 
 
    // Function to check if operand 
    Static boolean isOperand(char ch) { 
        Return Character.isLetterOrDigit(ch); 
    } 
 
    // Infix to Postfix 
    Static String infixToPostfix(String exp) { 
        StringBuilder result = new StringBuilder(); 
        Stack<Character> stack = new Stack<>(); 
 
        For (int I = 0; I < exp.length(); i++) { 
            Char ch = exp.charAt(i); 
 
            If (isOperand(ch)) { 
                Result.append(ch); 
            } 
 
            Else if (ch == ‘(‘) { 
                Stack.push(ch); 
            } 
 
            Else if (ch == ‘)’) { 
                While (!stack.isEmpty() && stack.peek() != ‘(‘) { 
                    Result.append(stack.pop()); 
                } 
                Stack.pop(); 
            } 
 
            Else { 
                While (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) { 
                    Result.append(stack.pop()); 
                } 
                Stack.push(ch); 
            } 
        } 
 
        While (!stack.isEmpty()) { 
            Result.append(stack.pop()); 
        } 
 
        Return result.toString(); 
    } 
 
    // Reverse string 
    Static String reverse(String str) { 
        Return new StringBuilder(str).reverse().toString(); 
    } 
 
    // Infix to Prefix 
    Static String infixToPrefix(String exp) { 
        StringBuilder modified = new StringBuilder(); 
 
        // Reverse and swap brackets 
        For (int I = exp.length() – 1; I >= 0; i--) { 
            Char ch = exp.charAt(i); 
 
            If (ch == ‘(‘) 
                Modified.append(‘)’); 
            Else if (ch == ‘)’) 
                Modified.append(‘(‘); 
            Else 
                Modified.append(ch); 
        } 
 
        // Convert to postfix 
        String postfix = infixToPostfix(modified.toString()); 
 
        // Reverse postfix to get prefix 
        Return reverse(postfix); 
    } 
 
    Public static void main(String[] args) { 
        String infix = “A+(B*C-D)/E”; 
 
        System.out.println(“Infix Expression: “ + infix); 
 
        String postfix = infixToPostfix(infix); 
        System.out.println(“Postfix Expression: “ + postfix); 
 
        String prefix = infixToPrefix(infix); 
        System.out.println(“Prefix Expression: “ + prefix); 
    } 
}