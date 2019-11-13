class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] isQ = new boolean[8][8];
        for (int[] queen: queens){
        	isQ[queen[0]][queen[1]] = true;
        }
       	for (int i = -1; i <= 1; i++){
       		for (int j = -1; j <= 1; j++){
       			if (i ==0 && j == 0) continue;
       			int curX = king[0];
       			int curY = king[1];
       			while (curX >= 0 && curX < 8 && curY >= 0 && curY < 8){
       				if (isQ[curX][curY]){
       					List<Integer> cur = new ArrayList<>();
       					cur.add(curX);
       					cur.add(curY);
       					res.add(cur);
       					break;
       				}
       				curX += i;
       				curY += j;
       			}
       		}
       	}
       	return res;
    }
}

//ACC

class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        List<PriorityQueue<List<Integer>>> list = new ArrayList<>();
        for (int i = 0; i < 8; i++){
        	PriorityQueue<List<Integer>> pq = new PriorityQueue<>((l1, l2) -> Math.abs(l1.get(0) - king[0]) + Math.abs(l1.get(1) - king[1]) - Math.abs(l2.get(0) - king[0]) - Math.abs(l2.get(1) - king[1]));
        	list.add(pq);
        }
        for (int[] queen: queens){
        	int x = queen[0] - king[0];
        	int y = queen[1] - king[1];
        	List<Integer> cur = new ArrayList<>();
        	cur.add(queen[0]);
        	cur.add(queen[1]);
        	if (x == 0 && y > 0) list.get(0).offer(cur);
        	else if (x == 0 && y < 0) list.get(1).offer(cur);
        	else if (x > 0 && y == 0) list.get(2).offer(cur);
        	else if (x < 0 && y == 0) list.get(3).offer(cur);
        	else if (x == y && y < 0) list.get(4).offer(cur);
        	else if (x == y && y > 0) list.get(5).offer(cur);
        	else if (x == -y && y < 0) list.get(6).offer(cur);
        	else if (x == -y && y > 0) list.get(7).offer(cur);
        }
        for (int i = 0; i < 8; i++){
        	PriorityQueue<List<Integer>> pq = list.get(i);
        	if (!pq.isEmpty()){
        		res.add(pq.peek());
        	}
        }
       	return res;
    }
}

//ACC