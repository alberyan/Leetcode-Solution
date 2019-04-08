// O(n!)
class Solution {
    int min;

    public int videoStitching(int[][] clips, int T) {
        min = Integer.MAX_VALUE;
        boolean[] visited = new boolean[clips.length];
        videoStitching(clips, visited, 0, T, 0);
        return min == Integer.MAX_VALUE ? -1: min;
    }

    void videoStitching(int[][] clips, boolean[] visited, int start, int end, int clipsUsed){
        for (int i = 0; i < clips.length; i++){
            if (visited[i]) continue;
            int[] clip = clips[i];
            if (clip[0] > start) continue;
            if (clip[1] <= start) continue;
            if (clip[1] >= end){
                min = Math.min(min, clipsUsed + 1);
                return;
            }
            visited[i] = true;
            videoStitching(clips, visited, clip[1], end, clipsUsed + 1);
            visited[i] = false;
        }
    }
}

//DP
class Solution {
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] clip: clips){
            List<Integer> list = map.getOrDefault(clip[0], new ArrayList<>());
            list.add(clip[1]);
            map.put(clip[0], list);
        }
        for (int i = 0; i <= T; i++){
            if (dp[i] == Integer.MAX_VALUE) return -1;
            List<Integer> list = map.get(i);
            if (list == null) continue;
            for (int end: list){
                for (int j = i + 1; j <= Math.min(end, T); j++){
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
        }
        return dp[T];
    }
}

// Runtime: 2 ms, faster than 100.00% of Java online submissions for Video Stitching.
// Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Video Stitching.
