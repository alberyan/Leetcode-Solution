class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        if (tomatoSlices > cheeseSlices * 4 || tomatoSlices < cheeseSlices * 2 || tomatoSlices % 2 != 0 || cheeseSlices < 0) return res;
        int jumbo = (tomatoSlices - cheeseSlices * 2) / 2;
        res.add(jumbo);
        res.add(cheeseSlices - jumbo);
        return res;
    }
}