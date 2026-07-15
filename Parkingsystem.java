class ParkingSystem {

    private int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        slots = new int[]{0, big, medium, small}; // index 0 unused, matches carType 1/2/3
    }

    public boolean addCar(int carType) {
        if (slots[carType] > 0) {
            slots[carType]--;
            return true;
        }
        return false;
    }
}