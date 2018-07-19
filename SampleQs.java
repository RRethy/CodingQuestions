import java.util.HashSet;

public class SampleQs {
  public static void main(String[] args) {
    // printPairs(new int[]{1, 2, 3, 4, 8}, new int[]{2, 3, 4, 5, 9, 10, 11});
    // printNonSortedPairs(new int[]{1, 2, 3, 4, 8}, new int[]{2, 3, 4, 5, 9, 10, 11});
  }

  /**
   * Requires a and b to have no duplicates
   */
  private static void printNonSortedPairs(int[] a, int[] b) {
    HashSet<Integer> aSet = new HashSet<>();
    for (int i = 0; i < a.length; ++i) {
      aSet.add(a[i]);
    }
    for (int i = 0; i < b.length; ++i) {
      if (aSet.contains(b[i])) {
        System.out.println(String.format("%d", b[i]));
      }
    }
  }

  /**
   * Requires a and b to be sorted and that they each have no duplicates
   */
  private static void printPairs(int[] a, int[] b) {
    int ai = 0;
    int bi = 0;
    while (ai < a.length && bi < b.length) {
      if (a[ai] == b[bi]) {
        System.out.println(String.format("%d", a[ai]));
        ai++;
        bi++;
      } else if (a[ai] > b[bi]) bi++;
      else ai++;
    }
  }

  private static HashSet<String> generateAllPermutations(String bar) {
    if (bar.length() == 1) {
      HashSet<String> base = new HashSet<>();
      base.add(bar);
      return base;
    }

    HashSet<String> set = generateAllPermutations(bar.substring(1, bar.length()));
    HashSet<String> newset = new HashSet<>();
    for (String s : set) {
      for (int i = 0; i <= s.length(); ++i) {
        String newstring = s.substring(0, i) + bar.charAt(0) + s.substring(i, s.length());
        newset.add(newstring);
      }
    }
    return newset;
  }
}
