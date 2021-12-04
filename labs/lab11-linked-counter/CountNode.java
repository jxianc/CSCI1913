// Jingxian Chai

public class CountNode<T> {
    private T data;
    private int count;
    private CountNode<T> next;

    /**
     * constructor for CountNode class, that assigns the private variables
     * @param data given data
     * @param next given next CountNode 
     */
    public CountNode(T data, CountNode<T> next) {
        this.data = data;
        this.next = next;
        this.count = 1;
    }

    /**
     * method that return data
     * @return data
     */
    public T getData() {
        return this.data;
    }

    /**
     * method that return count
     * @return count
     */
    public int getCount() {
        return this.count;
    }

    /**
     * method that increment the count by 1
     */
    public void countUp() {
        this.count += 1;
    }

    /**
     * method that decrement the count by 1
     */
    public void countDown() {
        if (this.count > 0) {
            this.count -= 1;
        }
    }

    /**
     * method that return the next CountNode
     * @return next
     */
    public CountNode<T> getNext() {
        return this.next;
    }

    /**
     * method that set the next CountNode with given next CountNode
     * @param next given next CountNode
     */
    public void setNext(CountNode<T> next) {
        this.next = next;
    }

    public String toString() {
        return this.data + ":" + this.count;
    }
}