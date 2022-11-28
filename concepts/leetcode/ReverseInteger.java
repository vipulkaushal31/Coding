// 7. Reverse Integer

class ReverseInteger {
    public int reverse(int x) {
        if(x == 0){
            return 0;
        }

        boolean isNegative = x < 0;
        if(isNegative){
            x *= -1;
        }

        int digits = (int)Math.floor(Math.log10(x) + 1);
        long reversedInteger = 0;
        for(int i= digits - 1; i>= 0; i--){
            long currentDigit = (x%10)*(long)Math.pow(10, i);
            reversedInteger += currentDigit;
            x/=10;
        }
        reversedInteger = (isNegative? -1: 1) * reversedInteger;
        if(reversedInteger > Integer.MAX_VALUE || reversedInteger < Integer.MIN_VALUE){
            return 0;
        }

        return (int)reversedInteger;
    }
}