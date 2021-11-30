// Jingxian Chai

public class LinkedCounter<T> {
    private CountNode<T> head;
    private int size;
    private int sum;

    /**
     * constructor for LinkedCounter class, that assigns the private variables
     */
    public LinkedCounter() {
        this.head = null;
        this.size = 0;
        this.sum = 0;
    }

    /**
     * method that check if two given elements are equal
     * @param left first element
     * @param right second element
     * @return true if both are equals, else false
     */
    private boolean isEqual(T left, T right) {
        if (left == null || right == null) {
            return left == right;
        } else {
            return left.equals(right);
        }
    }
    
    /**
     * method that return the node with the given element
     * @param elem given element
     * @return the node if the element exists, else null
     */
    private CountNode<T> getNode(T elem) {
        CountNode<T> node = this.head;
        while (node != null && !isEqual(node.getData(), elem)) {
            node = node.getNext();
        }
        return node;
    }

    /**
     * method that increment the count for given element
     * @param elem given element
     * @return the count of the element
     */
    public int countUp(T elem) {
        CountNode<T> node = getNode(elem);
        if (node != null) {
            node.countUp();
        } else {
            node = new CountNode<>(elem, this.head);
            this.head = node;
            this.size += 1;
        }
        this.sum += 1;
        return node.getCount();
    }

    /**
     * method that decrement the count for given element
     * @param elem given element
     * @return the count of the element
     */
    public int countDown(T elem) {
        // linkedCounter is empty
        if (isEmpty()) return 0;

        CountNode<T> node = this.head;
        if (isEqual(node.getData(), elem)) {    
            // the head holds the given element
            node.countDown();
            this.sum -= 1;
            if (node.getCount() <= 0) {     
                // count is zero, remove the node
                this.head = node.getNext();
                this.size -= 1;
            }
            return node.getCount();
        }

        CountNode<T> prevNode = null;
        while (node != null && !isEqual(node.getData(), elem)) {
            prevNode = node;
            node = node.getNext();
        }
        if (node != null) {
            node.countDown();
            this.sum -= 1;
            if (node.getCount() <= 0) {
                // count is zero, remove the node
                prevNode.setNext(node.getNext());
                this.size -= 1;
            }
            return node.getCount();
        } else {
            // the element does not exists
            return 0;
        }
    }

    /**
     * method that return the count for a given element
     * @param elem given element
     * @return count of the given element if the element exists, else 0
     */
    public int getCount(T elem) {
        CountNode<T> node = getNode(elem);
        return node != null ? node.getCount() : 0;
    }

    /**
     * method that return the number of distinct elements with non-0 count
     * @return number of distinct elements with non-0 count
     */
    public int getSize() {
        return this.size;
    }

    /**
     * method that return the sum of counts of all elements
     * @return
     */
    public int getSum() {
        return this.sum;
    }

    /**
     * method that check if the linkedcounter is empty
     * @return true if the linkedcounter is empty, else false
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * method that return the string representation of linkedcounter
     * @return string representation of linkedcounter
     */
    public String toString() {
        CountNode<T> node = head;
        StringBuilder str = new StringBuilder();
        while (node != null) {
            if (node.getNext() != null) {
                str.append(node.toString());
                str.append(" -> ");
            } else {
                str.append(node.toString());
            }
            node = node.getNext();
        }
        return str.toString();
    }
}
