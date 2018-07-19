public class PalindromPermutation {
  public static void main(String[] args) {
    char[] str = new char[]{'a', 's', ' ', 't', 'q', 'd', 'a', 's', 'd'};
    System.out.println(String.valueOf(isPalindromePermutation(str)));
  }

  private static boolean isPalindromePermutation(char[] str) {
    int[] lookup = new int[128];
    int charCount = 0;
    for (int i = 0; i < str.length; ++i) {
      if (str[i] != ' ') {
        lookup[str[i]]++;
        charCount++;
      }
    }

    boolean oddAllowed = charCount % 2 == 0 ? false : true;
    for (int i = 0; i < 128; ++i) {
      if (lookup[i] % 2 != 0) {
        if (!oddAllowed) return false;
        else oddAllowed = false;
      }
    }
    return true;
  }
}
