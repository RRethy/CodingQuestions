import java.lang.StringBuilder;

public class BasicStringCompression {
  public static void main(String[] args) {
    System.out.println(doBasicCompression(""));
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
}
