public class OneEdit {
  public static void main(String[] args) {
    String a = "abcccd";
    String b = "abcd";
    System.out.println(String.valueOf(isOneEditAway(a, b)));
  }

  private static boolean isOneEditAway(String a, String b) {
    if (a.length() == b.length()) {
      return oneReplaceAway(a, b);
    } else if (a.length() + 1 == b.length()) {
      return oneInsertAway(a, b);
    } else if (b.length() + 1 == a.length()) {
      return oneInsertAway(b, a);
    }
    return false;
  }

  private static boolean oneReplaceAway(String a, String b) {
    int changesRemaining = 1;
    for (int i = 0; i < a.length(); ++i) {
      if (a.charAt(i) == b.charAt(i)) continue;
      else if (changesRemaining == 0) return false;
      else changesRemaining--;
    }
    return true;
  }

  private static boolean oneInsertAway(String smaller, String larger) {
    int insertionsRemaining = 1;
    int smalli = 0;
    for (int largeri = 0; largeri < larger.length(); ++largeri) {
      if (smaller.charAt(smalli) == larger.charAt(largeri)) smalli++;
      else if (insertionsRemaining == 0) return false;
      else insertionsRemaining--;
    }
    return true;
  }
}
