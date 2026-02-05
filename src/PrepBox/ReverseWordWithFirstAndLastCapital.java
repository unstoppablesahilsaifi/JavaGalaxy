package PrepBox;

public class ReverseWordWithFirstAndLastCapital {
    public static void main(String[] args) {
                String str = "java is good";
                StringBuilder result = new StringBuilder();

                String[] words = str.split(" ");

                for (String word : words) {

                    // Step 1: reverse word
                    StringBuilder reversed = new StringBuilder(word).reverse();

                    // Step 2: make all lowercase first
                    for (int i = 0; i < reversed.length(); i++) {
                        reversed.setCharAt(i,
                                Character.toLowerCase(reversed.charAt(i)));
                    }

                    // Step 3: capitalize first char
                    reversed.setCharAt(0,
                            Character.toUpperCase(reversed.charAt(0)));

                    // Step 4: capitalize last char
                    int lastIndex = reversed.length() - 1;
                    reversed.setCharAt(lastIndex,
                            Character.toUpperCase(reversed.charAt(lastIndex)));

                    result.append(reversed).append(" ");
                }

                System.out.println(result.toString().trim());
            }
        }

