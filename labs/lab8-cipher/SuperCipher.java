public class SuperCipher {
    /**
     * method that encrypt the given input by the given list of ciphers
     * @param input a given string input
     * @param cipherChain a given list of ciphers
     * @return an encrypted string
     */
    public static String encrypt(String input, BaseCipher[] cipherChain) {
        String encrypted = input;
        for (int i=0; i<cipherChain.length; i++) {
            encrypted = cipherChain[i].encrypt(encrypted);
        }
        return encrypted;
    }

    /**
     * method that decrypt the given encrypted string by the given list of ciphers
     * @param input a given encrypted string
     * @param cipherChain a given list of ciphers
     * @return a decrypted string
     */
    public static String decrypt(String input, BaseCipher[] cipherChain) {
        String decrypted = input;
        for (int i=cipherChain.length-1; i>=0; i--) {
            decrypted = cipherChain[i].decrypt(decrypted);
        }
        return decrypted;
    }
}
