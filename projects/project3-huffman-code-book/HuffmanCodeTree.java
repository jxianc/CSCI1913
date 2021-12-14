// Jingxian Chai

/**
 * this class is binary tree using the HuffaamnNode class,
 * represents a collection of Huffman codes for various letter
 */
public class HuffmanCodeTree {
    private HuffmanNode root;

    /**
     * constructor that creates a HuffmanCodeTree using a given node as a root
     * @param root given node
     */
    public HuffmanCodeTree(HuffmanNode root) {
        this.root = root;
    }

    /**
     * constructor that creates a HuffmanCodeTree using a given HuffmanCodeBook
     * @param codebook given HuffmanCodeBook
     */
    public HuffmanCodeTree(HuffmanCodeBook codebook) {
        this.root = new HuffmanNode(null, null);
        for (Pair p: codebook) {
            put(p.getValue(), p.getKey());
        }
    }

    /**
     * method that validate if the tree is valid
     * @return true if the tree is valid, else false
     */
    public boolean isValid() {
        return root.isValid();
    }

    /**
     * method that put given letter into HuffmanCodeTree according the given binary sequence
     * @param seq given binary sequence
     * @param letter given letter
     */
    public void put(BinarySequence seq, char letter) {
        HuffmanNode node = root;
        for (Boolean binary: seq) {
            if (binary) {
                if (node.getOne() != null) {
                    node = node.getOne();
                } else {
                    node.setOne(new HuffmanNode(null, null));
                    node = node.getOne();
                }
            } else {
                if (node.getZero() != null) {
                    node = node.getZero();
                } else {
                    node.setZero(new HuffmanNode(null, null));
                    node = node.getZero();
                }
            }
        }
        node.setData(letter);
    }

    /**
     * method that deocde a given binary sequence into a string
     * @param s given binary sequence
     * @return decoded string
     */
    public String decode(BinarySequence s) {
        HuffmanNode node = root;
        StringBuilder sb = new StringBuilder();
        for (Boolean binary: s) {
            if(node.isLeaf()) {
                sb.append(node.getData());
                node = root;
            }
            if (binary) {
                node = node.getOne();
            } else {
                node = node.getZero();
            }
        }
        if (node.isLeaf()) {
            sb.append(node.getData());
        }
        return sb.toString();
    }
}
