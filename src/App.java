import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class App {

    private static final Map<Character, String> charToMorse = new HashMap<>();
    private static final Map<String, Character> morseToChar = new HashMap<>();

    static {
        //morse values mapping
        charToMorse.put('a', ".-");
        charToMorse.put('b', "-...");
        charToMorse.put('c', "-.-.");
        charToMorse.put('d', "-..");
        charToMorse.put('e', ".");
        charToMorse.put('f', "..-.");
        charToMorse.put('g', "--.");
        charToMorse.put('h', "....");
        charToMorse.put('i', "..");
        charToMorse.put('j', ".---");
        charToMorse.put('k', "-.-");
        charToMorse.put('l', ".-..");
        charToMorse.put('m', "--");
        charToMorse.put('n', "-.");
        charToMorse.put('o', "---");
        charToMorse.put('p', ".--.");
        charToMorse.put('q', "--.-");
        charToMorse.put('r', ".-.");
        charToMorse.put('s', "...");
        charToMorse.put('t', "-");
        charToMorse.put('u', "..-");
        charToMorse.put('v', "...-");
        charToMorse.put('w', ".--");
        charToMorse.put('x', "-..-");
        charToMorse.put('y', "-.--");
        charToMorse.put('z', "--..");
        charToMorse.put('0', "-----");
        charToMorse.put('1', ".----");
        charToMorse.put('2', "..---");
        charToMorse.put('3', "...--");
        charToMorse.put('4', "....-");
        charToMorse.put('5', ".....");
        charToMorse.put('6', "-....");
        charToMorse.put('7', "--...");
        charToMorse.put('8', "---..");
        charToMorse.put('9', "----.");
        charToMorse.put(' ', "/");

        //reverse map to decode
        for (Map.Entry<Character, String> entry : charToMorse.entrySet()) {
            morseToChar.put(entry.getValue(), entry.getKey());
        }
    }

    public String encode(String text) {
        StringBuilder morseCode = new StringBuilder();
        text = text.toLowerCase();
        for (char character : text.toCharArray()) {
             if (charToMorse.containsKey(character)) {
                morseCode.append(charToMorse.get(character)).append(" ");
            }
        }
        return morseCode.toString().trim();
    }

    public String decode(String morse) {
         StringBuilder text = new StringBuilder();
        String[] morseWords = morse.split("/");
        for (String morseWord : morseWords) {
            String[] morseLetters = morseWord.trim().split(" ");
            for (String morseLetter : morseLetters) {
                if (morseToChar.containsKey(morseLetter)) {
                    text.append(morseToChar.get(morseLetter));
                } else if (morseLetter.isEmpty()){
                    text.append(" ");
                }
            }
        }
        return text.toString();
    }

    public static void main(String[] args) {
        App converter = new App();
        Scanner scanner = new Scanner (System.in);
        System.out.print("What do you wanna encode?: ");
        String text = scanner.nextLine();
        
        String morseCode = converter.encode(text);
        System.out.println("Encoded: " + morseCode);

        String decodedText = converter.decode(morseCode);
        System.out.println("You encoded " + decodedText);
        scanner.close();
    }
}