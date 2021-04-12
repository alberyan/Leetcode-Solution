class Solution {

    double radius;
    double xC;
    double yC;
    
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.xC = x_center;
        this.yC = y_center;
    }
    
    public double[] randPoint() {
        double len = Math.sqrt(Math.random()) * radius;
        double deg = Math.random() * 2 * Math.PI;
        return new double[]{len * Math.cos(deg) + xC, len * Math.sin(deg) + yC};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */