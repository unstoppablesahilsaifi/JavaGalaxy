package Java17;

/**
 * 💡 Text Blocks in Java (Introduced in Java 15)
 * Text Blocks allow you to write multi-line strings easily using triple quotes """ ... """
 * without worrying about escape characters (\n, \", \t, etc.).
 */
public class TextBlock {
    public static void main(String[] args) {

        /*
         * 💻 Example 1 — Old Way vs New Way
         *
         * ❌ Before (Traditional String)
         * String oldJson = "{\n" +
         *                  "  \"name\": \"Sahil\",\n" +
         *                  "  \"age\": 25,\n" +
         *                  "  \"city\": \"Delhi\"\n" +
         *                  "}";
         *
         * ✅ Now (Text Block)
         * String newJson = """
         * {
         *   "name": "Sahil",
         *   "age": 25,
         *   "city": "Delhi"
         * }
         * """;
         *
         * 🖥️ Output:
         * {
         *   "name": "Sahil",
         *   "age": 25,
         *   "city": "Delhi"
         * }
         */

        // ✅ Example 2 — Multi-line SQL Query
        String query = """
                SELECT id, name, salary
                FROM employees
                WHERE department = 'IT'
                ORDER BY salary DESC;
                """;

        System.out.println("Query:\n" + query);

        // ✅ Example 3 — Using Backslash for Line Continuation (no newline)
        String str = """
                This is one line \
                continued without newline \
                and ends here.
                """;

        System.out.println(str);
    }
}
