import org.junit.Test;

public class AdapterPatternTester {

    @Test
    public void trigger(){
        Vehicle car= new Car();
        Vehicle motor= new MotorCycle();
        Vehicle bike = new BikeAdapter(new Bike());

        car.tireCount();
        motor.tireCount();
        bike.tireCount();
    }
}
