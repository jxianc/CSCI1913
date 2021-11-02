public class WordReplacementCipher extends BaseCipher {
    private String from;
    private String to;

    public WordReplacementCipher(String from, String to) {
        super("WordReplacementCipher");
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean isValid() {
        return this.from != null && this.to != null;
    }

    @Override
    public String encrypt(String input) {
        String encrypted = input.replaceAll(this.from, this.to);
        return encrypted;
    }

    @Override
    public String decrypt(String input) {
        String decrypted = input.replaceAll(this.to, this.from);
        return decrypted;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof WordReplacementCipher) {
            WordReplacementCipher wrc = (WordReplacementCipher) obj;
            int equalCounts = 0;
            if (this.from.equals(wrc.from)) {
                equalCounts += 1;
            }
            if (this.to.equals(wrc.to)) {
                equalCounts += 1;
            }
            return equalCounts == 2;
        } else {
            return false;
        }
    }
}
