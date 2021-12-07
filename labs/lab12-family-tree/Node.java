// Jingxian Chai

public class Node {
    private String name;
    private Node father;
    private Node mother;

    /**
     * constructor for Node class
     * @param name given name
     */
    public Node(String name) {
        this.name = name;
        this.father = null;
        this.mother = null;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public Node getMother() {
        return mother;
    }

    public void setMother(Node mother) {
        this.mother = mother;
    }

    public String getName() {
        return name;
    }
}