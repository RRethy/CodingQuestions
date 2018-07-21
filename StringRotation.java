public class StringRotation {
  public static void main(String[] args) {
    System.out.println(String.valueOf(isRotation("abc", "bcd")));
  }

  private static boolean isRotation(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
    else return (s1 + s1).contains(s2);
  }
}
