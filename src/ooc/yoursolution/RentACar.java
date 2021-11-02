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
 *
 * @author Vianna
 */
public class RentACar implements RentACarInterface {

	@Override
	public List<CarInterface> getCars() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCars(List<CarInterface> cars) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getNumberOfCars() {
		// TODO Auto-generated method stub
		return 0;
	}
    
}
