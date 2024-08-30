public class PostfixEvaluation {

    public static Integer performOperation(int operand1,int operand2,char operation){
        switch (operation){
            case '*':
                return operand1 * operand2;
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '/':
                return operand1/operand2;
            default:
                return null;
        }
    }

    public static Integer evaluatePostfix(String expr){
        if(null == expr)
            return null;
        
        char[] exprArr = expr.toCharArray();
        String expressions = "*+/-";
        StackLinkedListImpl<Integer> stack = new StackLinkedListImpl();
        Integer result;
        for(int i=0;i<exprArr.length;i++){

            if (Character.isDigit(exprArr[i])){
               stack.push(Character.getNumericValue(exprArr[i]));
            }else if(expressions.contains(String.valueOf(exprArr[i]))){
                Integer operand2 = stack.pop(); 
                Integer operand1 = stack.pop();
                Integer outcome = performOperation(operand1,operand2,exprArr[i]); 
                if(null == outcome){
                    System.out.println("Unknown operation");
                    break;
                }else{
                    stack.push(outcome);
                }               
            }
        }
        result = stack.pop();
        return result;
    }
    public static void main(String[] args){
        System.out.println(evaluatePostfix("34+"));
        System.out.println(evaluatePostfix("34+8-"));
        System.out.println(evaluatePostfix("34+7*6/"));
    }

}