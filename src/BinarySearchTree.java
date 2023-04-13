class Node {
    long key;
    String value;
    Node left;
    Node right;

    public Node(long key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(String key, String value) {
        root = insertHelper(root, hash(key), value);
    }

    private Node insertHelper(Node node, long key, String value) {
        if (node == null) {
            return new Node(key, value);
        }

        if (key < node.key) {
            node.left = insertHelper(node.left, key, value);
        } else if (key > node.key) {
            node.right = insertHelper(node.right, key, value);
        } else {
            // If the key already exists, update the value
            node.value = value;
        }

        return node;
    }

    public String search(String key) {
        Node node = searchHelper(root, hash(key));
        if (node == null) {
            return null;
        } else {
            return node.value;
        }
    }

    private Node searchHelper(Node node, long key) {
        if (node == null || node.key == key) {
            return node;
        }

        if (key < node.key) {
            return searchHelper(node.left, key);
        } else {
            return searchHelper(node.right, key);
        }
    }

    public long hash(String st){
        long ans = 0;
        int k = 1;
        for(int i = 0; i < st.length(); i ++){
            int c = st.charAt(i) - 'A';
            ans += c * k;
            k *= 26;
        }
        return ans;
    }
}