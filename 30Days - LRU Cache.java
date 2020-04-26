class LRUCache {
    class Node {
        Node pre;
        Node next;
        int val;
        public Node(int val) {
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }

    Map<Integer, Node> map;
    Node head;
    Node lastNode;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1);
        lastNode = head;
    }
    
    public int get(int key) {
        Node curNode = map.get(key);
        if (curNode != null && curNode.pre != null) {
            moveToLast(curNode);
            return curNode.val;
        }
        else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node curNode = map.get(key);
        if (curNode != null && curNode.pre != null) {
            curNode.val = value;
            moveToLast(curNode);
        }
        else {
            Node node = new Node(value);
            addToLast(node);
            size++;
            if (size > capacity) {
                remove(head.next);
            }
            map.put(key, node);
        }
    }

    private void moveToLast(Node node) {
        if (node == lastNode) { return; }
        remove(node);
        addToLast(node);
    }

    private void addToLast(Node node) {
        lastNode.next = node;
        node.pre = lastNode;
        lastNode = node;
    }

    private void remove(Node node) {
        Node preNode = node.pre;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        node.next = null;
        node.pre = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

 //ACC