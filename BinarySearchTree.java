/* *****************************************************************************
 *  Name:    Eli Ji
 *  Description:  Implementation of a Binary Search Tree
 **************************************************************************** */

public class BinarySearchTree<Item> {

    private Node root;
    private int size;

    private class Node {
        Node left;
        Node right;
        int key;
        Item val;
    }

    public BinarySearchTree(){
        this.size = 0;
    }

    public void put(int key, Item val){
        Node newNode = new Node();
        newNode.key = key;
        newNode.val = val;

        Node current = root;
        while(current!=null) {
            if (key == current.key) {
                current.val = val;
            } else if (key < current.key) {
                current = current.left;
            } else if (key > current.key) {
                current = current.right;
            }
        }
        current = newNode;
        size++;
    }

    public boolean contains(int key){

        Node current = root;
        while(current!=null) {
            if (key == current.key) {
                return true;
            } else if (key < current.key) {
                current = current.left;
            } else if (key > current.key) {
                current = current.right;
            }
        }
        return false;
    }

    public void delete(int key) {

    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public int max(){
        Node current = root;
        Node temp = new Node();
        while(current != null){
            temp = current;
            current = current.right;
        }
        return temp.key;
    }

    public int min(){
        Node current = root;
        Node temp = new Node();
        while(current != null){
            temp = current;
            current = current.left;
        }
        return temp.key;
    }

    public int height(){
        return heightWrapper(root);
    }

    public int heightWrapper(Node node)
    {
        if (node == null)
            return 0;
        else {
            int lHeight = heightWrapper(node.left);
            int rHeight = heightWrapper(node.right);

            if (lHeight > rHeight)
                return (lHeight + 1);
            else
                return (rHeight + 1);
        }
    }

    void inorder(Node node)
    {
        if (node == null)
            return;

        inorder(node.left);

        System.out.print(node.key + " ");

        inorder(node.right);
    }

    void preorder(Node node)
    {
        if (node == null)
            return;

        System.out.print(node.key + " ");

        preorder(node.left);

        preorder(node.right);
    }


    void postorder(Node node)
    {
        if (node == null)
            return;

        postorder(node.left);

        postorder(node.right);

        System.out.print(node.key + " ");
    }


    public static void main(String[] args) {
        BinarySearchTree<Integer> myBST = new BinarySearchTree<Integer>();
        myBST.put(5,5);
        System.out.println(myBST.root.key);
        //System.out.println(myBST.contains(4));
    }
}
