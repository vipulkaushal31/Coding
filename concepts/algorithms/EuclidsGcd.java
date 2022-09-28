package concepts.algorithms;

/*
 * Pseudo Code of the Algorithm-
    Step 1:  Let  a, b  be the two numbers
    Step 2:  a mod b = R
    Step 3:  Let  a = b  and  b = R
    Step 4:  Repeat Steps 2 and 3 until  a mod b  is greater than 0
    Step 5:  GCD = b
    Step 6: Finish
 */
public class EuclidsGcd {
    private int calculateGcd(int a, int b){
        while(a%b > 0){
            int r = a % b;
            a = b;
            b = r;
        }

        return b;
    }
    
    public static void main(String args[]) {
        EuclidsGcd gcd = new EuclidsGcd();
        int a = 2012, b = 380;
        System.out.println("GCD of" + a + "and " + b + "is: " + gcd.calculateGcd(a,b));
    }
}
