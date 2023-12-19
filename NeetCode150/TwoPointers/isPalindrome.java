package NeetCode150.TwoPointers;

public class isPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        //clean s
        StringBuilder cleanS = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            //remove all non alphanumeric characters
            int ascii = (int)s.charAt(i);
            if((ascii >= 97 && ascii <= 122) || (ascii >= 48 && ascii <= 57)){
                cleanS.append(s.charAt(i));
            }
        }

        int p1 = 0;
        int p2 = cleanS.length() - 1;

        while(p1 < p2){
            // two pointers comparing front and back
            if(cleanS.charAt(p1) != cleanS.charAt(p2)){
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}
