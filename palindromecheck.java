public class palindromecheck {

    String [] punct = {
            ".", ",", ";", "?", "/", "!", ":", "'", "...", "(", ")", "-"};
    // need to figure out how to add quotation marks to punct
    public static boolean isPalindrome(String s, int i, int j) {
        if (i >= j) {
            return true;
        }
        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }

        return isPalindrome(s, i+1, j-1);
    }
    public static boolean isPalindrome(String s) {
        return isPalindrome(s, 0, s.length()-1);
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java PalindromeCheck <word>");
        }
        else {
            String word = args[0];
            word = word.toLowerCase();
            word = word.replaceAll("[\\W]", "");
            boolean isPalindrome = isPalindrome(word);
            System.out.println(isPalindrome);

        }
    }
}