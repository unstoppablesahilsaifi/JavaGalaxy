package PracticeSet5;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println("🔹 Approach 1: Sorting-based");
        System.out.println(groupAnagramsBySorting(strs));

        System.out.println("\n🔹 Approach 2: Frequency-based");
        System.out.println(groupAnagramsByFrequency(strs));
    }

    // --------------------------------------------------------
    // 🧩 APPROACH 1 — SORTING BASED
    // --------------------------------------------------------
    public static List<List<String>> groupAnagramsBySorting(String[] strs) {
        if (strs == null || strs.length == 0)
            return Collections.emptyList();

        Map<String, List<String>> map = new HashMap<>();

        // Using classic for loop (not for-each)
        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];

            // Convert to char array and sort
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            // Convert back to string → key
            String key = new String(chars);

            // Insert into map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(word);
        }

        // Return grouped lists
        return new ArrayList<>(map.values());
    }

    // --------------------------------------------------------
    // 🧩 APPROACH 2 — CHARACTER FREQUENCY BASED
    // --------------------------------------------------------
    public static List<List<String>> groupAnagramsByFrequency(String[] strs) {
        if (strs == null || strs.length == 0)
            return Collections.emptyList();

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            int[] freq = new int[26];

            // Count frequency of each character
            for (int j = 0; j < word.length(); j++) {
                freq[word.charAt(j) - 'a']++;
            }

            // Build unique key like "1#0#0#1#..."
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < 26; k++) {
                sb.append(freq[k]).append('#');
            }
            String key = sb.toString();

            // Add to map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
