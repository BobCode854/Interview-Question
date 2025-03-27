package Java8.string;

public class Count_Vowels_And_Consonant {

	public static void main(String[] args) {
		String string = "Karan Raj Sinha";
		String vowelMatcher = "[aeiouAEIOU]";
		long vowelCount = string.replace(" ", "").chars().filter(ch -> vowelMatcher.contains(String.valueOf((char) ch)))
				.count();
		long consonantCount = string.replace(" ", "").chars()
				.filter(ch -> !vowelMatcher.contains(String.valueOf((char) ch))).count();

		System.out.println("Total vowels in string : " + vowelCount);
		System.out.println("Total consonant in string : " + consonantCount);

	}

}
