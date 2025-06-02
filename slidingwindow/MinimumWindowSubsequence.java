public class MinimumWindowSubsequence {

    public static String findMinWindow(String s,String t){
        String result = "";
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int sIndex = 0;
        int tIndex = 0;
        int subLen = t.length();
        int strLen = s.length();
        for(int i=0;i<strLen;i++){

            if(sArr[i]==tArr[0]){
                sIndex = i+1;
                tIndex = 1;
                int ws = sIndex;
                while(sIndex<s.length()&&tIndex<subLen){
                    if(sArr[sIndex]==tArr[tIndex]){
                        tIndex++;
                    }
                    sIndex++;
                }
                if(tIndex>=subLen){
                    tIndex = tIndex -1;
                    int we = sIndex -1;
                    sIndex = we;
                    while(sIndex>=i&&tIndex>=0){
                        if(sArr[sIndex] == tArr[tIndex]){
                            tIndex--;
                        }
                        sIndex--;
                    }
                    ws = sIndex + 1;
                    if(!result.isEmpty()){
                        if(result.length()>(we-ws+1)){
                            result = s.substring(ws,we+1);
                        }
                    }else{
                        result = s.substring(ws,we+1);
                    } 
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "abcdebdde";
        String t = "bde";
        System.out.println("Minimum window: " + findMinWindow(s, t));
    }
}
