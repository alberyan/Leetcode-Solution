class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int total = 0;
        int between = 0;
        if (start > destination){
        	int tmp = start;
        	start = destination;
        	destination = tmp;
        }
        for (int i = 0; i < distance.length; i++){
        	total += distance[i];
        	if (i >= start && i < destination){
        		between += distance[i];
        	}
        }
        return Math.min(total - between, between);
    }
}

//ACC