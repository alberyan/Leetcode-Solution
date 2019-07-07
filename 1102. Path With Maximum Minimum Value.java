class Solution {
	public int maximumMinimumPath(int[][] A) {
		int r = A.length;
		int c = A[0].length;
		int min = Integer.MAX_VALUE;
		int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		boolean[][] visited = new boolean[r][c];
		Queue<int[]> q = new PriorityQueue<int[]>((c1, c2) -> c2[0] - c1[0]);
		q.add(new int[] { A[0][0], 0, 0 });
		while (!q.isEmpty()) {
			int[] t = q.poll();
			min = Math.min(min, t[0]);
			int i = t[1];
			int j = t[2];
			if (i == r - 1 && j == c - 1) return min;
			for (int[] dir : dirs) {
				int x = i + dir[0];
				int y = j + dir[1];
				if (x < 0 || x >= r || y < 0 || y >= c || visited[x][y]) continue;
				visited[x][y] = true;
				q.add(new int[] { A[x][y], x, y });
			}
		}
		return min;
	}
}

// Runtime: 153 ms, faster than 66.06% of Java online submissions for Path With Maximum Minimum Value.
// Memory Usage: 54.1 MB, less than 100.00% of Java online submissions for Path With Maximum Minimum Value.
