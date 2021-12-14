// Jingxian Chai

import java.util.Iterator;

/**
 * this class represents a codebook, each letter is associated with binary sequence,
 * this codebook is implemented using binary search tree data structure
 */
public class HuffmanCodeBook implements Iterable<Pair> {
    private Node root;

    /**
     * constructor for class HuffmanCodeBook
     */
    public HuffmanCodeBook() {
        root = null;
    }
    
    /**
     * method that add given character and given binary sequence into the codebook
     * @param c given character
     * @param seq given binary sequence
     */
    public void addSequence(char c, BinarySequence seq) {
        if (root == null) {
            root = new Node(new Pair(c, seq));
        } else {
            addSequence(root, c, seq);
        }
    }

    /**
     * a helper method for addSequence method that add given character and given binary sequence to the given node's successor
     * @param node given node
     * @param c given character
     * @param seq given binary sequence
     */
    private void addSequence(Node node, char c, BinarySequence seq) {
        int cmp = compare(c, node.getData().getKey());
        if (cmp > 0) {
            if (node.getRight() != null) {
                addSequence(node.getRight(), c, seq);
            } else {
                node.setRight(new Node(new Pair(c, seq)));
            }
        } else {
            if (node.getLeft() != null) {
                addSequence(node.getLeft(), c, seq);
            } else {
                node.setLeft(new Node(new Pair(c, seq)));
            }
        }
    }

    /**
     * a helper method that compare two character
     * @param first first character
     * @param second second character
     * @return 1 indicates first > second; -1 indicates second > first; 0 indicates both equals
     */
    private int compare(char first, char second) {
        if (first > second) {
            return 1;
        } else if (first < second) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * method that indicates if given letter exists in the codebook
     * @param letter given letter
     * @return true if letter exists, else false
     */
    public boolean contains(char letter) {
        return searchNode(root, letter) != null;
    }

    /**
     * a helper method for contains method that search the given letter from the given node to its successors
     * @param node given node
     * @param target given letter
     * @return true if letter exists, else false
     */
    private Node searchNode(Node node, char target) {
        if (node == null) return null;
        int cmp = compare(target, node.getData().getKey());
        if (cmp > 0) {
            return searchNode(node.getRight(), target);
        } else if (cmp < 0) {
            return searchNode(node.getLeft(), target);
        } else {
            return node;
        }
    } 

    /**
     * method that indicates if every letter in the given text exist in the codebook
     * @param letters given text
     * @return true if all letters exist, else false
     */
    public boolean containsAll(String letters) {
        char[] charArray = letters.toCharArray();
        for (char c: charArray) {
            if (!contains(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * method that return the binary sequence that is associated with the given character
     * @param c given character
     * @return binary sequence that is associated with the character, or null if character does not exists
     */
    public BinarySequence getSequence(char c) {
        Node node = searchNode(root, c);
        if (node != null) {
            return node.getData().getValue();
        } else {
            return null;
        }
    }

    /**
     * method that encode the given string into a binary sequence
     * @param s given string
     * @return encoded binary sequence
     */
    public BinarySequence encode(String s) {
        char[] charArray = s.toCharArray();
        BinarySequence bs = new BinarySequence();
        for (char c: charArray) {
            bs.append(getSequence(c));
        }
        return bs;
    }

    @Override
    public Iterator<Pair> iterator() {
        return new TreeIterator();
    }

    /**
     * an iterator class to iterate the Pair data
     */
    private class TreeIterator implements Iterator<Pair> {
        private Iterator<Pair> iter;

        public TreeIterator() {
            iter = root.iterator();
        }

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        @Override
        public Pair next() {
            return iter.next();
        }
    }
}

/**
 * this class represents the tree node in the binary search tree
 */
class Node implements Iterable<Pair> {
    private Pair data;
    private Node left;
    private Node right;

    /**
     * constructor for class Node
     * @param data given data
     */
    public Node(Pair data) {
        this.data = data;
        left = null;
        right = null;
    }

    public Pair getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public Iterator<Pair> iterator() {
        return new NodeIterator();
    }

    /**
     * an iterator class for iterating the Pair data
     */
    private class NodeIterator implements Iterator<Pair> {
        private Iterator<Pair> leftIter;    // iterator of left node
        private Iterator<Pair> rightIter;   // iterator of right node
        private boolean hasReturnedData;    // has returned current node data

        /**
         * constructor that setup the values of the variables
         */
        public NodeIterator() {
            hasReturnedData = false;
            if (left == null) {
                leftIter = null;
            } else {
                leftIter = left.iterator();
            }
            if (right == null) {
                rightIter = null;
            } else {
                rightIter = right.iterator();
            }
        }

        public boolean leftHasNext() {
            return leftIter != null && leftIter.hasNext();
        }

        public boolean rightHasNext() {
            return rightIter != null && rightIter.hasNext();
        }

        @Override
        public boolean hasNext() {
            return leftHasNext() || !hasReturnedData || rightHasNext();
        }
        /**
         * method that return the data by in order traversing
         */
        @Override
        public Pair next() {
            if (leftHasNext()) {
                return leftIter.next();
            } else if (!hasReturnedData) {
                hasReturnedData = true;
                return data;
            } else {
                return rightIter.next();
            }
        }
    }
}

/**
 * this class is a data structure that a key is associated with a value
 */
class Pair {
    private char key;
    private BinarySequence value;

    /**
     * constructor for Pair class
     * @param key given key
     * @param value given value
     */
    public Pair(char key, BinarySequence value) {
        this.key = key;
        this.value = value;
    }

    public char getKey() {
        return key;
    }

    public BinarySequence getValue() {
        return value;
    }
}