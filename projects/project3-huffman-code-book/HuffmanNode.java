// Jingxian Chai

/**
 * this class serves as a component of the HuffmanCodeBook class 
 */
public class HuffmanNode {
    private HuffmanNode zero;
    private HuffmanNode one;
    private Character data;

    /**
     * constructor for class HuffmanNode to make non leaf node
     * @param zero
     * @param one
     */
    public HuffmanNode(HuffmanNode zero, HuffmanNode one) {
        this.zero = zero;
        this.one = one;
        this.data = null;
    }

    /**
     * constructor for class HuffmanNode to make leaf node
     * @param data
     */
    public HuffmanNode(char data) {
        this.zero = null;
        this.one = null;
        this.data = data;
    }

    /**
     * method that return the zero node
     * @return zero node
     */
    public HuffmanNode getZero() {
        return this.zero;
    }

    /**
     * method that set the zero node with a given node
     * @param zero a given node
     */
    public void setZero(HuffmanNode zero) {
        this.zero = zero;
    }

    /**
     * method that return the one node 
     * @return one node
     */
    public HuffmanNode getOne() {
        return this.one;
    }

    /**
     * method that set the one node with a given node
     * @param one a given node
     */
    public void setOne(HuffmanNode one) {
        this.one = one;
    }

    /**
     * method that return the data
     * @return data
     */
    public Character getData() {
        return this.data;
    }

    /**
     * method that set the data with a given data
     * @param data a given data
     */
    public void setData(char data) {
        this.data = data;
    }

    /**
     * method that check if node is a lead node
     * @return true if node is a leaf node, else false
     */
    public boolean isLeaf() {
        return data != null && one == null && zero == null;
    }

    /**
     * method that check if the node and its all descendant nodes are valid
     * @return true if all the nodes are valid, else false
     */
    public boolean isValid() {
        return isLeaf() ? isLeaf() : getZero() != null && getZero().isValid() && getOne() != null && getOne().isValid();
    }
}