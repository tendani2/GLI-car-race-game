package za.co.gli.util;

import java.util.Comparator;

import za.co.gli.model.Car;

/**
 * CarComparator
 * 
 * @author tendani
 *
 */
public class CarComparator implements Comparator<Car> {

	@Override
	public int compare(Car car1, Car car2) {
		return car2.getTotalAcceleration() - car1.getTotalAcceleration();
	}
}
