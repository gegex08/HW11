package palindrome;

/**
 * 
 * 
 */
public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s1 = new String("racecar");
        String s2 = new String("Amore, Roma");
        String s3 = new String("A man, a plan, a canal: Panama");
        String s4 = new String("ZEROREZ");
        String s5 = new String("not palindrome");

        testString(s1);
        testString(s2);
        testString(s3);
        testString(s4);
        testString(s5);
        
    } // end main
    
    public static String testString(String x) {
    System.out.printf("The original String: %s\n", x);
    
    // Test length method
    System.out.printf("Length of this String: %d\n", x.length());
    
    // Loop through characters in x and display reversed
    System.out.print("The string reversed is: ");
    for (int i = x.length() - 1; i >= 0; i--) {
        System.out.printf("%c ", x.charAt(i));
    }

    // Check for palindrome, ignoring spaces and periods
    boolean isPalindrome = true;
    for (int i = 0, j = x.length() - 1; i < j; i++, j--) {
        
        // Skip spaces and periods
        while (i < j && !Character.isLetterOrDigit(x.charAt(i))) {
            i++;
        }
        while (i < j && !Character.isLetterOrDigit(x.charAt(j))) {
            j--;
        }
        if (Character.toLowerCase(x.charAt(i)) != Character.toLowerCase(x.charAt(j))) {
            isPalindrome = false;
            break;
        }
    }

    // Test for equality
    if (isPalindrome) {
        System.out.println("\nThis string is a palindrome.");
    } else {
        System.out.println("\nThis string is not a palindrome.");
    }
    System.out.println("");
    return null;
}


} // end class Palindrome
