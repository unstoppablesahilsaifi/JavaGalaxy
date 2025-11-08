package PracticeSet5;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        Map<String, List<String>> map = new HashMap<>();

        // Step 1️⃣: Loop over each string
        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];

            // Step 2️⃣: Build frequency array
            int[] freq = new int[26];
            for (int j = 0; j < word.length(); j++) {
                freq[word.charAt(j) - 'a']++;
            }

            // Step 3️⃣: Make key using all 26 frequencies
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < 26; k++) {
                sb.append(freq[k]).append('#');
            }
            String key = sb.toString();

            // Step 4️⃣: Add word in map using computeIfAbsent manually (no for-each)
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(word);
        }

        // Step 5️⃣: Collect all grouped anagrams in final list
        List<List<String>> result = new ArrayList<>();
        List<List<String>> values = new ArrayList<>(map.values());
        for (int i = 0; i < values.size(); i++) {
            result.add(values.get(i));
        }

        // Step 6️⃣: Print final output
        System.out.println(result);
    }
}
