public class SuperCipher {
    public static String encrypt(String input, BaseCipher[] cipherChain) {
        String encrypted = input;
        for (int i=0; i<cipherChain.length; i++) {
            encrypted = cipherChain[i].encrypt(encrypted);
        }
        return encrypted;
    }

    public static String decrypt(String input, BaseCipher[] cipherChain) {
        String decrypted = input;
        for (int i=cipherChain.length-1; i>=0; i--) {
            decrypted = cipherChain[i].decrypt(decrypted);
        }
        return decrypted;
    }
}
