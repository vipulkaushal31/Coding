package concepts.algorithms;

/*  WikiPedia
 *  Longest_Palindrome(string S) { 
        string S' = S with a bogus character (eg. '|') inserted between each character (including outer boundaries)
        array PalindromeRadii = [0,...,0] // The radius of the longest palindrome centered on each place in S'
        // note: length(S') = length(PalindromeRadii) = 2 × length(S) + 1
        
        Center = 0
        Radius = 0
        
        while Center < length(S') {
            // At the start of the loop, Radius is already set to a lower-bound for the longest radius.
            // In the first iteration, Radius is 0, but it can be higher.
            
            // Determine the longest palindrome starting at Center-Radius and going to Center+Radius
            while Center-(Radius+1) >= 0 and Center+(Radius+1) < length(S') and S'[Center-(Radius+1)] = S'[Center+(Radius+1)] {
                Radius = Radius+1
            }             
         
            // Save the radius of the longest palindrome in the array
            PalindromeRadii[Center] = Radius
            
            // Below, Center is incremented.
            // If any precomputed values can be reused, they are.
            // Also, Radius may be set to a value greater than 0
            
            OldCenter = Center
            OldRadius = Radius
            Center = Center+1
            // Radius' default value will be 0, if we reach the end of the following loop. 
            Radius = 0 
            while Center <= OldCenter + OldRadius {
                // Because Center lies inside the old palindrome and every character inside
                // a palindrome has a "mirrored" character reflected across its center, we
                // can use the data that was precomputed for the Center's mirrored point. 
                MirroredCenter = OldCenter - (Center - OldCenter)
                MaxMirroredRadius = OldCenter + OldRadius - Center
                if PalindromeRadii[MirroredCenter] < MaxMirroredRadius {
                    PalindromeRadii[Center] = PalindromeRadii[MirroredCenter]
                    Center = Center+1
                }   
                else if PalindromeRadii[MirroredCenter] > MaxMirroredRadius {
                    PalindromeRadii[Center] = MaxMirroredRadius
                    Center = Center+1
                }   
                else { // PalindromeRadii[MirroredCenter] = MaxMirroredRadius
                    Radius = MaxMirroredRadius
                    break  // exit while loop early
                }   
            }      
        }
        // A palindrome's size is equal to its radius * 2. However, since our variable 
        // Radius considers our bogus characters to the side of the center, the size of
        // its corresponding palindrome is actually 2 * (Radius / 2), which means a
        // palindrome's size is equal to its corresponding Radius value in PalindromeRadii
        longest_palindrome_in_S = max(PalindromeRadii)
        return longest_palindrome_in_S
    }

    Manacher's algorithm is faster because it reuses precomputed data when a palindrome exists inside another palindrome. 
    There are 3 cases of this. They are represented by the "if / else if / else" statement in the pseudocode.
    1.  The first case is when the palindrome at MirroredCenter lies completely inside the "Old" palindrome. 
        In this situation, the palindrome at Center will have the same length as the one at MirroredCenter. 
        For example, if the "Old" palindrome is "abcbpbcba", 
        we can see that the palindrome centered on "c" after the "p" 
        must have the same length as the palindrome centered on the "c" before the "p".
    2.  The second case is when the palindrome at MirroredCenter extends outside the "Old" palindrome. 
        That is, it extends "to the left" (or, contains characters with a lower index than any inside the "Old" palindrome). 
        Because the "Old" palindrome is the largest possible palindrome centered on OldCenter, 
        we know the characters before and after it are different. 
        Thus, the palindrome at Center will run exactly up to the border of the "Old" palindrome, 
        because the next character will be different than the one inside the palindrome at MirroredCenter. 
        For example, if the string was "ababc", the "Old" palindrome could be "bab" 
        with the Center being the second "b" and the MirroredCenter being the first "b". 
        Since the palindrome at the MirroredCenter is "aba" 
        and extends beyond the boundaries of the "Old" palindrome, 
        we know the longest palindrome at the second "b" 
        can only extend up to the border of the "Old" palindrome. 
        We know this because if the character after the "Old" palindrome had been an "a" instead of a "c", 
        the "Old" palindrome would have been longer.
    3.  The third and last case is when the palindrome at MirroredCenter 
        extends exactly up to the border of the "Old" palindrome. 
        In this case, we don't know if the character after the "Old" palindrome 
        might make the palindrome at Center longer than the one at MirroredCenter. 
        But we do know that the palindrome at Center is at least as long as the one at MirroredCenter. 
        In this case, Radius is initialized to the radius of the palindrome at MirroredCenter
        and the search starts from there. 
        An example string would be "abcbpbcbp" where the "Old" palindrome is "bcbpbcb" 
        and the Center is on the second "c". 
        The MirroredCenter is the first "c" and it has a longest palindrome of "bcb". 
        The longest palindrome at the Center on the second "c" has to be at least that long and, 
        in this case, is longer.
*/
public class Manachers {
    public String processStringForExpansion(String s) {
        StringBuilder sb = new StringBuilder(s.length() * 2 + 1);
        sb.append('#');

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append('#');
        }

        return sb.toString();
    }

    public String removeHashtagsFromString(String s) {
        StringBuilder sb = new StringBuilder(s.length() * 2 + 1);

        for (int i = 1; i < s.length(); i += 2) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public String longestPalindromeViaExpansion(String s) {
        if (s.length() == 1) {
            return s;
        }

        String s1 = processStringForExpansion(s);
        int maxLen = 0;
        String result = s;
        for (int i = 2; i < s1.length() - 1; i++) {
            // System.out.println("expanding around: " + s1.charAt(i));
            int len = 1, pivot = 1;
            while (i - pivot >= 0 && i + pivot < s1.length() && s1.charAt(i - pivot) == s1.charAt(i + pivot)) {
                pivot++;
                len += 2;
                // System.out.println("i: " + i + ", len: " + len + ", string: " +
                // s1.substring(i - len/2, i + 1 + len/2));
            }

            if (maxLen < len) {
                maxLen = len;
                int start = i - len / 2;
                int end = i + (len - 1) / 2;
                // System.out.println("start: " + start + ", end: " + end + ", string: " +
                // s1.substring(start, end));
                result = s1.substring(start, end);
            }
        }

        return removeHashtagsFromString(result);
    }

    public String longestPalindromeViaManachers(String s) {
        // ToDo: Implement Manachers
        return s;
    }

    public static void main(String args[]) {
        Manachers m = new Manachers();
        String[] strArr = new String[] { "babad", "cbbd", "babab", "a" };

        for (int i = 0; i < strArr.length; i++) {
            System.out.println("Longest Palindromic Substring in: " + strArr[i] + " is: "
                    + m.longestPalindromeViaExpansion(strArr[i]));
        }
    }
}
