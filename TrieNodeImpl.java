public class TrieNodeImpl {
  public static void main(String[] args) {
    TrieNode tn = new TrieNode();

    // addWord("Hello", tn);
    // addWord("Adam", tn);
    // addWord("adam", tn);
    // addWord("banana", tn);
    // addWord("dinosaur", tn);
    // addWord("play", tn);
    // addWord("hockey", tn);
    // addWord("magic", tn);

    // printWords("", tn);

    // removeWord("Hello", tn);
    // removeWord("Adam", tn);
    // removeWord("adam", tn);
    // removeWord("banana", tn);
    // removeWord("dinosaur", tn);
    // removeWord("play", tn);
    // removeWord("hockey", tn);
    // removeWord("magic", tn);

    // printWords("", tn);

    // addWord("Hello", tn);
    // addWord("Adam", tn);
    // addWord("adam", tn);
    // addWord("adambanana", tn);
    // addWord("adamdinosaur", tn);
    // addWord("adamplay", tn);
    // addWord("adamhockey", tn);
    // addWord("adammagic", tn);

    // printCompletion("", tn);

    addWord("Aadam", tn);
    addWord("Abadam", tn);
    addWord("Adhjl", tn);
    addWord("Adoijoi", tn);
    addWord("Adaksjns", tn);
    addWord("Adaoijoi", tn);
    addWord("Adamjbhb", tn);
    addWord("Adam", tn);
    addWord("Adameiwuei", tn);
    addWord("aadam", tn);
    addWord("abadam", tn);
    addWord("adhjl", tn);
    addWord("adoijoi", tn);
    addWord("adaksjns", tn);
    addWord("adaoijoi", tn);
    addWord("adamjbhb", tn);
    addWord("adam", tn);
    addWord("adameiwuei", tn);

    printFuzzyCompletion("Adam", tn);
  }

  private static void addWord(String word, TrieNode tn) {
    if (word.equals("")) {
      tn.isWord = true;
      return;
    }

    if (tn.letters[word.charAt(0)] == null) {
      tn.letters[word.charAt(0)] = new TrieNode();
    }

    addWord(word.substring(1), tn.letters[word.charAt(0)]);
  }

  private static void printWords(String base, TrieNode tn) {
    if (tn == null) return;
    if (tn.isWord) {
      System.out.println(base);
    }

    for (int i = 0; i < 256; i++) {
      if (tn.letters[i] != null) {
        printWords(String.format("%s%c", base, i), tn.letters[i]);
      }
    }
  }

  private static boolean removeWord(String word, TrieNode tn) {
    if (tn == null) return false;
    if (word.equals("")) {
      if (tn.isWord) {
        tn.isWord = false;
        return true;
      } else {
        return false;
      }
    }

    return removeWord(word.substring(1), tn.letters[word.charAt(0)]);
  }

  private static void printCompletion(String word, TrieNode tn) {
    if (tn == null) return;
    TrieNode cur = tn;
    int ci = 0;
    while (true) {
      if (ci == word.length()) break;
      if (cur == null) return;
      cur = cur.letters[word.charAt(ci)];
      ci++;
    }
    printWords(word, cur);
  }

  private static void printFuzzyCompletion(String word, TrieNode tn) {
    if (tn == null) return;

    int ci = 0;
    TrieNode cur = tn.letters[word.charAt(ci)];
    while (true) {
      if (ci == word.length()) break;
      if (cur == null) break;
      for (int i = 0; i < 256; i++) {
        if (i != (int) word.charAt(ci)) {
          printWords(word.substring(0, ci + 1) + (char) i, cur.letters[i]);
        }
      }
      cur = cur.letters[word.charAt(ci)];
      ci++;
    }
  }

  public static class TrieNode {
    boolean isWord;
    TrieNode[] letters = new TrieNode[256];
  }
}
