public class WordReplacementCipher extends BaseCipher {
    private String from;
    private String to;

    /**
     * constructor for WordReplacementCipher class
     * @param from a word that is replaced from
     * @param to a word that is replace to
     */
    public WordReplacementCipher(String from, String to) {
        super("WordReplacementCipher");
        this.from = from;
        this.to = to;
    }

    /**
     * method that check if from and to is not null
     * @return a boolean value of from and to are not being null
     */
    @Override
    public boolean isValid() {
        return this.from != null && this.to != null;
    }

    /**
     * method that encrypt the given input string by replacing from word to to word
     * @param input an input string
     * @return an encrypted input string
     */
    @Override
    public String encrypt(String input) {
        return input.replace(this.from, this.to);
    }

    /**
     * method that decrypt the given encrypted string by replacing to word to from word
     * @param input an encrypted string
     * @return a decrypted string
     */
    @Override
    public String decrypt(String input) {
        return input.replace(this.to, this.from);
    }
    
    /**
     * method that check if two WordReplacementCipher objects are equal to each other,
     * both object are equal if and only if they have the same from words and to words
     * @param other the other object
     * @boolean a boolean value of both object are equal to each other
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other == null) {
            return false;
        } else if (other instanceof WordReplacementCipher) {
            WordReplacementCipher wrc = (WordReplacementCipher) other;
            return this.from.equals(wrc.from) && this.to.equals(wrc.to);
        } else {
            return false;
        }
    }
}
