public class EvenOddCipher extends BaseCipher {
    /**
     * constructor for EvenOddCipher class
     */
    public EvenOddCipher() {
        super("EvenOddCipher");
    }

    /**
     * method that check if EvenOddCipher is valid (all of them are valid)
     * @return true
     */
    @Override
    public boolean isValid() {
        return true;
    }

    /**
     * method that encrypt the given input string by shifting even index of the string to the front
     * and odd index of the string to back
     * @param input an given input
     * @return an encrypted input string
     */
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

    /**
     * method that decrypt the given encryted string
     * @param input an given encrypted input
     * @return an decrypted input string 
     */
    @Override
    public String decrypt(String input) {
        String decrypted = "";
        int length = input.length();
        int roundUpMid = (int) Math.ceil((double)length / 2);
        int i;
        for (i=0; i<roundUpMid && i+roundUpMid<length; i++) {
            decrypted += input.charAt(i);
            decrypted += input.charAt(i + roundUpMid);
        }
        if (length % 2 != 0) {
            decrypted += input.charAt(i);
        }
        return decrypted;
    }

    /**
     * method that checks if two EvenOddCipher class object are the same
     * in this case, all object in EvenOddCipher class are the same
     * @param other the other object
     * @return a boolean value of both object are equal to each other
     */
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
