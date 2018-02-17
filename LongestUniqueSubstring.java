import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */

class LongestUniqueSubstring {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(m), m is size of largest substring
     */
    public int lengthOfLongestSubstring1(String s) {
        HashSet<Character> set = new HashSet<>();
        int largest = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
                largest = Math.max(largest, set.size());
            }
        }
        return largest;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(m), m is size of largest substring
     */
    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int largest = 0;
        for (int i = 0, j = 0; j < s.length(); ++j) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            largest = Math.max(largest, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return largest;
  }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(m), m is the size of the chosen char set
     * Assumes ASCII (128 characters)
     */
    public int lengthOfLongestSubstring3(String s) {
        int[] map = new int[128];
        int largest = 0;
        for (int i = 0, j = 0; j < s.length(); ++j) {
            i = Math.max(map[s.charAt(j)], i);
            largest = Math.max(largest, j - i + 1);
            map[s.charAt(j)] = j + 1;
        }
        
        return largest;
    }
}
