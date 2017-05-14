package za.co.gli.util;

import java.util.Collections;
import java.util.List;

import za.co.gli.model.Car;

/**
 * GameUtils
 * @author tendani
 *
 */
public class GameUtils {
	
	/**
	 * Gets the sum of integers in the array
	 * @param list
	 * @return
	 */
	public static Integer sum(List<Integer> list){
		// Base case:
		// Nothing to sum.
		if(list.isEmpty()){
			return null;
		}
		
		int sum = 0;
		for (Integer value : list) {
			sum += value;
		}
		// Return sum.
		return sum;
	}
	/**
	 * Sort cars on total Acceleration.
	 * @param cars
	 */
	public static void sort(List<Car> cars){
		Collections.sort(cars, new CarComparator());
	}
}
