public class BalanceParenthesisUsingStack{

    public static boolean arePrenthesisBalanced(String s){

        char[] strarr = s.toCharArray();
        
        StackLinkedListImpl<Character> stack = 
            new StackLinkedListImpl<Character>();
        boolean balanced = true;
        for(int i=0;i<strarr.length;i++){
            switch (strarr[i]){
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case '(':
                    stack.push('(');
                    break;
                case '}':
                    if('{' == stack.top()){
                        stack.pop();
                    }else{
                        balanced = false;
                        break;
                    }
                    break;
                case ']':
                    if('[' == stack.top()){
                        stack.pop();
                    }else{
                        balanced = false;
                        break;
                    }
                    break;
                case ')':
                    if('(' == stack.top()){
                        stack.pop();
                    }else{
                        balanced = false;
                        break;
                    }
                    break;
            }
            if(!balanced)
                return balanced;
        }
        if(!stack.isEmpty())
            balanced = false;
        return balanced;
    }
    public static void main(String[] args){
        String str1 = "{[()]}";
        String str2 = "{([[[[[]]]])}";
        System.out.println(arePrenthesisBalanced(str1));
        System.out.println(arePrenthesisBalanced(str2));
     
    }

}