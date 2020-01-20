class Solution {
	class Node {
		List<String> list;
		Node[] children;

		Node() {
			list = new ArrayList<>();
			children = new Node[26];
		}
	}

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();
        for (String product: products) {
        	scan(root, product);
        }
        List<List<String>> res = new ArrayList<>();
        Node cur = root;
        for (int i = 0; i < searchWord.length(); i++){
        	char ch = searchWord.charAt(i);
        	if (cur.children[ch - 'a'] == null){
        		for (int j = i; j < searchWord.length(); j++){
        			res.add(new ArrayList());
        		}
        		break;
        	}
        	cur = cur.children[ch - 'a'];
        	Collections.sort(cur.list);
        	List<String> curList = new ArrayList<>();
        	for (int j = 0; j < 3 && j < cur.list.size(); j++){
        		curList.add(cur.list.get(j));
        	}
        	res.add(curList);
        }
        return res;
    }

    void scan(Node root, String product){
    	Node cur = root;
    	for (char ch: product.toCharArray()){
    		if (cur.children[ch - 'a'] == null) {
    			cur.children[ch - 'a'] = new Node();
    		}
    		cur = cur.children[ch - 'a'];
    		cur.list.add(product);
    	}
    }
}

//ACC