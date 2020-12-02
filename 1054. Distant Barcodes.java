class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCur = 0;
        int maxNum = -1;
        for (int barcode: barcodes){
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
            if (map.get(barcode) > maxCur){
                maxCur = map.get(barcode);
                maxNum = barcode;
            }
        }
        int start = 0;
        for (; start < barcodes.length; start += 2){
            barcodes[start] = maxNum;
            map.put(maxNum, map.get(maxNum) - 1);
            if (map.get(maxNum) == 0) break;
        }
        start += 2;
        for (int barcode: map.keySet()){
            for (int i = 0; i < map.get(barcode); i++){
                if (start >= barcodes.length) start = 1;
                barcodes[start] = barcode;
                start += 2;
            }
        }
        return barcodes;
    }
}