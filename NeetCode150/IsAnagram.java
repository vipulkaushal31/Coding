package NeetCode150;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i=0; i < s.length(); i++){
            int currCount = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), currCount+1);
        }

        for(int i=0; i < t.length(); i++){
            int currCount = map.getOrDefault(t.charAt(i), 0);
            if(currCount == 0){
                return false;
            }
            map.put(t.charAt(i), currCount - 1);
        }

        for(int values: map.values()){
            if(values != 0){
                return false;
            }
        }

        return true;
    }
}
