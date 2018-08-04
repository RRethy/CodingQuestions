public class TrieNodeImpl {
  public static void main(String[] args) {
    TrieNode tn = new TrieNode();

    addWord("Hello", tn);
    addWord("Adam", tn);
    addWord("adam", tn);
    addWord("banana", tn);
    addWord("dinosaur", tn);
    addWord("play", tn);
    addWord("hockey", tn);
    addWord("magic", tn);

    // printWords("", tn);

    removeWord("Hello", tn);
    removeWord("Adam", tn);
    removeWord("adam", tn);
    removeWord("banana", tn);
    removeWord("dinosaur", tn);
    removeWord("play", tn);
    removeWord("hockey", tn);
    removeWord("magic", tn);

    // printWords("", tn);

    addWord("Hello", tn);
    addWord("Adam", tn);
    addWord("adam", tn);
    addWord("adambanana", tn);
    addWord("adamdinosaur", tn);
    addWord("adamplay", tn);
    addWord("adamhockey", tn);
    addWord("adammagic", tn);

    printCompletion("adam", tn);
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
      if (ci == word.length() - 1) break;

      if (cur.letters[word.charAt(ci)] == null) return;

      cur = cur.letters[word.charAt(ci)];
      ci++;
    }

    for (int i = 0; i < 256; i++) {
      printWords(word, cur.letters[i]);
    }
  }

  public static class TrieNode {
    boolean isWord;
    TrieNode[] letters = new TrieNode[256];
  }
}
