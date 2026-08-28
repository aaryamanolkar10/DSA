class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;
}

class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode curNode = root;

        for (char curChar : word.toCharArray()) {

            if (!curNode.children.containsKey(curChar)) {
                curNode.children.put(curChar, new TrieNode());
            }

            curNode = curNode.children.get(curChar);
        }

        curNode.isWord = true;
    }

    public boolean search(String word) {

        TrieNode curNode = root;

        for (char curChar : word.toCharArray()) {

            if (!curNode.children.containsKey(curChar)) {
                return false;
            }

            curNode = curNode.children.get(curChar);
        }

        return curNode.isWord;
    }

    public boolean startsWith(String prefix) {

        TrieNode curNode = root;

        for (char curChar : prefix.toCharArray()) {

            if (!curNode.children.containsKey(curChar)) {
                return false;
            }

            curNode = curNode.children.get(curChar);
        }

        return true;
    }
}