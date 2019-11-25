class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[] hor = new int[50];
        int[] ver = new int[50];
        for (int[] indice: indices){
            hor[indice[0]]++;
            ver[indice[1]]++;
        }
        int res = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if ((hor[i] + ver[j]) % 2 != 0) res++;
            }
        }
        return res;
    }
}

//Acc