/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import ooc.enums.Make;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vianna
 */
public class BookingSystem implements BookingSystemInterface {

    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {
        String name = in.readLine();
        List<CarInterface> cars = new ArrayList<>();

        int id = 0;

        while (in.ready()) {
            String[] carDetails = in.readLine().split(":");
            int amount =
                    Integer.parseInt(carDetails[2]);
            for (int i = 0; i < amount; i++) {
                CarInterface car = new Car(Make.valueOf(carDetails[0]), Double.parseDouble(carDetails[1]), id);
                cars.add(car);
                id++;
            }
        }

        return new RentACar(name, cars);
    }

}
