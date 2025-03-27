package Java8.string;

public class Remove_All_The_Vowels_From_String {

	public static void main(String[] args) {
		String string = "Karan Raj Sinha";
		String vowelRemoved = "";
		String consonantRemoved = "";
		String vowelMatcher = "[aeiouAEIOU]";
		String consonantMatcher =  "[^aeiouAEIOU]";
		vowelRemoved = string.replaceAll(vowelMatcher, "");
		consonantRemoved = string.replaceAll(consonantMatcher, "");
		
		System.out.println("Only consonant  :"+vowelRemoved);
		System.out.println("Only vowels : "+consonantRemoved);
		
		
	}

}
