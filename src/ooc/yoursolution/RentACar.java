/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import java.util.List;

import ooc.enums.Make;
import ooc.enums.Month;

/**
 * @author Vianna
 */
public class RentACar implements RentACarInterface {

    private List<CarInterface> cars;
    private String name;

    public RentACar(String name, List<CarInterface> cars) {
        setName(name);
        setCars(cars);
    }

    @Override
    public List<CarInterface> getCars() {
        return cars;
    }

    @Override
    public void setCars(List<CarInterface> cars) {
        this.cars = cars;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent) {
        for (CarInterface car : cars) {
            if (car.getMake().equals(make)) {
                return checkAvailability(car, month, day, lengthOfRent);
            }
        }
        return false;
    }

    private boolean checkAvailability(CarInterface car, Month month, int day, int lengthOfRent) {
        if (month.getNumberOfDays() > day + lengthOfRent) {
            return isAvailable(car, month, day, day + lengthOfRent);
        } else {
            boolean isAvailable = isAvailable(car, month, day, month.getNumberOfDays());

            int lastDay = (day + lengthOfRent) - month.getNumberOfDays();
            Month nextMonth = month.next();

            // check if the length of rent is more than 1 month
            while (lastDay > nextMonth.getNumberOfDays()) {
                isAvailable = isAvailable && isAvailable(car, nextMonth, 1, nextMonth.getNumberOfDays());

                lastDay = lastDay - nextMonth.getNumberOfDays();
                nextMonth = nextMonth.next();
            }

            // check remaining days
            if (lastDay > 0) {
                isAvailable = isAvailable && isAvailable(car, nextMonth, 1, lastDay);
            }

            return isAvailable;
        }
    }

    private boolean isAvailable(CarInterface car, Month month, int day, int lastDay) {
        boolean isAvailable = true;
        for (int i = day; i < lastDay; i++) {
            isAvailable = isAvailable && car.isAvailable(month, i);
        }
        return isAvailable;
    }

    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {
        for (CarInterface car : cars) {
            if (car.getMake().equals(make) && checkAvailability(car, month, day, lengthOfRent)) {
                return car.getId();
            }
        }
        return -1;
    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
        for (CarInterface car : cars) {
            boolean isAvailable = checkAvailability(car, month, day, lengthOfRent);
            if (car.getMake().equals(make) && isAvailable) {
                return  bookCar(car, month, day, lengthOfRent);
            }
        }
        return false;
    }

    private boolean bookCar(CarInterface car, Month month, int day, int lengthOfRent) {
        if (checkAvailability(car, month, day, lengthOfRent)) {
            if (month.getNumberOfDays() > day + lengthOfRent) {
                for (int i = day; i < day + lengthOfRent; i++) {
                    car.book(month, i);
                }
                return true;
            } else {
                for (int i = day; i < month.getNumberOfDays(); i++) {
                    car.book(month, i);
                }

                int lastDay = (day + lengthOfRent) - month.getNumberOfDays();
                Month nextMonth = month.next();

                // check if the length of rent is more than 1 month
                while (lastDay > nextMonth.getNumberOfDays()) {
                    for (int i = 1; i < nextMonth.getNumberOfDays(); i++) {
                        car.book(month, i);
                    }

                    lastDay = lastDay - nextMonth.getNumberOfDays();
                    nextMonth = nextMonth.next();
                }

                // Booking on remaining days
                if (lastDay > 0) {
                    for (int i = 1; i < lastDay; i++) {
                        car.book(month, i);
                    }
                }

                return true;
            }
        }
        return false;
    }

    @Override
    public int getNumberOfCars() {
        return cars.size();
    }

}
