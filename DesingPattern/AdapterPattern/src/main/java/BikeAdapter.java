public class BikeAdapter implements Vehicle {
    private Bike bike;

    public BikeAdapter(Bike bike) {
        this.bike = bike;
    }

    public void tireCount() {
        bike.wheelCount();
    }
}
