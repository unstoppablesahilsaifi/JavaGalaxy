package PracticeSet3;

public class DecompressTheString {
    public static void main(String[] args) {
        String compressed = "a12b3c10"; // input compressed string
        StringBuilder decompressed = new StringBuilder();

        // i pointer character aur number dono handle karega
        for (int i = 0; i < compressed.length();) {
            char ch = compressed.charAt(i++); // pehle character lo (e.g. 'a')

            StringBuilder num = new StringBuilder();
            // jab tak agla character digit ho, pura number bnao
            while (i < compressed.length() && Character.isDigit(compressed.charAt(i))) {
                num.append(compressed.charAt(i++));
            }

            // pura number integer me convert karo
            int count = Integer.parseInt(num.toString());

            // ab 'ch' ko 'count' baar repeat karke append karo
            for (int j = 0; j < count; j++) {
                decompressed.append(ch);
            }
        }

        System.out.println(decompressed.toString());
    }
}
