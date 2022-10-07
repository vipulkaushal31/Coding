package concepts.algorithms;

import concepts.utils.OutputUtils;

public class RabinKarp {
    static int needleNotFoundOrInapplicable = -1;

    /*
     * Returns index of first occurrence of needle in hayStack
     */
    public static int strStr(String hayStack, String needle) {
        int hayStackLen = hayStack.length(), needleLen = needle.length();

        if (needleLen > hayStackLen) {
            return RabinKarp.needleNotFoundOrInapplicable;
        } else if (hayStackLen == 0 && needleLen == 0) {
            return 0;
        } else if (needleLen == 0) {
            return 0;
        } else if (hayStackLen == 0) {
            return RabinKarp.needleNotFoundOrInapplicable;
        } else {
            // Rabin karp in action
            int d = 256, primeNumber = 17, hashConstant = 1; // 256 characters

            for (int i = 0; i < hayStackLen - 1; i++)
                hashConstant = (hashConstant * d) % primeNumber;

            int hashNeedle = 0, hashHayStack = 0;
            for (int i = 0; i < needleLen; i++) {
                /*
                 * Calculating hash for needle and initial hayStack
                 * hash = (hash * d + str[i]) % primeNumber
                 * where d is total number of characters and primeNumber is chosen primeNumber
                 */
                hashNeedle = (hashNeedle * d + (int) needle.charAt(i)) % primeNumber;
                hashHayStack = (hashHayStack * d + (int) hayStack.charAt(i)) % primeNumber;
            }

            for (int i = 0; i < hayStackLen - needleLen + 1; i++) {
                if (hashNeedle == hashHayStack && needle.equals(hayStack.substring(i, i + needleLen))) {
                    return i;
                } else {
                    if (i < hayStackLen - needleLen) {
                        int firstCharHash = hashConstant * (int) hayStack.charAt(i);
                        // Subtract first char hash which is to be left behind
                        hashHayStack = hashHayStack - firstCharHash;
                        // Slide window and add next char hash
                        hashHayStack = (d * hashHayStack + (int) hayStack.charAt(i + needleLen)) % primeNumber;
                        if (hashHayStack < 0) {
                            hashHayStack += primeNumber;
                        }
                    }
                }
            }

        }

        return RabinKarp.needleNotFoundOrInapplicable;
    }

    public static void main(String args[]) {
        String needle = "beast", hayStack = "iamthebestbeast";
        int result = strStr(hayStack, needle);
        if(result == -1){
            OutputUtils.printKeys(needle, "not found in", hayStack);
        } else {
            OutputUtils.printKeys(needle, "found in", hayStack, "at: ", String.valueOf(result));
        }
    }
}
