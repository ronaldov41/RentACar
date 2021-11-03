package ooc.yoursolution;

import java.util.HashMap;
import java.util.Map;

import ooc.enums.Make;
import ooc.enums.Month;

/**
 * @author Vianna
 */
public class Car implements CarInterface {

    private Make make;
    private double rate;
    private final int id;
    private Map<Month, boolean[]> availability;

    public Car(Make make, double rate, int id) {
        setMake(make);
        setRate(rate);
        this.id = id;
        this.availability = createAvailability();
    }

    @Override
    public Map<Month, boolean[]> createAvailability() {
        Map<Month, boolean[]> availability = new HashMap<>();
        for (Month month : Month.values()) {
            boolean[] days = new boolean[month.getNumberOfDays()];
            for (int i = 0; i < month.getNumberOfDays(); i++) days[i] = true;
            availability.put(month, days);
        }
        return availability;
    }

    @Override
    public Make getMake() {
        return make;
    }

    @Override
    public void setMake(Make make) {
        this.make = make;
    }

    @Override
    public double getRate() {
        return rate;
    }

    @Override
    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public Map<Month, boolean[]> getAvailability() {
        return availability;
    }

    @Override
    public void setAvailability(Map<Month, boolean[]> availability) {
        this.availability = availability;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean isAvailable(Month month, int day) {
        return availability.get(month)[day - 1];
    }

    @Override
    public boolean book(Month month, int day) {
        if (isAvailable(month, day)) {
            availability.get(month)[day - 1] = false;
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        String bookings = "";
        for (Month month : availability.keySet()) {
            bookings = String.format("%s%s:\n", bookings, month.name());
            int i = 1;
            for (boolean day : availability.get(month)) {
                bookings = String.format("%s%d:%b | ", bookings, i, day);
                i++;
            }
            bookings = String.format("%s\n", bookings);

        }
        return String.format("Id: %d, Make: %s, Rate: $%.2f, Booking: %s", getId(), getMake().name(), getRate(), bookings);
    }

}
