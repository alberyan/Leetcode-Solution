class Solution {
    String s;
    Node root = new Node(-1, new int[]{-1});
    ActivePoint activePoint = new ActivePoint(root, 0);
    int remainingNumber = 0, prefixCount = 0;
    int[] leafEnd = new int[]{-1}, lcp = new int[]{-1, -1};

    class ActivePoint {
        Node activeNode;
        int activeLength;
        int activeCharIndex;

        public ActivePoint(Node node, int length) {
            this.activeNode = node;
            activeLength = length;
        }

        public boolean walkDown() {
            Node child = activeNode.children.get(s.charAt(activeCharIndex));
            if (activeLength >= child.edgeLength()) {
                activeCharIndex += child.edgeLength();
                activeLength -= child.edgeLength();
                activeNode = child;
                return true;
            }
            return false;
        }
    }

    class Node {
        int start;
        int[] end;
        Map<Character, Node> children;
        Node suffixLink;

        public Node(int start, int[] end) {
            this.start = start;
            this.end = end;
            children = new HashMap<>();
        }

        public int edgeLength() {
            return end[0] - start;
        }
    }

    private void phase(int i) {
        Node lastNewNode = null;
        char sChar = s.charAt(i);
        leafEnd[0] = i + 1;
        remainingNumber++;
        // loop through extensions
        while (remainingNumber > 0) {
            if (activePoint.activeLength == 0) {
                activePoint.activeCharIndex = i;
            }
            char activeChar = s.charAt(activePoint.activeCharIndex);
            if (activePoint.activeNode.children.containsKey(activeChar)) {
                if (activePoint.walkDown()) {
                    continue;
                }

                Node next = activePoint.activeNode.children.get(activeChar);
                int nextCurIndex = next.start + activePoint.activeLength;
                char nextChar = s.charAt(nextCurIndex);

                //Rule 3
                if (nextChar == sChar) {
                    activePoint.activeLength++;
                    prefixCount++;
                    if (lcp[0] == -1 || lcp[1] - lcp[0] < prefixCount) {
                        lcp[0] = nextCurIndex + 1 - prefixCount;
                        lcp[1] = nextCurIndex + 1;
                    }
                    // set the suffix link
                    if (lastNewNode != null) {
                        lastNewNode.suffixLink = activePoint.activeNode;
                    }
                    break;
                }

                //Rule 2
                //// create the internal node
                Node internal = new Node(next.start, new int[]{nextCurIndex});
                activePoint.activeNode.children.put(activeChar, internal);
                if (lcp[0] == -1 || lcp[1] - lcp[0] < prefixCount) {
                    lcp[0] = internal.end[0] - prefixCount;
                    lcp[1] = internal.end[0];
                }

                //// update the next node and put as the internal node children
                next.start = nextCurIndex;
                internal.children.put(nextChar, next);

                //// create the leaf node
                Node leaf = new Node(i, leafEnd);
                internal.children.put(sChar, leaf);

                // set the suffix link
                if (lastNewNode != null) {
                    lastNewNode.suffixLink = internal;
                }
                lastNewNode = internal;
            } else {
                // Rule 2
                Node leaf = new Node(i, leafEnd);
                activePoint.activeNode.children.put(activeChar, leaf);
                // set the suffix link
                if (lastNewNode != null) {
                    lastNewNode.suffixLink = activePoint.activeNode;
                    lastNewNode = null;
                }
            }

            remainingNumber--;
            // update the activePoint
            if (activePoint.activeNode == root && activePoint.activeLength > 0) {
                activePoint.activeCharIndex = i - remainingNumber + 1;
                activePoint.activeLength--;
            } else if (activePoint.activeNode != root) {
                activePoint.activeNode = activePoint.activeNode.suffixLink;
            }

            if (prefixCount > 0) {
                prefixCount--;
            }
        }
    }

    public void buildSuffixTree() {
        for (int i = 0; i < s.length(); i++) {
            phase(i);
        }
    }
    
    public String longestDupSubstring(String S) {
        s = S;
        buildSuffixTree();
        return lcp[0] == -1 ? "" : s.substring(lcp[0], lcp[1]);
    }
}

// ACC