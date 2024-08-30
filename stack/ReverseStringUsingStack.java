public class ReverseStringUsingStack{

    public static void main(String[] args){
        String str = "Saurabh";
        StackLinkedListImpl<Character> stack  = 
            new StackLinkedListImpl<Character>();
        char[] arr = str.toCharArray();
        for(int i=0;i<str.length();i++){
            stack.push(arr[i]);
        }
        int i = 0;
        while(!stack.isEmpty()){
            arr[i] = stack.pop();
            i++;
        }
        
        str =  String.valueOf(arr);
        System.out.println("Reversed String : "+str);
    }
}