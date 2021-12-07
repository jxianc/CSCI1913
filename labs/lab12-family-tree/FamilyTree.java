// Jingxian Chai

public class FamilyTree {
    private Node root;

    /**
     * constructor for FamilyTree class
     * @param ego given name
     */
    public FamilyTree(String ego) {
        this.root = new Node(ego);
    }

    /**
     * method that find the node that has the given name
     * @param name given name
     * @return node if it exits, else null
     */
    private Node find(String name) {
        return find(name, root);
    }

    /**
     * method that find the node that has the given name from the given root
     * @param name given name
     * @param root given root
     * @return node if it exists, else null
     */
    private Node find(String name, Node root) {
        if (root == null) {
            return null;
        }

        if (root.getName().equals(name)) {
            return root;
        }

        Node fatherSide = find(name, root.getFather());
        Node motherSide = find(name, root.getMother());
        if (fatherSide != null) {
            return fatherSide;
        } else if (motherSide != null) {
            return motherSide;
        } else {
            return null;
        }
    }

    /**
     * method that add given parents to the node that has the given name
     * @param ego given name
     * @param father given father
     * @param mother given mother
     */
    public void addParents(String ego, String father, String mother) {
        Node child = find(ego);
        if (child != null) {
            child.setFather(new Node(father));
            child.setMother(new Node(mother));
        }
    }

    /**
     * method that return the mother name of the node that has the given name
     * @param ego given name
     * @return mother name of the node
     */
    public String getMotherByName(String ego) {
        Node child = find(ego);
        if (child != null) {
            Node mother = child.getMother();
            if (mother != null) {
                return mother.getName();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * method that return the father name of the node that has the given name
     * @param ego given name
     * @return father name of the node
     */
    public String getFatherByName(String ego) {
        Node child = find(ego);
        if (child != null) {
            Node father = child.getFather();
            if (father != null) {
                return father.getName();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * method that find if the child is descendant from the ancestor by given child name and ancestor name
     * @param ego given child name
     * @param ancestor given ancestor name
     * @return true if the child is descendant from the ancestor
     */
    public boolean isDescendant(String ego, String ancestor) {
        Node child = find(ego);
        Node ancestorNode = find(ancestor);
        if (child == null && ancestorNode == null) {
            return false;
        } else {
            return isDescendant(child, ancestorNode);
        }
    }

    /**
     * method that find if the child is descendant from the ancestor by given child node and ancestor node
     * @param root given child node
     * @param ancestor given ancestor node
     * @return true if the child is descendant from the ancestor
     */
    private boolean isDescendant(Node root, Node ancestor) {
        if (root == null) {
            return false;
        }
        if (root == ancestor) {
            return true;
        } else {
            return isDescendant(root.getFather(), ancestor) || isDescendant(root.getMother(), ancestor);
        }
    }
}
