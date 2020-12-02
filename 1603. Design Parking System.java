class ParkingSystem {
    int[] arr;
    
    public ParkingSystem(int big, int medium, int small) {
        arr = new int[]{0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if (--arr[carType] < 0) return false;
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */