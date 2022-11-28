package concepts.utils;

public class OutputUtils {
    public static void printArray(int arr[]){
        for(int i=0;i< arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void printKeys(String... StringKeys) {
        System.out.println();
        System.out.println("-------------------LOG-------------------");
        System.out.println();
        for(int i=0;i< StringKeys.length; i++) {
            System.out.print(StringKeys[i] + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("-------------------LOG-------------------");
    }
}
