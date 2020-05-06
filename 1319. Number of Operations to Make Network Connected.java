import java.util.HashSet;
import java.util.Set;

class Solution {
    public int makeConnected(int n, int[][] connections) {
        int connectionCount = connections.length;
        if (connectionCount < n - 1) return -1;
        int[] root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = -1;
        }
        for (int[] connection: connections){
            int com1 = connection[0];
            int com2 = connection[1];
            if (root[com1] == -1 && root[com2] == -1) {
                root[com1] = com1;
                root[com2] = com1;
            }
            else if (root[com1] == -1) {
                root[com1] = root[com2];
            }
            else if (root[com2] == -1) {
                root[com2] = root[com1];
            }
            else {
                int deepestCom2 = findRoot(root, com2);
                int deepestCom1 = findRoot(root, com1);
                root[deepestCom2] = deepestCom1;
                root[com2] = deepestCom1;
                root[com1] = deepestCom1;
            }
        }
        int isolate = 0;
        Set<Integer> rootSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (root[i] == -1) isolate++;
            else rootSet.add(findRoot(root, i));
        }
        return isolate + rootSet.size() - 1;
    }

    private int findRoot(int[] root, int com) {
        if (root[com] == -1) return -1;
        if (root[com] == com) return com;
        return findRoot(root, root[com]);
    }
}

// Runtime: 6 ms, faster than 75.91% of Java online submissions for Number of Operations to Make Network Connected.
// Memory Usage: 60.7 MB, less than 100.00% of Java online submissions for Number of Operations to Make Network Connected.