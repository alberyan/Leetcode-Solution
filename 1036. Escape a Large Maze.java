class Solution {

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length < 2) return true;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Long mul = 1000000L;
        Set<Long> blockSet = new HashSet<>();
        for (int[] block: blocked){
            blockSet.add(block[0] * mul + block[1]);
        }
        Set<Long> visitedSource = new HashSet<>();
        Set<Long> visitedTarget = new HashSet<>();
        Queue<Long> qSource = new LinkedList<>();
        Queue<Long> qTarget = new LinkedList<>();
        qSource.offer(source[0] * mul + source[1]);
        visitedSource.add(source[0] * mul + source[1]);
        qTarget.offer(target[0] * mul + target[1]);
        visitedTarget.add(target[0] * mul + target[1]);
        while (!qSource.isEmpty() && !qTarget.isEmpty()){
            long curSource = qSource.poll();
            long x = curSource / mul;
            long y = curSource % mul;
            for (int i = 0; i < 4; i++){
                long newX = x + dirs[i][0];
                long newY = y + dirs[i][1];
                if (newX < 0 || newX >= mul || newY < 0 || newY >= mul){
                    continue;
                }
                long newSum = newX * mul + newY;
                if (blockSet.contains(newSum)){
                    continue;
                }
                if (visitedSource.contains(newSum)){
                    continue;
                }
                if (visitedTarget.contains(newSum)){
                    return true;
                }
                qSource.offer(newSum);
                visitedSource.add(newSum);
            }
            long curTarget = qTarget.poll();
            x = curTarget / mul;
            y = curTarget % mul;
            for (int i = 0; i < 4; i++){
                long newX = x + dirs[i][0];
                long newY = y + dirs[i][1];
                if (newX < 0 || newX >= mul || newY < 0 || newY >= mul){
                    continue;
                }
                long newSum = newX * mul + newY;
                if (blockSet.contains(newSum)){
                    continue;
                }
                if (visitedTarget.contains(newSum)){
                    continue;
                }
                if (visitedSource.contains(newSum)){
                    return true;
                }
                qTarget.offer(newSum);
                visitedTarget.add(newSum);
            }
        }
        return false;
    }
}

// BFS TLE
