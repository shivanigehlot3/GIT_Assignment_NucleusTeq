// Create a program to check if two strings are anagrams.
public class Anagrams {
 
    //Way 3 =>
    public static boolean isAnagrams(String str1, String str2){
        boolean isAnagram = true;
        int str1_ar[] = new int[256];
        
        for(char c:str1.toCharArray()){
            int index = (int)c;
            str1_ar[index]++;
        }
        
        for(char c: str2.toCharArray()){
            int index = (int)c;
            str1_ar[index]--;
        }
        
        for(int i=0;i<256;i++){
            if(str1_ar[i] != 0){
               isAnagram=false;
               break;
            }
        }
        return isAnagram;
    }

    public static void main(String args[]){
        
        String str1 = "care";
        String str2 = "race";

        System.out.println(isAnagrams(str1, str2));

    }
}
    
