public class SuperCipherTest {
    public static void main(String[] args) {
        // Note, this test focuses on SuperCipher, but does use code from other ciphers, don't expect it to work if
        // the individual cipher tests fail.

        // setup
        CaesarCipher cg = new CaesarCipher(1);
        EvenOddCipher eoc = new EvenOddCipher();
        WordReplacementCipher wr = new WordReplacementCipher("al", "be");
        BaseCipher[] ciphers = new BaseCipher[]{cg, wr, eoc};

        // tests for encrypt and decrypt
        String test = "";
        String encrypt = SuperCipher.encrypt(test, ciphers);
        String decrypt = SuperCipher.decrypt(test, ciphers);
        System.out.println(encrypt.length()); // 0 (empty string return expected)
        System.out.println(decrypt.length()); // 0 (empty string return expected)

        test = "abcdefgh";
        encrypt = SuperCipher.encrypt(test, ciphers);
        decrypt = SuperCipher.decrypt("bdfhcegi", ciphers);
        System.out.println(encrypt); // bdfhcegi
        System.out.println(decrypt); // abcdefgh

        test = "abcdefg";
        encrypt = SuperCipher.encrypt(test, ciphers);
        decrypt = SuperCipher.decrypt("bdfhceg", ciphers);
        System.out.println(encrypt); // bdfhceg
        System.out.println(decrypt); // abcdefg


    }
}
/* correct output:

0
0
bdfhcegi
abcdefgh
bdfhceg
abcdefg

 */


