class SolutionTLE {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (N == 0) return cells;
        int[] cur = cells;
        int[] next = new int[8];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < 7; j++) {
                next[j] = 1 - (cur[j - 1] ^ cur[j + 1]);
            }
            cur = next;
            next = new int[8];
        }
        return cur;
    }
}

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> seen = new HashMap<>();
        while (N > 0) {
            int[] cells2 = new int[8];
            seen.put(Arrays.toString(cells), N--);
            for (int i = 1; i < 7; i++)
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            cells = cells2;
            if (seen.containsKey(Arrays.toString(cells))) {
                N %= seen.get(Arrays.toString(cells)) - N;
            }
        }
        return cells;
    }
}

// ACC