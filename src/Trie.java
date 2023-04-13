class TrieNode {
    boolean isEndOfWord;
    TrieNode[] children;
    String replaceWord;

    public TrieNode() {
        isEndOfWord = false;
        children = new TrieNode[26];
        replaceWord = null;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word, String fullWord) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'A';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
        node.replaceWord = fullWord;
    }

    public String search(String word) {
        word.toUpperCase();
        if(!isValid(word))
            return null;
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'A';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node.replaceWord;
    }

    public static boolean isValid(String st){
        for(int i = 0; i < st.length(); i ++){
            if(st.charAt(i) < 'A' || st.charAt(i) > 'Z')
                return false;
        }
        return true;
    }

}