class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new LinkedList<>();
        int i1 = 0, i2 = 0, i3 = 0;
        while (i1 < arr1.length && i2 < arr2.length && i3 < arr3.length){
        	int a1 = arr1[i1];
        	int a2 = arr2[i2];
        	int a3 = arr3[i3];
        	if (a1 == a2 && a2 == a3){
        		res.add(a1);
        		i1++;
        		i2++;
        		i3++;
        	} else if (a1 <= a2 && a1 <= a3){
        		i1++;
        	} else if (a2 <= a1 && a2 <= a3){
        		i2++;
        	} else {
        		i3++;
        	}
        }
        return res;
    }
}

//ACC