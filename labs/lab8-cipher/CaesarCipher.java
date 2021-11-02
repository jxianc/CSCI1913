// This class is provided AS-IS, and is correct for the rquirements of the Lab
public class CaesarCipher extends BaseCipher {
    public int key;

    public CaesarCipher(int key) {
        super("Caesar");
        this.key = key;
    }

    public boolean isValid() {
        return key > 0 && key < 26;
    }

    private char rotateLetter(char start, int rotate) {
        if (Character.isAlphabetic(start)) {
            start = Character.toLowerCase(start);
            int number = start - 'a';
            number = number + rotate;
            while (number < 0) {
                number = number + 26;
            }
            number = number % 26;
            start = (char) (number + 'a');
        }
        return start;
    }

    @Override
    public String encrypt(String input) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            output += rotateLetter(c, key);
        }
        return output;
    }

    @Override
    public String decrypt(String input) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            output += rotateLetter(c, -key);
        }
        return output;
    }
//
//    @Override
//    public String toString() {
//        return "Caesar(" + key + ")";
//    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (other == null) {
            return false;
        } else if (other instanceof CaesarCipher) {
            CaesarCipher cipher = (CaesarCipher) other;
            return cipher.key == this.key;
        } else {
            return false;
        }
    }
}
