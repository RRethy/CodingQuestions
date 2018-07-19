class URLify  {
  public static void main(String[] args) {
    char[] str = new char[]{'a', 'b', 'c', 'd', 'e', 'f', ' ', 'e', ' ', 'g', ' ', ' ', ' ', ' ', 'a'};
    System.out.println(String.format("%s\n", new String(urlify(str, 10))));
  }

  private static char[] urlify(char[] str, int trueLength) {
    int spaceCount = 0;
    for (int i = 0; i < trueLength; ++i) {
      if (str[i] == ' ') spaceCount++;
    }

    int fast = trueLength + (spaceCount * 2) - 1;
    for (int slow = trueLength - 1; slow >= 0; --slow) {
      if (slow == fast) break;

      if (str[slow] == ' ') {
        str[fast--] = '0';
        str[fast--] = '2';
        str[fast--] = '%';
      } else {
        str[fast--] = str[slow];
      }
    }
    return str;
  }
}
