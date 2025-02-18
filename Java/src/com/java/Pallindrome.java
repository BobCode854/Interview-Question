public class Pallindrome 
{
	  public static boolean isPalindrome(String str) {
	        if (str == null || str.isEmpty()) {
	            return false;
	        }

	        return IntStream.range(0, str.length() / 2)
	                        .allMatch(i -> str.charAt(i) == str.charAt(str.length() - 1 - i));
	    }
	public static void main(String[] args) {
		 String str = "madam";  // Example string to check
	        boolean isPalindrome = isPalindrome(str);
	        
	        if (isPalindrome) {
	            System.out.println(str + " is a palindrome.");
	        } else {
	            System.out.println(str + " is not a palindrome.");
	        }
	    }
}
