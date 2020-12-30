class Trie {
    
    static final int ALPHABET_SIZE = 26;
    private TrieNode root;
    static class TrieNode {
        TrieNode children[];
        boolean isEnd;
        TrieNode() {
            children = new TrieNode[ALPHABET_SIZE];
            isEnd = false;
        }
    }
    Trie() {
        root =  new TrieNode();
    }
    public void insert(String word) {
        TrieNode node = root;
        for(int level = 0 ; level < word.length() ; level++) {
            int idx = word.charAt(level) - 'a';
            if(node.children[idx] == null)
                node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(int level = 0 ; level < word.length() ; level++) {
            int idx = word.charAt(level) - 'a';
            if(node.children[idx] == null)
                return false;
            node = node.children[idx];
        }
        return node != null && node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int level = 0 ; level < prefix.length() ; level++) {
            int idx = prefix.charAt(level) - 'a';
            if(node.children[idx] == null)
                return false;
            node = node.children[idx];
        }
        return true;
    }
}