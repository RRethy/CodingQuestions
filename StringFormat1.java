/**
 * We are given a string S consisting of N characters and an integer K. The string represents a software license key
 * which we would like to format. The string is composed of alphanumerical characters and/or dashes. The dashes split
 * the alphanumerical characters within the string into groups (i.e. if there are M dashes, the string is split into M+1
 * groups). The dashes in the given string are possibly misplaced.

 * We want each group of characters to be of length K (except for possibly the first group, which could be shorter, but
 * still must contain at least one character). To satisfy this requirement, we will reinsert the dashes. Additionally,
 * all the lower case letters in the string must be converted to upper case.

 * For example, in the license key "2-4A0r7-4k" there are two dashes which split it into three groups of lengths 1, 5
 * and 2, respectively. If we want each group to be of length 4, then we would have to reinsert the dashes. Thus, for
 * K = 4, the correctly formatted string is "24A0-R74K".

 * Write a function:

 * class Practice1 { public String solution(String S, int K); }

 * that, given a non-empty string S consisting of N characters, representing a license key to format, and an integer K,
 * returns the license key formatted according to the description above.

 * For example, given S = "2-4A0r7-4k" and K = 4, the function should return "24A0-R74K", and for K = 3, the function
 * should return "24-A0R-74K" as the first group could be shorter. Given S = "r" and K = 1, the function should return
 * "R".

 * Assume that:

 * N and K are integers within the range [1..300,000];
 * string S consists only of alphanumerical characters (a−z and/or A−Z and/or 0−9) and/or dashes (-);
 * string S contains at least one alphanumerical character.
 * Complexity:

 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 *
 * Note: This is my solution and there may be a more efficient solution
 */

public class StringFormat1 {
  public String format(String S, int K) {
    // Use StringBuilder for to conserve memory and avoid creating new strings constantly
    StringBuilder sb = new StringBuilder();
    // A counting variable for all seen alphanumeric characters in S
    // Used with (mod K) to properly add '-'
    long alphanumCount = 0;

    // Moving in reverse through S is easier since you can then make use of (mod K)
    for (int i = S.length() - 1; i >= 0; --i) {
      // Simplest to simply ignore all the '-' and only care about alphanum chars then
      // insert '-' as needed
      if (S.charAt(i) != '-') {
        // To avoid having problems with S being '--a', only insert a '-' if we know
        // there is another alphanumeric char
        if (alphanumCount > 0 && alphanumCount % K == 0) {
          sb.insert(0, '-');
        }
        sb.insert(0, Character.toUpperCase(S.charAt(i)));
        ++alphanumCount;
      }
    }

    return sb.toString();
  }
}
