import java.lang.StringBuilder;

public class BasicStringCompression {
  public static void main(String[] args) {
    System.out.println(doBasicCompression2("aabbccddd"));
  }

  private static String doBasicCompression(String s) {
    if (s.equals("")) return s;

    StringBuilder sb = new StringBuilder();
    int lcount = 1;
    char cur = s.charAt(0);
    for (int i = 1; i < s.length(); ++i) {
      if (cur == s.charAt(i)) lcount++;
      else {
        sb.append(String.format("%c%d", cur, lcount));
        cur = s.charAt(i);
        lcount = 1;
      }
    }
    sb.append(String.format("%c%d", cur, lcount));

    return sb.length() < s.length() ? sb.toString() : s;
  }

  private static String doBasicCompression2(String s) {
    int compressedLen = countCompressionLength(s);
    if (compressedLen >= s.length()) return s;

    StringBuilder sb = new StringBuilder(compressedLen);
    int repeatLen = 0;
    for (int i = 0; i < s.length(); ++i) {
      repeatLen++;

      if (i + 1 == s.length() || s.charAt(i) != s.charAt(i + 1)) {
        sb.append(String.format("%c%d", s.charAt(i), repeatLen));
        repeatLen = 0;
      }
    }
    return sb.toString();
  }

  private static int countCompressionLength(String s) {
    int len = 0;
    int repeatLen = 0;
    for (int i = 0; i < s.length(); ++i) {
      repeatLen++;

      if (i + 1 == s.length() || s.charAt(i) != s.charAt(i + 1)) {
        len += 1 + String.valueOf(repeatLen).length();
        repeatLen = 0;
      }
    }
    return len;
  }
}
