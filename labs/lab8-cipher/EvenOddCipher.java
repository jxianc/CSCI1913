public class EvenOddCipher extends BaseCipher {
    public EvenOddCipher() {
        super("EvenOddCipher");
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String encrypt(String input) {
        String encrypted = "";
        for (int i=0; i<input.length(); i+=2) {
            encrypted += input.charAt(i);
        }
        for (int i=1; i<input.length(); i+=2) {
            encrypted += input.charAt(i);
        }
        return encrypted;
    }

    @Override
    public String decrypt(String input) {
        String decrypted = "";
        int length = input.length();
        int roundUpMid = (int) Math.ceil((double )length / 2);
        int i;
        for (i=0; i<roundUpMid && i+roundUpMid<input.length(); i++) {
            decrypted += input.charAt(i);
            decrypted += input.charAt(i + roundUpMid);
        }
        if (length % 2 != 0) {
            decrypted += input.charAt(i);
        }
        return decrypted;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
