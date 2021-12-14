public class Test {
    public static void main(String[] args) {
        ProvidedHuffmanCodeBook p = new ProvidedHuffmanCodeBook();
        HuffmanCodeBook cb = p.getEbookHuffmanCodebook();
        HuffmanCodeTree tree = new HuffmanCodeTree(cb);
        System.out.println("tree is valid: " + tree.isValid());
        BinarySequence bs = new BinarySequence("000");
        System.out.println(tree.decode(bs));
    }
}
